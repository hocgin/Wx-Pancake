package in.hocg.defaults.base.dao;

import in.hocg.defaults.base.bean.BaseTable;
import in.hocg.defaults.utils.Clazz;

import javax.persistence.Table;

/**
 * Created by hocgin on 16-12-18.
 */
public class TableDao <T extends BaseTable> {
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
}
