package in.hocg.defaults;

import in.hocg.defaults.utils.Generate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 *         <p>
 *         <p>
 *         <p>
 *         --------------------
 *         Created 16-8-26.
 */
public class ListenerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        _out(request.getProtocol(), request.getMethod(), request.getRequestURI(), request.getParameterMap());
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }

    private void _out(String protocol, String method, String url, Map<String, String[]> params) {
        System.out.println(String.format("[%s] %s URI=%s", protocol, method, url));
        System.out.println(String.format("Params:\n%s", Generate.gson().toJson(params)));
        System.out.println("--------------------------------------------------");
    }
}
