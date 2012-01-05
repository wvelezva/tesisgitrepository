package edu.eafit.maestria.activa.dao.hibernate.utils;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import edu.eafit.maestria.activa.dao.hibernate.DAOActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class HibernateTemplate extends HibernateAccessor{

	private static final LogUtil logger = LogUtil.getInstance(DAOActivator.getDefault().getBundle().getSymbolicName(), HibernateTemplate.class);
	private Session session;
	private static HibernateTemplate hibernateTemplate;
	
	private HibernateTemplate(Session session) {
		this.session = session;
	}

	public static HibernateTemplate getInstance(Session session) {
		if (hibernateTemplate == null)
			hibernateTemplate = new HibernateTemplate(session);
		
		return hibernateTemplate;
	}

	public void saveOrUpdate(final Object entity) throws RuntimeException {
		execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				session.saveOrUpdate(entity);
				return null;
			}
		});
	}
	
	public Object get(final Class entityClass, final Serializable id, final LockOptions lockOptions) throws RuntimeException {
		return execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				if (lockOptions != null) {
					return session.get(entityClass, id, lockOptions);
				}
				else {
					return session.get(entityClass, id);
				}
			}
		});
	}
	
	public Object load(Class entityClass, Serializable id) throws RuntimeException {
		return load(entityClass, id, null);
	}
	
	public Object load(final Class entityClass, final Serializable id, final LockOptions lockOptions)	throws RuntimeException {

		return execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				if (lockOptions != null) {
					return session.load(entityClass, id, lockOptions);
				}
				else {
					return session.load(entityClass, id);
				}
			}
		});
	}
	
	public List loadAll(final Class entityClass) throws RuntimeException {
		return (List) execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria criteria = session.createCriteria(entityClass);
				criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				prepareCriteria(criteria);
				return criteria.list();
			}
		});
	}
	
	public Serializable save(final Object entity) throws RuntimeException {
		return (Serializable) execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				return session.save(entity);
			}
		});
	}
	
	public void delete(Object entity) throws RuntimeException {
		delete(entity, null);
	}

	public void delete(final Object entity, final LockOptions lockMode) throws RuntimeException {
		execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				if (lockMode != null) {
					session.buildLockRequest(lockMode).lock(entity);
				}
				session.delete(entity);
				return null;
			}
		});
	}
	
	/**
	 * Execute the action specified by the given action object within a Session.
	 * @param action callback object that specifies the Hibernate action
	 * @return a result object returned by the action, or <code>null</code>
	 * @throws edu.eafit.maestria.activa.dao.hibernate.utils.old_deprecated.springframework.dao.DataAccessException in case of Hibernate errors
	 */
	boolean existingTransaction = false;
	
	protected Object execute(HibernateCallback action)	throws RuntimeException {
		
		boolean createdTransaction = false;
		Transaction tx = null;
		if (existingTransaction) {
			logger.logInfo("Found thread-bound Session for HibernateTemplate");
		} else {
			tx = session.beginTransaction();
			existingTransaction = true;
			createdTransaction = true;
		}

		FlushMode previousFlushMode = null;
		try {
			previousFlushMode = applyFlushMode(session, existingTransaction);
			enableFilters(session);
			Object result = action.doInHibernate(session);
			if (createdTransaction && tx != null) {
				tx.commit();
				existingTransaction = false;
			}
			flushIfNecessary(session, existingTransaction);
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} catch (RuntimeException ex) {
			// Callback code threw application exception...
			throw ex;
		}
		finally {
			logger.logInfo("Not closing pre-bound Hibernate Session after HibernateTemplate");
			disableFilters(session);
			if (previousFlushMode != null) {
				session.setFlushMode(previousFlushMode);
			}
		}
	}
	
	/**
	 * Prepare the given Criteria object, applying cache settings and/or
	 * a transaction timeout.
	 * @param criteria the Criteria object to prepare
	 */
	protected void prepareCriteria(Criteria criteria) {
		criteria.setCacheable(true);
		//criteria.settimeout();
	}
	
	//-------------------------------------------------------------------------
	// Convenience finder methods for detached criteria
	//-------------------------------------------------------------------------

	public List findByCriteria(DetachedCriteria criteria) throws RuntimeException {
		return findByCriteria(criteria, -1, -1);
	}

	public List findByCriteria(final DetachedCriteria criteria, final int firstResult, final int maxResults) throws RuntimeException {

		return (List) execute(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException {
				Criteria executableCriteria = criteria.getExecutableCriteria(session);
				prepareCriteria(executableCriteria);
				if (firstResult >= 0) {
					executableCriteria.setFirstResult(firstResult);
				}
				if (maxResults > 0) {
					executableCriteria.setMaxResults(maxResults);
				}
				return executableCriteria.list();
			}
		});
	}

}
