package in.hocg.app.controller;

import in.hocg.app.params.N0Params;
import in.hocg.defaults.base.controller.BaseController;
import in.hocg.utils.Lang;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 *         --------------------
 *         Created 16-8-24.
 */
@Controller
public class MainController extends BaseController{
	
//	@Autowired
//	RedisTemplate redisTemplate;
	
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws Exception {
        return redirectJump(request, "/index.jsp");
    }
    
    @RequestMapping(value = "/JSON")
    @ResponseBody
    public HashMap<String, String> json() {
        HashMap<String, String> map = new HashMap<String, String>(){{
            put("ok", "true");
            put("ok", "true");
            put("ok", "true");
        }};
        return map;
    }
	
	/**
	 * 异常测试
	 */
	@RequestMapping(value = "/exp", method = RequestMethod.GET)
	@ResponseBody
	public void exp() {
		if (true) {
			throw Lang.makeThrow("测试异常");
		}
	}
	
	/**
	 * 分页测试
	 */
	@RequestMapping(value = "/paging")
	@ResponseBody
	public Object paging(@ModelAttribute N0Params params) {
		return params;
	}

}
