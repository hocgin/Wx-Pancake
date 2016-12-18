package in.hocg;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 16-12-18.
 * 管理Spring 初始化
 */
@Component
public class App implements ApplicationContextAware {
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println(">>>>>>>>>> 启动");
	}
}
