package in.hocg.app.services;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.List;

/**
 * Created by hocgin on 16-12-17.
 */
public interface CoreService {
	/**
	 * HttpGet请求
	 *
	 * @param urlWithParams
	 * @throws Exception
	 */
	void requestGet(String urlWithParams) throws IOException;
	
	/**
	 * HttpPost请求
	 *
	 * @param url
	 * @param params
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	void requestPost(String url, List<NameValuePair> params) throws ClientProtocolException, IOException;
	
	/**
	 * 刷新消息路由器
	 */
	void refreshRouter();
	
	/**
	 * 路由消息
	 *
	 * @param inMessage
	 * @return
	 */
	WxMpXmlOutMessage route(WxMpXmlMessage inMessage);
	
	/**
	 * 通过openid获得基本用户信息
	 *
	 * @param openid
	 * @param lang
	 * @return
	 */
	WxMpUser getUserInfo(String openid, String lang);
}
