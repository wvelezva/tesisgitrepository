package edu.eafit.maestria.activa.dao.hibernate.utils;

import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import edu.eafit.maestria.activa.dao.hibernate.DAOActivator;
import edu.eafit.maestria.activa.utilities.LogUtil;

public class BaseDaoHibernate<T> {
	
	private static final LogUtil logger = LogUtil.getInstance(DAOActivator.getDefault().getBundle().getSymbolicName(), BaseDaoHibernate.class);
	
	private Session session;
	private Class<? extends T> persistentClass;
	private HibernateTemplate template;
	
	/**
	 * @param sessionFactory
	 */
	public BaseDaoHibernate(Session session, Class<? extends T> persistentClass) {
		this.session = session;
		//this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		this.template =HibernateTemplate.getInstance(session);
		this.persistentClass = persistentClass;
	}
	
	
	/**
	 * @return the persistentClass
	 */
	private Class getPersistentClass() {
		return persistentClass;
	}
	
	/**
	 * Saves any hibernate pojo into the database
	 * 
	 * @param o
	 */
	public void save(T o) {
		template.saveOrUpdate(o);
	}
	
	/**
	 * Gets any hibernate pojo from the db
	 * @param clazz
	 * @param id
	 * @return
	 * @author juanm
	 */
	protected T getObject(long id, LockOptions lockOptions) {
		T o = (T)template.get(getPersistentClass(), Long.valueOf(id), lockOptions);

		if (o == null) {
			logger.logWarning("Object of entity [" + getPersistentClass() + "] with id [" + Long.valueOf(id) + "] don't existe");
		}
		return o;
	}
	
	/**
	 * Gets an object by his ID
	 * 
	 * @author spulido
	 * @param inventoryId
	 * @return
	 */
	public T getById(long id) {
		return this.load(id);
	}
	
	/**
	 * Loads an object. The difference is that the object is only readed when readed. That means
	 * less selects are executed to the db. Entities are not fechted when the a relation is created
	 * @param id
	 * @return
	 */
	protected T load(long id) {
		return (T)template.load(getPersistentClass(), Long.valueOf(id));
	}
	
	/**
	 * Gets any hibernate pojo from the db
	 * 
	 * @param id
	 * @return
	 * @author juanm
	 */
	protected T getObject(long id) {
		return load(id);
	}

	/**
	 * Get a list of hibernate pojos from the db
	 * @return
	 */
	public List<T> getObjects() {
		return template.loadAll(getPersistentClass());
	}
	
	/**
	 * Get a list of non archived hibernate pojos from the db
	 * @return
	 */
	protected List<T> getActiveObjects() {
		return getObjectsByParam("archived", Boolean.FALSE);
	}
	
	/**
	 * Gets a list of objects by a given param
	 * @param paramName
	 * @param paramValue
	 * @return
	 */
	protected List<T> getObjectsByParam(String paramName, Object paramValue) {
		return getObjectsByParam(paramName, paramValue, null);
	}
	
	/**
	 * Gets a list of objects by a given param
	 * @param paramName
	 * @param paramValue
	 * @param orderBy
	 * @return
	 */
	protected List<T> getObjectsByParam(String paramName, Object paramValue, String orderBy) {
		DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass()).add(Property.forName(paramName).eq(paramValue));
		if (StringUtils.isNotBlank(orderBy))
			criteria.addOrder(Order.asc(orderBy));
		
		List<T> results = template.findByCriteria(criteria);
		
		return results;
	}
	
	/**
	 * Removes an object from the db
	 * this is a logical remove. The archived property is set to true
	 * @param id
	 */
	protected void removeObject(long id) {
		T t = getObject(id);
		removeObject(t);
	}
	
	/**
	 * Removes an object from the db
	 * this is a logical remove. The archived property is set to true
	 * @param id
	 */
	protected void removeObject(T t) {
		try {
			BeanUtils.setProperty(t, "archived", Boolean.TRUE);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		template.save(t);
	}
	
	/**
	 * Deletes an object from the db
	 * @param id
	 */
	protected void deleteObject(long id) {
		delete(getObject(id));
	}
	
	/**
	 * Deletes an object
	 * @param t
	 */
	public void delete(T t) {
		template.delete(t);
	}
	
	/**
	 * Empty remove method.
	 * 
	 * If implemented, this method should delete logicly the object 
	 * 
	 * @param id
	 */
	public void remove(long id) {
		this.removeObject(this.getById(id));
    }

	/**
	 * Finds the size of a collection
	 * @param collection
	 * @return
	 * @author juan.maya
	 */
	public int size(Collection<?> collection) {
		return ((Long) session.createFilter( collection, "select count(*)" ).uniqueResult()).intValue();
	}

	
	protected Criteria createCriteria() {
		return session.createCriteria(getPersistentClass());
	}
	
	protected Query createQuery(String query) {
		return session.createQuery(query);
	}
}