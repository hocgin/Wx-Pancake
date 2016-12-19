package in.hocg.app.dao;

import in.hocg.app.bean.DictateBean;
import in.hocg.defaults.base.dao.SoftDeletedDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hocgin on 16-12-19.
 */
@Component
@Transactional
public class DictateDao extends SoftDeletedDao<DictateBean> {
}
