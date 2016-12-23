package in.hocg.app.dao;

import in.hocg.app.bean.WxUserBean;
import in.hocg.defaults.base.dao.SoftDeletedDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by hocgin on 16-12-23.
 */
@Repository
@Transactional
public class WxUserDao extends SoftDeletedDao<WxUserBean> {
	
	/**
	 * 按openId查找用户
	 *
	 * @param openId
	 * @return
	 */
	public WxUserBean fetchAll(String openId) {
		DetachedCriteria criteria = criteria().add(Restrictions.eq("openId", openId));
		return (WxUserBean) uniqueCriteria(criteria);
	}
	
	/**
	 * 按openId查找用户
	 *
	 * @param openId
	 * @return
	 */
	public WxUserBean fetchOpenId(String openId) {
		DetachedCriteria criteria = criteria().add(Restrictions.eq("openId", openId))
				.add(Restrictions.isNull("deleteAt"));
		return (WxUserBean) uniqueCriteria(criteria);
	}
	
	/**
	 * 删除
	 */
	public void deleteAt(WxUserBean userBean) {
		userBean.setDeleteAt(new Date());
		update(userBean);
	}
}
