package in.hocg.defaults.base.dao;

import in.hocg.defaults.base.bean.SoftDeletedTable;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hocgin on 16-12-18.
 */
@Transactional
public abstract class SoftDeletedDao<T extends SoftDeletedTable> extends TableDao {
	
}
