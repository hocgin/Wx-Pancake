package in.hocg.app.services;

import in.hocg.app.bean.MessageBoardBean;
import in.hocg.app.dao.MessageBoardDao;
import in.hocg.defaults.base.service.TableService;
import org.springframework.stereotype.Service;

/**
 * Created by hocgin on 16-12-23.
 */
@Service
public class MessageBoardService extends TableService<MessageBoardBean, MessageBoardDao> {
	
	/**
	 * 新增一条留言
	 * @param content
	 * @param openId
	 */
	public void insert(String content, String openId) {
		MessageBoardBean bean = new MessageBoardBean();
		bean.setContent(content);
		bean.setUser(openId);
		insert(bean);
	}
}
