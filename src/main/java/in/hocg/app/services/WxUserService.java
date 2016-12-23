package in.hocg.app.services;

import com.sun.istack.internal.NotNull;
import in.hocg.app.bean.WxUserBean;
import in.hocg.app.dao.WxUserDao;
import in.hocg.defaults.base.service.TableService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by hocgin on 16-12-23.
 */
@Service
public class WxUserService extends TableService<WxUserBean, WxUserDao> {
	/**
	 * 关注
	 * @param wxUserBean
	 */
	public void join(@NotNull WxUserBean wxUserBean) {
		WxUserBean userBean = dao().fetchAll(wxUserBean.getOpenId());
		if (userBean != null) {
			if (userBean.getDeleteAt() == null) {
				return;
			}
			userBean.setDeleteAt(null);
		} else {
			userBean = wxUserBean;
		}
		saveOrUpdate(userBean);
	}
	
	/**
	 * 取消关注
	 * @param openId
	 */
	public void cancel(@NotNull String openId) {
		WxUserBean userBean = dao().fetchOpenId(openId);
		if (userBean != null) {
			dao().deleteAt(userBean);
		} else { // 关注时被忽略的人
			userBean = new WxUserBean();
			userBean.setDeleteAt(new Date());
			userBean.setOpenId(openId);
			insert(userBean);
		}
	}
}
