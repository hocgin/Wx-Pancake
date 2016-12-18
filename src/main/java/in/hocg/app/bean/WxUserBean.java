package in.hocg.app.bean;

import in.hocg.defaults.base.bean.SoftDeletedTable;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by hocgin on 16-12-18.
 */
@Entity
@Table(name = "t_wx_user")
@DynamicUpdate//动态更新
@DynamicInsert//动态插入
public class WxUserBean extends SoftDeletedTable {
}
