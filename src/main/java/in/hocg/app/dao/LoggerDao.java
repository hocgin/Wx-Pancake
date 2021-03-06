package in.hocg.app.dao;

import in.hocg.app.bean.DictateBean;
import in.hocg.defaults.base.dao.SoftDeletedDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hocgin on 16-12-22.
 */
@Repository
@Transactional
public class LoggerDao extends SoftDeletedDao<DictateBean> {
	
}
