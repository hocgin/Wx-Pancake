package in.hocg.defaults.base.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by hocgin on 16-12-18.
 */
@MappedSuperclass
public class BaseTable extends BaseBean {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	private String id;
	
	@Column(name = "create_at")
	private Date createAt = new Date();
	@Column(name = "update_at")
	private Date updateAt;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getCreateAt() {
		return createAt;
	}
	
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public Date getUpdateAt() {
		return updateAt;
	}
	
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
}
