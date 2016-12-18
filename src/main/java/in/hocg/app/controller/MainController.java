package in.hocg.app.controller;

import in.hocg.defaults.base.controller.BaseController;
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

}
