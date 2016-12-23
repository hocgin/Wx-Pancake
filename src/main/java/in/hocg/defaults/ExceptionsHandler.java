package in.hocg.defaults;

import in.hocg.utils.Logs;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * (๑`灬´๑)
 *
 * @author hocgin(admin@hocg.in)
 *         --------------------
 *         Created 16-8-24.
 *
 *  会拦截所有异常, 依照下面的方式对异常进行处理
 */
//@ControllerAdvice
public class ExceptionsHandler {
	Logger log = Logs.get();
	
	@ExceptionHandler({RuntimeException.class})
	public void processRuntimeException(NativeWebRequest request, RuntimeException exception) {
		log.info(String.format("处理指定的异常[%s] %s", exception.getClass().getName(), exception.getMessage()));
	}
}
