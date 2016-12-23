package in.hocg.app.dao;

import in.hocg.app.bean.DictateBean;
import in.hocg.defaults.base.dao.SoftDeletedDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by hocgin on 16-12-19.
 */
@Repository
@Transactional
public class DictateDao extends SoftDeletedDao<DictateBean> {
	
	
	public DictateBean fetch(String cmd, DictateBean.Type type) {
		DetachedCriteria criteria = criteria().add(eq("cmd", cmd))
				.add(Restrictions.isNull("deleteAt"))
				.add(Restrictions.eq("type", type.name()));
		return (DictateBean) uniqueCriteria(criteria);
	}
	
}
