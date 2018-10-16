package fr.dawan.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.bean.Professor;

public class ProfessorDao extends GenericDao {

	public Professor findByEmailAndPassword(String email, String password, EntityManager em, boolean closeConnection) {
		
		Query query = em.createQuery("SELECT P FROM Professor P WHERE P.email = :email AND P.password= :password");
		query.setParameter("email", email) ;
		query.setParameter("password", password) ;

		Professor professor= (Professor) query.getSingleResult();
		
		if(closeConnection) {
			em.close();
		}
		
		return professor;
	}
}
