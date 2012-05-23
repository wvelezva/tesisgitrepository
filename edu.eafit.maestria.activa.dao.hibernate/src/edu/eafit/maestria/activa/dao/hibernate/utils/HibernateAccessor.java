package edu.eafit.maestria.activa.dao.hibernate.utils;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import edu.eafit.maestria.activa.dao.hibernate.DAOActivator;
import edu.eafit.maestria.activa.dao.hibernate.Messages;
import edu.eafit.maestria.activa.utilities.LogUtil;

public abstract class HibernateAccessor {

	private static final LogUtil logger = LogUtil.getInstance(DAOActivator.getDefault().getBundle().getSymbolicName());
	
	/**
	 * Never flush is a good strategy for read-only units of work.
	 * Hibernate will not track and look for changes in this case,
	 * avoiding any overhead of modification detection.
	 * <p>In case of an existing Session, FLUSH_NEVER will turn the flush mode
	 * to NEVER for the scope of the current operation, resetting the previous
	 * flush mode afterwards.
	 * @see #setFlushMode
	 */
	public static final int FLUSH_NEVER = 0;

	/**
	 * Automatic flushing is the default mode for a Hibernate Session.
	 * A session will get flushed on transaction commit, and on certain find
	 * operations that might involve already modified instances, but not
	 * after each unit of work like with eager flushing.
	 * <p>In case of an existing Session, FLUSH_AUTO will participate in the
	 * existing flush mode, not modifying it for the current operation.
	 * This in particular means that this setting will not modify an existing
	 * flush mode NEVER, in contrast to FLUSH_EAGER.
	 * @see #setFlushMode
	 */
	public static final int FLUSH_AUTO = 1;

	/**
	 * Eager flushing leads to immediate synchronization with the database,
	 * even if in a transaction. This causes inconsistencies to show up and throw
	 * a respective exception immediately, and JDBC access code that participates
	 * in the same transaction will see the changes as the database is already
	 * aware of them then. But the drawbacks are:
	 * <ul>
	 * <li>additional communication roundtrips with the database, instead of a
	 * single batch at transaction commit;
	 * <li>the fact that an actual database rollback is needed if the Hibernate
	 * transaction rolls back (due to already submitted SQL statements).
	 * </ul>
	 * <p>In case of an existing Session, FLUSH_EAGER will turn the flush mode
	 * to AUTO for the scope of the current operation and issue a flush at the
	 * end, resetting the previous flush mode afterwards.
	 * @see #setFlushMode
	 */
	public static final int FLUSH_EAGER = 2;

	/**
	 * Flushing at commit only is intended for units of work where no
	 * intermediate flushing is desired, not even for find operations
	 * that might involve already modified instances.
	 * <p>In case of an existing Session, FLUSH_COMMIT will turn the flush mode
	 * to COMMIT for the scope of the current operation, resetting the previous
	 * flush mode afterwards. The only exception is an existing flush mode
	 * NEVER, which will not be modified through this setting.
	 * @see #setFlushMode
	 */
	public static final int FLUSH_COMMIT = 3;

	/**
	 * Flushing before every query statement is rarely necessary.
	 * It is only available for special needs.
	 * <p>In case of an existing Session, FLUSH_ALWAYS will turn the flush mode
	 * to ALWAYS for the scope of the current operation, resetting the previous
	 * flush mode afterwards.
	 * @see #setFlushMode
	 */
	public static final int FLUSH_ALWAYS = 4;
	private int flushMode = FLUSH_AUTO;
	private String[] filterNames;
	
	/**
	 * Set the flush behavior to one of the constants in this class.
	 * Default is FLUSH_AUTO.
	 * @see #setFlushModeName
	 * @see #FLUSH_AUTO
	 */
	public void setFlushMode(int flushMode) {
		this.flushMode = flushMode;
	}

	/**
	 * Return if a flush should be forced after executing the callback code.
	 */
	public int getFlushMode() {
		return this.flushMode;
	}

