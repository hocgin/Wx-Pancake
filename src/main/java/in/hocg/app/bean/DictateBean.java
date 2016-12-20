package in.hocg.app.bean;

import in.hocg.defaults.base.bean.SoftDeletedTable;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hocgin on 16-12-18.
 * 动态指令响应表
 */
@Entity
@Table(name = "t_dictates")
@DynamicUpdate//动态更新
@DynamicInsert//动态插入
public class DictateBean extends SoftDeletedTable {
	
	public enum Type {
		Text
	}
	
	/**
	 * 指令 [唯一,正则]
	 * eg.
	 * #XX -> XX
	 */
	@Column(name = "cmd")
	private String cmd;
	/**
	 * 响应内容
	 */
	@Column(name = "content")
	private String content;
	/**
	 * 响应类型 [Url, Text..]
	 */
	@Column(name = "type")
	private String type;
	
	public String getCmd() {
		return cmd;
	}
	
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
