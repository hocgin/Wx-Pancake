package in.hocg.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by hocgin on 16-12-21.
 * XML配置文件, 因为@ContextConfiguration限制不能同时加载 注解式和xml式 的配置,故采用此方法.
 * 而且多xml文件不能使用 "classpath:spring-*.xml"
 */
@Configuration
@ImportResource({
		"classpath:spring-servlet.xml", "classpath:spring-debug.xml",
		"classpath:spring-apps.xml",
		"classpath:spring-hibernate.cfg.xml",
		"classpath:spring-redis.xml",
		"classpath:spring-task.xml",
})
public class ResourcesConfig {
}
