package in.hocg.defaults.base.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hocgin on 16-12-18.
 */
public abstract class CurlDao {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	protected org.springframework.orm.hibernate4.HibernateTemplate hibernateTemplate;
	@Autowired
	protected org.springframework.jdbc.core.JdbcTemplate jdbcTemplate;
}
