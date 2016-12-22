package in.hocg.defaults.base.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by hocgin on 16-12-18.
 *  借此依赖 Spring对Hibernate的链接
 */
@Transactional
public abstract class CurlDao {
	@Autowired
	protected HibernateTemplate hibernateTemplate;
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Session currentSession() {
		return hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	
	
	
	public Object uniqueCriteria(DetachedCriteria criteria) {
		List<?> list = hibernateTemplate.findByCriteria(criteria);
		return list == null || list.size() == 0 ? null : list.get(0);
	}
	
	// ----------------------------------------------------------------
	/**
	 * 简单的分页
	 * @param hql 查询语句
	 * @param page 请求页码
	 * @param size 每页行数
	 * @return
	 */
	public List paging(String hql, int page, int size) {
		return hql(hql)
				.setMaxResults(size)
				.setFirstResult(size * (page - 1)).list();
	}
	
	
	/**
	 * 计数 必须使用 count(id) 进行查询
	 * @param hql
	 * @return
	 */
	public Long count(String hql) {
		Long count = (Long) hql(hql).uniqueResult();
		return count == null? 0: count;
	}
	
	/**
	 * HQL转SQL
	 * @param hql
	 * @return
	 */
	private String hqlToSql(String hql) {
		SessionFactory sessionFactory = currentSession().getSessionFactory();
		QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(
				hql, hql, Collections.EMPTY_MAP, (SessionFactoryImplementor) sessionFactory);
		queryTranslator.compile(Collections.EMPTY_MAP, false);
		return queryTranslator.getSQLString();
	}
	
	/**
	 * 创建hql, 缩短代码长度 .. - -
	 * @param hql
	 * @return
	 */
	public Query hql(String hql) {
		return currentSession().createQuery(hql);
	}
	
	/**
	 * 创建hql, 缩短代码长度 .. - -
	 * @param hql
	 * @param resultClass
	 * @return
	 */
	public <T> Query<T> hql(String hql, Class<T> resultClass) {
		return currentSession().createQuery(hql, resultClass);
	}
	/**
	 * 创建sql, 缩短代码长度 .. - -
	 * @param sql
	 * @return
	 */
	public NativeQuery sql(String sql) {
		return currentSession().createNativeQuery(sql);
	}
	
	/**
	 * 创建sql, 缩短代码长度 .. - -
	 * @param sql
	 * @param resultClass
	 * @param <R>
	 * @return
	 */
	public <R> NativeQuery<R> sql(String sql, Class<R> resultClass) {
		return currentSession().createNativeQuery(sql, resultClass);
	}
	
	/**
	 * 创建sql, 缩短代码长度 .. - -
	 * @param sql
	 * @param resultSetMapping
	 * @return
	 */
	public NativeQuery sql(String sql, String resultSetMapping) {
		return currentSession().createNativeQuery(sql, resultSetMapping);
	}
	
	/**
	 * 创建 criteria
	 * @param tableClass
	 * @return
	 */
	public DetachedCriteria criteria(Class tableClass) {
		return DetachedCriteria.forClass(tableClass);
	}
	
	/**
	 * 创建 criteria
	 * @param tableClass
	 * @param alias
	 * @return
	 */
	public DetachedCriteria criteria(Class tableClass, String alias) {
		return DetachedCriteria.forClass(tableClass, alias);
	}
	
	/**
	 * 创建 criteria
	 * @param entityName
	 * @param alias
	 * @return
	 */
	public DetachedCriteria criteria(String entityName, String alias) {
		return DetachedCriteria.forEntityName(entityName, alias);
	}
	
	/**
	 * 创建 criteria
	 * @param entityName
	 * @return
	 */
	public DetachedCriteria criteria(String entityName) {
		return DetachedCriteria.forEntityName(entityName);
	}
	
}
