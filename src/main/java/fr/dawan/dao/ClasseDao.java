package fr.dawan.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.dawan.bean.Classe;
import fr.dawan.bean.Professor;
import fr.dawan.bean.Student;

public class ClasseDao extends GenericDao {

	public List<Classe> findByProfessor(Professor professor,boolean archived,EntityManager em, boolean closeConnection){
		String jpqlReq="SELECT entity FROM Classe entity INNER JOIN entity.professors p WHERE p=:professor";
		if(archived) {
			jpqlReq+=" AND :now BETWEEN entity.startDate AND entity.endDate";
		}
		else { 
			jpqlReq+=" AND entity.endDate<:now";
		}
		TypedQuery<Classe> query=em.createQuery(jpqlReq,Classe.class);
		query.setParameter("professor", professor);
		query.setParameter("now", new Date());
		List<Classe> classes=query.getResultList();
		if(closeConnection)
			em.close();
		return classes;
	}
	
	public List<Student> findStudentById(Classe classe, EntityManager em, boolean closeConnection) {

		Query query= em.createQuery("SELECT C.students FROM Classe C WHERE C.id= :id");
		query.setParameter("id", classe.getId());
		@SuppressWarnings("unchecked")
		List<Student> students= query.getResultList();
		if(closeConnection)
			em.close();
		return students;
	}
}
