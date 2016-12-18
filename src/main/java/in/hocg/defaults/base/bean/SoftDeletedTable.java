package in.hocg.defaults.base.bean;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by hocgin on 16-12-18.
 */
@MappedSuperclass
public class SoftDeletedTable extends BaseTable {
	@Column(name = "delete_at")
	private Date deleteAt;
	
	public Date getDeleteAt() {
		return deleteAt;
	}
	
	public void setDeleteAt(Date deleteAt) {
		this.deleteAt = deleteAt;
	}
}