	/**
	 * Apply the flush mode that's been specified for this accessor
	 * to the given Session.
	 * @param session the current Hibernate Session
	 * @param existingTransaction if executing within an existing transaction
	 * @return the previous flush mode to restore after the operation,
	 * or <code>null</code> if none
	 * @see #setFlushMode
	 * @see org.hibernate.Session#setFlushMode
	 */
	protected FlushMode applyFlushMode(Session session, boolean existingTransaction) {
		if (getFlushMode() == FLUSH_NEVER) {
			if (existingTransaction) {
				FlushMode previousFlushMode = session.getFlushMode();
				if (!previousFlushMode.lessThan(FlushMode.COMMIT)) {
					session.setFlushMode(FlushMode.NEVER);
					return previousFlushMode;
				}
			}
			else {
				session.setFlushMode(FlushMode.NEVER);
			}
		}
		else if (getFlushMode() == FLUSH_EAGER) {
			if (existingTransaction) {
				FlushMode previousFlushMode = session.getFlushMode();
				if (!previousFlushMode.equals(FlushMode.AUTO)) {
					session.setFlushMode(FlushMode.AUTO);
					return previousFlushMode;
				}
			}
			else {
				// rely on default FlushMode.AUTO
			}
		}
		else if (getFlushMode() == FLUSH_COMMIT) {
			if (existingTransaction) {
				FlushMode previousFlushMode = session.getFlushMode();
				if (previousFlushMode.equals(FlushMode.AUTO) || previousFlushMode.equals(FlushMode.ALWAYS)) {
					session.setFlushMode(FlushMode.COMMIT);
					return previousFlushMode;
				}
			}
			else {
				session.setFlushMode(FlushMode.COMMIT);
			}
		}
		else if (getFlushMode() == FLUSH_ALWAYS) {
			if (existingTransaction) {
				FlushMode previousFlushMode = session.getFlushMode();
				if (!previousFlushMode.equals(FlushMode.ALWAYS)) {
					session.setFlushMode(FlushMode.ALWAYS);
					return previousFlushMode;
				}
			}
			else {
				session.setFlushMode(FlushMode.ALWAYS);
			}
		}
		return null;
	}
	
	/**
	 * Set the name of a Hibernate filter to be activated for all
	 * Sessions that this accessor works with.
	 * <p>This filter will be enabled at the beginning of each operation
	 * and correspondingly disabled at the end of the operation.
	 * This will work for newly opened Sessions as well as for existing
	 * Sessions (for example, within a transaction).
	 * @see #enableFilters(org.hibernate.Session)
	 * @see org.hibernate.Session#enableFilter(String)
	 * @see LocalSessionFactoryBean#setFilterDefinitions
	 */
	public void setFilterName(String filter) {
		this.filterNames = new String[] {filter};
	}

	/**
	 * Set one or more names of Hibernate filters to be activated for all
	 * Sessions that this accessor works with.
	 * <p>Each of those filters will be enabled at the beginning of each
	 * operation and correspondingly disabled at the end of the operation.
	 * This will work for newly opened Sessions as well as for existing
	 * Sessions (for example, within a transaction).
	 * @see #enableFilters(org.hibernate.Session)
	 * @see org.hibernate.Session#enableFilter(String)
	 * @see LocalSessionFactoryBean#setFilterDefinitions
	 */
	public void setFilterNames(String[] filterNames) {
		this.filterNames = filterNames;
	}

	/**
	 * Return the names of Hibernate filters to be activated, if any.
	 */
	public String[] getFilterNames() {
		return this.filterNames;
	}
	/**
	 * Enable the specified filters on the given Session.
	 * @param session the current Hibernate Session
	 * @see #setFilterNames
	 * @see org.hibernate.Session#enableFilter(String)
	 */
	protected void enableFilters(Session session) {
		String[] filterNames = getFilterNames();
		if (filterNames != null) {
			for (int i = 0; i < filterNames.length; i++) {
				session.enableFilter(filterNames[i]);
			}
		}
	}
	
	/**
	 * Disable the specified filters on the given Session.
	 * @param session the current Hibernate Session
	 * @see #setFilterNames
	 * @see org.hibernate.Session#disableFilter(String)
	 */
	protected void disableFilters(Session session) {
		String[] filterNames = getFilterNames();
		if (filterNames != null) {
			for (int i = 0; i < filterNames.length; i++) {
				session.disableFilter(filterNames[i]);
			}
		}
	}
	
	/**
	 * Flush the given Hibernate Session if necessary.
	 * @param session the current Hibernate Session
	 * @param existingTransaction if executing within an existing transaction
	 * @throws HibernateException in case of Hibernate flushing errors
	 */
	protected void flushIfNecessary(Session session, boolean existingTransaction) throws HibernateException {
		if (getFlushMode() == FLUSH_EAGER || (!existingTransaction && getFlushMode() != FLUSH_NEVER)) {
			logger.info(Messages.EAGERLY_FLUSHING_HIBERNATE_SESSION);
			session.flush();
		}
	}
}
