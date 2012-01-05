package edu.eafit.maestria.activa.dao;

import java.util.Collection;
import java.util.List;


/**
 * Common dao operations
 *
 * @param <T>
 */
public interface BasicDao<T> {

	/**
	 * Gets an object by its given id
	 * @param id
	 * @return
	 */
	public T getById(long id);
	
	/**
	 * Saves an object
	 * @param t
	 */
	public void save(T t);
	
	/**
	 * Removes an object
	 * @param id
	 */
	public void remove(long id);
	
	/**
	 * Removes an object
	 * @param id
	 */
	public void delete(T t);
	
	/**
	 * Determines the size of a collection without initializing it
	 * @param collection
	 */
	public int size(Collection<?> collection);
	
	public List<T> getObjects();
}
