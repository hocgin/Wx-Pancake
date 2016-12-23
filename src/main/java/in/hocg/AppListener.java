package in.hocg;

import in.hocg.database.MainSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 16-12-18.
 * 管理Spring 初始化
 */
@Component
public class AppListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	MainSeeder mainSeeder;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		/**
		 * todo 若让 listener 和 servlet 都加载的spring-servlet话会执行两次
		 * 数据库数据加载时操作
		 */
		mainSeeder.handler();
	}
}
