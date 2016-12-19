package in.hocg.defaults.base;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 16-12-19.
 *  用于持有ApplicationContext,可以使用SBeanUtilsAware.getBean('xxxx')的静态方法得到spring bean对象
 */
@Component
@Lazy(false)
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {
	private static ApplicationContext APPLICATION_CONTEXT;
	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return APPLICATION_CONTEXT;
	}
	
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) APPLICATION_CONTEXT.getBean(name);
	}
	
	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) APPLICATION_CONTEXT.getBeansOfType(clazz);
	}
	
	/**
	 * 清除applicationContext静态变量.
	 */
	public static void cleanApplicationContext() {
		APPLICATION_CONTEXT = null;
	}
	
	private static void checkApplicationContext() {
		if (APPLICATION_CONTEXT == null) {
			throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
		}
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		/**
		 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
		 */
		SpringContextHolder.APPLICATION_CONTEXT = applicationContext; // NOSONAR
	}
	
	@Override
	public void destroy() throws Exception {
		SpringContextHolder.APPLICATION_CONTEXT = null;
	}
}
