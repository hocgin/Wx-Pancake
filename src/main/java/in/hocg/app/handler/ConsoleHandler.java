package in.hocg.app.handler;

import in.hocg.app.bean.LoggerBean;
import in.hocg.app.services.CoreService;
import in.hocg.app.services.LoggerService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * Created by hocgin on 16-12-17.
 */
@Component
public class ConsoleHandler extends AbstractHandler{
	
	@Autowired
	LoggerService loggerService;
	@Autowired
	protected CoreService coreService;
	
	public final static SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HHmmss");
	
	public static int COUNT = 0;
	public static final String[] colors = new String[]{"\033[45;37m", "\033[44;37m"};
	
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
		String content = wxMpXmlMessage.toString();
//		String user = wxMpXmlMessage.getFromUser();
//		this.logger.info("\n接收到请求消息，内容：【{}】", content);
//		String color = colors[COUNT++ % colors.length];
//		System.out.println(String.format("%s<%s ::↓>\033[0m", color, SIMPLE_DATE_FORMAT.format(new Date())));
//		System.out.println(content);
//		System.out.println(String.format("%s<↑>\033[0m", color));
		
		
		// -- 保存信息
		WxMpUser wxMpUser = coreService.getUserInfo(wxMpXmlMessage.getFromUser(), "zh_CN");
		LoggerBean loggerBean = new LoggerBean();
		loggerBean.setContent(content);
		loggerBean.setUser(wxMpUser.getOpenId());
		loggerService.saveOrUpdate(loggerBean);
		return null;
	}
}
