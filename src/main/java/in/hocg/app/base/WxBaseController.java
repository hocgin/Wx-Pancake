package in.hocg.app.base;

import in.hocg.defaults.base.controller.BaseController;
import in.hocg.utils.Generate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hocgin on 16-12-19.
 */
public class WxBaseController extends BaseController {
	
	
	/**
	 * 客户端返回JSON字符串
	 *
	 * @param response
	 * @param object
	 * @return
	 */
	protected String renderString(HttpServletResponse response, Object object) {
		return renderString(response, Generate.gson().toJson(object), "application/json");
	}
	
	/**
	 * 客户端返回字符串
	 *
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
			response.setContentType(type);
			response.setCharacterEncoding("utf-8");
			//解决跨域问题
			response.setHeader("Access-Control-Allow-Origin", "*");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}
}
