package in.hocg.defaults;

import in.hocg.defaults.utils.Generate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 *         --------------------
 *         Created 16-8-24.
 *
 *  所有异常进行拦截处理
 */
@Component
public class DefaultHandlerExceptionResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            PrintWriter out = response.getWriter();
            out.print(Generate.gson().toJson(Custom.Data.NEW(999).setData(ex.getMessage())));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
