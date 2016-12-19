package in.hocg.database;

import in.hocg.database.seeders.DSeeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * (๑`灬´๑)
 * Created by hocgin on 十一月28  028.
 */
@Component
public class MainSeeder {
	@Autowired
	DSeeder dSeeder;
	
	/**
	 * 装载数据库预执行数据器
	 *
	 * @return
	 */
	public List<Seeder> getSeeders() {
		return new ArrayList<Seeder>(Arrays.asList(
				dSeeder
		));
	}
	
	/**
	 * 批量加载数据库数据
	 */
	public void handler() {
		for (Seeder seeder : getSeeders()) {
			seeder.run();
		}
	}
	
}
