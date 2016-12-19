package in.hocg;

import in.hocg.plugin.task.AsyncTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hocgin on 16-12-19.
 */
@Configuration
public class WebConfig {
	
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
