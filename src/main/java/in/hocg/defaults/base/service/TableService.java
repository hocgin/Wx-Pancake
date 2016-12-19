package in.hocg.defaults.base.service;

import in.hocg.defaults.base.bean.BaseTable;
import in.hocg.defaults.base.dao.TableDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hocgin on 16-12-19.
 */
public abstract class TableService<O extends BaseTable, T extends TableDao> extends BaseService {
	
	@Autowired
	T dao;
	
	public T getDao() {
		return dao;
	}
	
	public void setDao(T dao) {
		this.dao = dao;
	}
	
	public void insert(O obj) {
		getDao().insert(obj);
	}
}
