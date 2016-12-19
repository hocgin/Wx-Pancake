package in.hocg.defaults.base.controller;

import in.hocg.app.utils.Return;
import in.hocg.defaults.Custom;
import in.hocg.utils.Lang;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 * 子类Controller需声明 @Controller
 * Spring的@Controller无子类继承效果
 */
@Controller
public abstract class BaseController {

    public String redirectJump(HttpServletRequest request, String def) throws IOException {
        return String.format("redirect:%s", Lang.ifNull(request.getParameter(Custom.RequestParams.JUMP), def));
    }
    
    public Return success(Object result) {
        return Return.success(result);
    }
    
    public Return success(String message, Object result) {
        return Return.success(message, result);
    }
    
    public Return fail(Integer code, String message, Object result) {
        return Return.fail(code, message, result);
    }
    
    public Return fail(Integer code, String message) {
        return Return.fail(code, message);
    }
    
}
