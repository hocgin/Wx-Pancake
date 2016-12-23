package in.hocg.app.dao;

import in.hocg.app.bean.MessageBoardBean;
import in.hocg.defaults.base.dao.SoftDeletedDao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hocgin on 16-12-23.
 */
@Repository
@Transactional
public class MessageBoardDao extends SoftDeletedDao<MessageBoardBean> {
}
