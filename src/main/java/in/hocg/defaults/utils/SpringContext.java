package in.hocg.defaults.utils;

import in.hocg.utils.Lang;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by hocgin on 16-12-19.
 */
public class SpringContext {
	
	/**
	 * 根据bean的name获取bean
	 * @param name
	 * @return
	 */
	public static Object getBean(String name) {
		return currentAppContext().getBean(name);
	}
	
	/**
	 * 根据bean的类型获取bean
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return currentAppContext().getBean(clazz);
	}
	
	/**
	 * 获取当前环境AppContext
	 * @return
	 */
	public static WebApplicationContext currentAppContext() {
		WebApplicationContext applicationContext = ContextLoader.getCurrentWebApplicationContext();
		if (applicationContext == null) {
			throw Lang.makeThrow("只能在初始化后调用");
		}
		return applicationContext;
	}
}
