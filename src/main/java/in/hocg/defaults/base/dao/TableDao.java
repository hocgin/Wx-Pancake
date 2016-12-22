package in.hocg.defaults.base.dao;

import in.hocg.defaults.base.bean.BaseTable;
import in.hocg.defaults.base.body.Page;
import in.hocg.utils.Clazz;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by hocgin on 16-12-18.
 */
@Transactional
public abstract class TableDao <T extends BaseTable> extends CurlDao {
	/**
	 * 实体类
	 */
	private Class<T> clazz;
	/**
	 * 实体名
	 */
	private String entityName;
	/**
	 * 表名
	 */
	private String tableName;
	
	public TableDao() {
		clazz = Clazz.getTypeParam(this.getClass(), 0);
		entityName = clazz.getName();
		if (clazz.isAnnotationPresent(Table.class)) {
			Table annotation = clazz.getAnnotation(Table.class);
			tableName = annotation.name();
		}
	}
	
	public Class<T> getClazz() {
		return clazz;
	}
	
	public void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public String getEntityName() {
		return entityName;
	}
	
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/**
	 * 增加
	 * @param obj
	 */
	public Serializable insert(T obj) {
		return currentSession().save(obj);
	}
	
	
	public void saveOrUpdate(T obj) {
		currentSession().saveOrUpdate(obj);
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
	public T fetch(Serializable id) {
		return currentSession().find(clazz, id);
	}
	
	public T load(Serializable id) {
		return currentSession().load(clazz, id);
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
	public void delete(Serializable id) {
		T tableObj = load(id);
		delete(tableObj);
	}
	
	/**
	 * 获取总条数
	 * @return
	 */
	public Long count() {
		String hql = String.format("Select count(f.id) from %s f", entityName);
		return  count(hql);
	}
	
	
	/**
	 * 简单的分页
	 * @param hql 查询语句
	 * @param page 请求页码
	 * @param size 每页行数
	 * @return
	 */
	public List<T> paging2(String hql, int page, int size) {
		return hql2(hql)
				.setMaxResults(size)
				.setFirstResult(size * (page - 1)).list();
	}
	
	/**
	 * 获取简单分页
	 * @param hql
	 * @param page
	 * @param size
	 * @param total
	 * @return
	 */
	public Page simplePaging(String hql, int page, int size, long total) {
		return new Page(size, total, page, paging2(hql, page, size));
	}
	
	/**
	 * 使用hql, 返回的是当前表对象
	 * @param hql
	 * @return
	 */
	public Query<T> hql2(String hql) {
		return hql(hql, getClazz());
	}
	
	/**
	 * 使用sql, 返回的是当前表对象
	 * @param sql
	 * @return
	 */
	public NativeQuery sql2(String sql) {
		return sql(sql, getClazz());
	}
	
	/**
	 * 使用criteria, 返回的是当前表对象
	 * @return
	 */
	public DetachedCriteria criteria() {
		return criteria(getClazz());
	}
}
