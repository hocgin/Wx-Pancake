package in.hocg.app.controller;

import in.hocg.defaults.base.controller.BaseController;
import in.hocg.utils.Lang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
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
	
	@Autowired
	RedisTemplate redisTemplate;
	
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws Exception {
        return redirectJump(request, "/index.jsp");
    }
    
    @RequestMapping(value = "JSON", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String, String> json() {
        HashMap<String, String> map = new HashMap<String, String>(){{
            put("ok", "true");
            put("ok", "true");
            put("ok", "true");
        }};
        return map;
    }
	
	@RequestMapping(value = "e", method = RequestMethod.GET)
	@ResponseBody
	public void e() {
		if (true) {
			throw Lang.makeThrow("测试异常");
		}
	}

}
