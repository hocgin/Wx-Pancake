package in.hocg.app.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by hocgin on 16-12-22.
 */
@Component
public class TestHandler extends AbstractHandler {
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
		return  WxMpXmlOutMessage
				.TEXT()
				.content("礼貌性回复")
				.fromUser(wxMessage.getToUser())
				.toUser(wxMessage.getFromUser())
				.build();
	}
}
