package in.hocg.database;

import java.util.ArrayList;
import java.util.List;

/**
 * (๑`灬´๑)
 * Created by hocgin on 十一月28  028.
 */
public class MainSeeder {
	
	/**
	 * 装载数据库预执行数据器
	 *
	 * @return
	 */
	public List<Seeder> getSeeders() {
		return new ArrayList<>();
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
