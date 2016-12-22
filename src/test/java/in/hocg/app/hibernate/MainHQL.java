package in.hocg.app.hibernate;

import in.hocg.app.bean.DictateBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

/**
 * Created by hocgin on 16-12-20.
 * Junit 基础类,加载环境
 */
@ContextConfiguration(locations = "classpath:spring-hibernate.cfg.xml")
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class MainHQL {
	@Autowired
	HibernateTemplate hibernateTemplate;
	Session session;
	
	@Before
	public void setUp() {
		session = hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	
	@Test
	@Transactional
	public void e() throws Exception {
		int page = 1;
		int size = 10;
//		List list = simplePaging("select id, createAt from DictateBean", 1, 10);
		System.out.println(hql2sql("select id, createAt from DictateBean"));
		DetachedCriteria criteria = DetachedCriteria.forClass(DictateBean.class)
				.add(eq("id", "2a929eb6-c695-4d2b-ae78-7eff3b138c09"));
		List<?> byCriteria = hibernateTemplate.findByCriteria(criteria);
		System.out.println("");
	}
	
	public List simplePaging(String hql, int page, int size) {
		Query result = currentSession().createQuery(hql);
		return result.list();
	}
	private String hql2sql(String hql) {
		SessionFactory sessionFactory = currentSession().getSessionFactory();
		QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(
				hql, hql, Collections.EMPTY_MAP, (SessionFactoryImplementor) sessionFactory);
		queryTranslator.compile(Collections.EMPTY_MAP, false);
		return queryTranslator.getSQLString();
	}
	
	// ---------------
	
	public Session currentSession() {
		return session;
	}
}