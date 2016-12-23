package in.hocg.app.handler;

import in.hocg.app.bean.DictateBean;
import in.hocg.app.services.DictateService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpMessageHandler;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by hocgin on 16-12-18.
 */
@Component
public class $Handler implements WxMpMessageHandler {
	@Autowired
	DictateService dictateService;
	
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
		String content = wxMessage.getContent().trim();
		content = content.substring(1, content.length());
		DictateBean dictateBean = dictateService.fetch(content, DictateBean.Type.Text);
		if (dictateBean == null) {
			dictateBean = dictateService.fetch("Help", DictateBean.Type.Text);
		}
		WxMpXmlOutMessage message = null;
		if (dictateBean.getType().equals(DictateBean.Type.Text.name())) { // 指令以文本方式处理
			message = WxMpXmlOutMessage
					.TEXT()
					.content(dictateBean.getContent())
					.fromUser(wxMessage.getToUser())
					.toUser(wxMessage.getFromUser())
					.build();
		}
		return message;
	}
}
