package in.hocg.app.controller;

import in.hocg.app.config.MenuConfig;
import in.hocg.app.services.CoreService;
import in.hocg.defaults.base.controller.BaseController;
import in.hocg.utils.Logs;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hocgin on 16-12-17.
 */
@Controller
@RequestMapping("/wx")
public class WxController extends BaseController {
	protected Logger logger = Logs.get();
	
	@Autowired
	protected WxMpConfigStorage configStorage;
	@Autowired
	protected WxMpService wxMpService;
	@Autowired
	protected CoreService coreService;
	@Autowired
	protected MenuConfig menuConfig;
	
	@RequestMapping(value = "index")
	public String index() {
		return "index";
	}
	
	/**
	 * 微信公众号webservice主服务接口，提供与微信服务器的信息交互
	 *
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "core")
	public void wechatCore(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		
		String signature = request.getParameter("signature");
		String nonce = request.getParameter("nonce");
		String timestamp = request.getParameter("timestamp");
		if (!this.wxMpService.checkSignature(timestamp, nonce, signature)) {
			// 消息签名不正确，说明不是公众平台发过来的消息
			response.getWriter().println("非法请求");
			return;
		}
		
		String echoStr = request.getParameter("echostr");
		if (StringUtils.isNotBlank(echoStr)) {
			// 说明是一个仅仅用来验证的请求，回显echostr
			String echoStrOut = String.copyValueOf(echoStr.toCharArray());
			response.getWriter().println(echoStrOut);
			return;
		}
		
		String encryptType = StringUtils.isBlank(request.getParameter("encrypt_type"))
				? "raw"
				: request.getParameter("encrypt_type");
		
		if ("raw".equals(encryptType)) {
			// 明文传输的消息
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromXml(request.getInputStream());
			WxMpXmlOutMessage outMessage = this.coreService.route(inMessage);
			response.getWriter().write(outMessage.toXml());
			return;
		}
		
		if ("aes".equals(encryptType)) {
			// 是aes加密的消息
			String msgSignature = request.getParameter("msg_signature");
			WxMpXmlMessage inMessage = WxMpXmlMessage.fromEncryptedXml(
					request.getInputStream(), this.configStorage, timestamp, nonce,
					msgSignature);
			this.logger.debug("\n消息解密后内容为：\n{} ", inMessage.toString());
			WxMpXmlOutMessage outMessage = this.coreService.route(inMessage);
			this.logger.info(response.toString());
			response.getWriter()
					.write(outMessage.toEncryptedXml(this.configStorage));
			return;
		}
		
		response.getWriter().println("不可识别的加密类型");
		return;
	}
	
	/**
	 * 通过openid获得基本用户信息
	 * 详情请见: http://mp.weixin.qq.com/wiki/14/bb5031008f1494a59c6f71fa0f319c66.html
	 *
	 * @param response
	 * @param openid   openid
	 * @param lang     zh_CN, zh_TW, en
	 */
	@RequestMapping(value = "getUserInfo")
	public WxMpUser getUserInfo(HttpServletResponse response, @RequestParam(value = "openid") String openid, @RequestParam(value = "lang") String lang) {
		
		WxMpUser wxMpUser = null;
		try {
			wxMpUser = this.wxMpService.getUserService().userInfo(openid, lang);
			renderString(response, success(wxMpUser));
		} catch (WxErrorException e) {
			renderString(response, fail(500, e.getError().toString()));
			this.logger.error(e.getError().toString());
		}
		return wxMpUser;
	}
	
	/**
	 * 通过code获得基本用户信息
	 * 详情请见: http://mp.weixin.qq.com/wiki/14/bb5031008f1494a59c6f71fa0f319c66.html
	 *
	 * @param response
	 * @param code     code
	 * @param lang     zh_CN, zh_TW, en
	 */
	@RequestMapping(value = "getOAuth2UserInfo")
	public void getOAuth2UserInfo(HttpServletResponse response, @RequestParam(value = "code") String code, @RequestParam(value = "lang") String lang) {
		WxMpOAuth2AccessToken accessToken;
		WxMpUser wxMpUser;
		try {
			accessToken = this.wxMpService.oauth2getAccessToken(code);
			wxMpUser = this.wxMpService.getUserService()
					.userInfo(accessToken.getOpenId(), lang);
			renderString(response, success(wxMpUser));
		} catch (WxErrorException e) {
			renderString(response, fail(500, e.getError().toString()));
			this.logger.error(e.getError().toString());
		}
	}
	
	/**
	 * 用code换取oauth2的openid
	 * 详情请见: http://mp.weixin.qq.com/wiki/1/8a5ce6257f1d3b2afb20f83e72b72ce9.html
	 *
	 * @param response
	 * @param code     code
	 */
	@RequestMapping(value = "getOpenid")
	public void getOpenid(HttpServletResponse response, @RequestParam(value = "code") String code) {
		WxMpOAuth2AccessToken accessToken;
		try {
			accessToken = this.wxMpService.oauth2getAccessToken(code);
			renderString(response, success(accessToken));
		} catch (WxErrorException e) {
			renderString(response, fail(500, e.getError().toString()));
			this.logger.error(e.getError().toString());
		}
	}
	
	@RequestMapping(value = "/init/{code}")
	@ResponseBody
	public Object init(@PathVariable("code") String code) {
		menuConfig.init();
		return success(null);
	}
}
