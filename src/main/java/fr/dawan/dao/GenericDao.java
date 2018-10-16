package fr.dawan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.dawan.bean.DbObject;

/**
 * The Class GenericDao.
 */
public class GenericDao {

	/**
	 * Save or update.
	 *
	 * @param <T> the generic type
	 * @param item the item
	 * @param em the em
	 * @param closeConnection the close connection
	 */
	public <T extends DbObject> void saveOrUpdate(T item,EntityManager em,boolean closeConnection) {
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			if(item.getId()==null)
				em.persist(item);
			else
				em.merge(item);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		if(closeConnection)
			em.close();
	}
	
	/**
	 * Delete.
	 *
	 * @param <T> the generic type
	 * @param item the item
	 * @param em the em
	 * @param closeConnection the close connection
	 */
	public <T extends DbObject> void delete(T item,EntityManager em,boolean closeConnection) {
		EntityTransaction tx=em.getTransaction();
		try {
			tx.begin();
			if(item.getId()!=null)
				em.remove(item);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		if(closeConnection)
			em.close();
	}
	
	/**
	 * Find by id.
	 *
	 * @param <T> the generic type
	 * @param clazz the clazz
	 * @param id the id
	 * @param em the em
	 * @param closeConnection the close connection
	 * @return the t
	 */
	public  <T extends DbObject>  T findById(Class<T> clazz, int id,EntityManager em,boolean closeConnection) {
		T item=em.find(clazz,id);
		if(closeConnection)
			em.close();
		return item;
	}
	
	/**
	 * Find all.
	 *
	 * @param <T> the generic type
	 * @param clazz the clazz
	 * @param em the em
	 * @param begin the begin
	 * @param end the end
	 * @param closeConnection the close connection
	 * @return the list
	 */
	public <T extends DbObject>  List<T> findAll(Class<T> clazz,EntityManager em,boolean closeConnection) {
		TypedQuery<T> query=em.createQuery("select entity from "+ clazz.getName() + " entity",clazz);
		List<T> result=query.getResultList();
		if(closeConnection)
			em.close();
		return result;
	}
	
}
