package in.hocg.app.handler;

import in.hocg.app.bean.DictateBean;
import in.hocg.app.services.DictateService;
import in.hocg.app.services.MessageBoardService;
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
 * #反馈 xx
 */
@Component
public class FeedbackHandler extends AbstractHandler{
	
	@Autowired
	MessageBoardService messageBoardService;
	@Autowired
	DictateService dictateService;
	
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
		String directive = wxMessage.getContent().trim();
		directive = directive.substring(1, directive.length());
		String[] split = directive.split("\\s+", 2);
		directive = split[0];
		String params = split[1];
		messageBoardService.insert(params, wxMessage.getFromUser());
		DictateBean dictate = dictateService.fetch("反馈", DictateBean.Type.Text);
		return WxMpXmlOutMessage
				.TEXT()
				.content(dictate.getContent())
				.fromUser(wxMessage.getToUser())
				.toUser(wxMessage.getFromUser())
				.build();
	}
}
