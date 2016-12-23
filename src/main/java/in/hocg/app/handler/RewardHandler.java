package in.hocg.app.handler;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by hocgin on 16-12-23.
 */
@Component
public class RewardHandler extends AbstractHandler {
	
	@Autowired
	protected WxMpService wxMpService;
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
		return WxMpXmlOutMessage
				.IMAGE()
				.mediaId("wx.pay.300.png")
				.toUser(wxMessage.getFromUser())
				.fromUser(wxMessage.getToUser())
				.build();
	}
}
