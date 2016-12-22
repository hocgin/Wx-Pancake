package in.hocg.app.services.impl;

import in.hocg.app.handler.$Handler;
import in.hocg.app.handler.ConsoleHandler;
import in.hocg.app.handler.TestHandler;
import in.hocg.app.services.CoreService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Created by hocgin on 16-12-17.
 */
@Service
public class CoreServiceImpl implements CoreService {
	@Autowired
	protected WxMpService wxMpService;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private WxMpMessageRouter router;
	
	/**
	 * Handler
	 */
	@Autowired
	private ConsoleHandler consoleHandler;
	@Autowired
	private $Handler $handler;
	@Autowired
	private TestHandler testHandler;
	
	@PostConstruct
	public void init() {
		this.refreshRouter();
	}
	
	@Override
	public void requestGet(String urlWithParams) throws IOException {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		HttpGet httpget = new HttpGet(urlWithParams);
		httpget.addHeader("Content-Type", "text/html;charset=UTF-8");
		//配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectionRequestTimeout(50)
				.setConnectTimeout(50)
				.setSocketTimeout(50).build();
		httpget.setConfig(requestConfig);
		
		CloseableHttpResponse response = httpclient.execute(httpget);
		System.out.println("StatusCode -> " + response.getStatusLine().getStatusCode());
		
		HttpEntity entity = response.getEntity();
		String jsonStr = EntityUtils.toString(entity);
		System.out.println(jsonStr);
		
		httpget.releaseConnection();
	}
	
	@Override
	public void requestPost(String url, List<NameValuePair> params) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClientBuilder.create().build();
		
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(new UrlEncodedFormEntity(params, StandardCharsets.UTF_8));
		
		CloseableHttpResponse response = httpclient.execute(httppost);
		System.out.println(response.toString());
		
		HttpEntity entity = response.getEntity();
		String jsonStr = EntityUtils.toString(entity, "utf-8");
		System.out.println(jsonStr);
		
		httppost.releaseConnection();
	}
	
	@Override
	public void refreshRouter() {
		final WxMpMessageRouter newRouter = new WxMpMessageRouter(
				this.wxMpService);
		// todo 对消息进行处理
		// 记录所有事件的日志
		newRouter.rule().handler(this.consoleHandler).next();
//		// 关注事件
//		newRouter.rule().async(false).msgType(WxConsts.XML_MSG_EVENT)
//				.event(WxConsts.EVT_SUBSCRIBE).handler(this.subscribeHandler)
//				.end();
//		// 默认,转发消息给客服人员
		newRouter.rule() // #指令 处理器
				.rContent("^#[^#]+")
				.handler(this.$handler)
				.next().rule()
				.handler(this.testHandler)
				.end();
		this.router = newRouter;
	}
	
	@Override
	public WxMpXmlOutMessage route(WxMpXmlMessage inMessage) {
		try {
			return this.router.route(inMessage);
		} catch (Exception e) {
			this.logger.error(e.getMessage(), e);
		}
		
		return null;
	}
	
	@Override
	public WxMpUser getUserInfo(String openid, String lang) {
		WxMpUser wxMpUser = null;
		try {
			wxMpUser = this.wxMpService.getUserService().userInfo(openid, lang);
		} catch (WxErrorException e) {
			this.logger.error(e.getError().toString());
		}
		return wxMpUser;
	}
}
