package in.hocg.defaults.base.dao;

import in.hocg.defaults.base.bean.BaseTable;
import in.hocg.utils.Clazz;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by hocgin on 16-12-18.
 */
@Transactional
public class TableDao <T extends BaseTable> extends CurlDao {
	/**
	 * 实体类
	 */
	private Class<T> clazz;
	/**
	 * 实体名
	 */
	private String entity;
	/**
	 * 表名
	 */
	private String table;
	
	public TableDao() {
		clazz = Clazz.getTypeParam(this.getClass(), 0);
		entity = clazz.getName();
		if (clazz.isAnnotationPresent(Table.class)) {
			Table annotation = clazz.getAnnotation(Table.class);
			table = annotation.name();
		}
	}
	
	public Class<T> getClazz() {
		return clazz;
	}
	
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public String getEntity() {
		return entity;
	}
	
	public void setEntity(String entity) {
		this.entity = entity;
	}
	
	public String getTable() {
		return table;
	}
	
	public void setTable(String table) {
		this.table = table;
	}
	
	/**
	 * 增加
	 * @param obj
	 */
	public Serializable insert(T obj) {
		return currentSession().save(obj);
	}
	
	/**
	 * 更新
	 * @param tableObj
	 */
	public void update(T tableObj) {
		tableObj.setUpdateAt(new Date());
		currentSession().update(tableObj);
	}
	
	/**
	 * 更新, 不记录更新时间
	 * @param tableObj
	 */
	public void updateNotRecord(T tableObj) {
		currentSession().update(tableObj);
	}
	
	/**
	 * 使用id查询
	 * @param id
	 * @return
	 */
	public T fetch(Object id) {
		return currentSession().find(clazz, id);
	}
	
	/**
	 * 删除
	 * @param tableObj
	 */
	public void delete(T tableObj) {
		currentSession().delete(tableObj);
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void delete(Object id) {
		T tableObj = fetch(id);
		currentSession().delete(tableObj);
	}
}
