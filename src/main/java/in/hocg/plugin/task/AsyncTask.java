package in.hocg.plugin.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by hocgin on 16-12-19.
 */
@EnableAsync
public class AsyncTask {
	@Async
	public void demo(int param) {
	}
}
