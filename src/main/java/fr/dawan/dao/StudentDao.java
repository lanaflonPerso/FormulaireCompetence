package fr.dawan.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.bean.Student;

public class StudentDao extends GenericDao {

	public Student findByToken(String token, EntityManager em, boolean closeConnection) {
		
		Query query = em.createQuery("SELECT S FROM Student S WHERE S.token = :token");
		query.setParameter("token", token) ;

		Student student= (Student) query.getSingleResult();
		
		if(closeConnection) {
			em.close();
		}
		
		return student;
	}
	
	public Student findByEmailAndPassword(String email, String password, EntityManager em, boolean closeConnection) {
		
		Query query = em.createQuery("SELECT S FROM Student S WHERE S.email = :email AND S.password= :password");
		query.setParameter("email", email) ;
		query.setParameter("password", password) ;

		Student student= (Student) query.getSingleResult();
		
		if(closeConnection) {
			em.close();
		}
		
		return student;
	}
}
