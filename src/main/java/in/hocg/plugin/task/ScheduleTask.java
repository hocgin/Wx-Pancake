package in.hocg.plugin.task;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 16-12-19.
 */
@EnableScheduling
@Component
public class ScheduleTask {
	
	@Scheduled(cron = "0/10 * * * * ?")
	public void demo() {
		System.out.println("QuartzTask task ..");
	}
}
