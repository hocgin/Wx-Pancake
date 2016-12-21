package in.hocg.plugin.task;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hocgin on 16-12-21.
 */
@Configuration
public class TaskConfig {
	
	/**
	 * 使用
	 * @Autowired
	 * AsyncTask asyncTask
	 * @return
	 */
	@Bean
	public AsyncTask asyncTask() {
		return new AsyncTask();
	}
}
