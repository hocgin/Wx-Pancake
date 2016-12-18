package in.hocg.app.bean;

import in.hocg.defaults.base.bean.SoftDeletedTable;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hocgin on 16-12-18.
 * 用户操作日志表
 */
@Entity
@Table(name = "t_logger")
@DynamicUpdate//动态更新
@DynamicInsert//动态插入
public class LoggerBean extends SoftDeletedTable {
	/**
	 * 用户
	 */
	@Column(name = "user")
	private String user;
	/**
	 * 输入内容
	 */
	@Column(name = "content")
	private String content;
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
