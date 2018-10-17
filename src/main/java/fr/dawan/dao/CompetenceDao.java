package fr.dawan.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import fr.dawan.bean.Competence;

public class CompetenceDao extends GenericDao {

public Competence findByName(String name, EntityManager em, boolean closeConnection) {
	Competence competence= null;
		Query query = em.createQuery("SELECT C FROM Competence C WHERE C.name = :name");
		query.setParameter("name", name) ;

		try {
			competence= (Competence) query.getSingleResult();	
		} catch (Exception e) {}
		
		if(closeConnection) {
			em.close();
		}
		
		return competence;
	}
}
