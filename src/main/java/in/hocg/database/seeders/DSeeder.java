package in.hocg.database.seeders;

import in.hocg.app.bean.DictateBean;
import in.hocg.app.dao.DictateDao;
import in.hocg.database.Seeder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by hocgin on 16-12-18.
 * 运行时数据
 */
@Component
public class DSeeder implements Seeder {
	
	@Autowired
	DictateDao dictateDao;
	
	@Override
	public void run() {
		DictateBean dirtateBean = new DictateBean();
		dirtateBean.setCmd("地址");
		dirtateBean.setContent(">>");
		dirtateBean.setType(DictateBean.Type.Text.name());
		dictateDao.insert(dirtateBean);
		System.out.println(" insert or update DB " + dictateDao);
	}
}
