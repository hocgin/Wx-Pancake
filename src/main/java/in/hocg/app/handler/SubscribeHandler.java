package in.hocg.app.handler;

import in.hocg.app.bean.DictateBean;
import in.hocg.app.bean.WxUserBean;
import in.hocg.app.services.CoreService;
import in.hocg.app.services.DictateService;
import in.hocg.app.services.WxUserService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

/**
 * Created by hocgin on 16-12-23.
 */
@Component
public class SubscribeHandler extends AbstractHandler {
	@Autowired
	DictateService dictateService;
	@Autowired
	protected CoreService coreService;
	@Autowired
	protected WxUserService wxUserService;
	
	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService, WxSessionManager sessionManager) throws WxErrorException {
		WxMpXmlOutTextMessage build = null;
		if (Objects.equals(wxMessage.getEvent(), WxConsts.EVT_UNSUBSCRIBE)) { // 取消关注
			wxUserService.cancel(wxMessage.getFromUser());
			// 不能发消息
		} else if (Objects.equals(wxMessage.getEvent(), WxConsts.EVT_SUBSCRIBE)) { // 关注
			WxUserBean userBean = new WxUserBean();
			userBean.setOpenId(wxMessage.getFromUser());
			wxUserService.join(userBean);
			DictateBean dictateBean = dictateService.fetch("关注", DictateBean.Type.Event);
			 build = WxMpXmlOutMessage
					.TEXT()
					.content(dictateBean != null ? dictateBean.getContent() : "感谢关注")
					.fromUser(wxMessage.getToUser())
					.toUser(wxMessage.getFromUser())
					.build();
		}
		return build;
	}
}
