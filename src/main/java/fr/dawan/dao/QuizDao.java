package fr.dawan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.dawan.bean.Professor;
import fr.dawan.bean.Quiz;

public class QuizDao extends GenericDao {

	public List<Quiz> findByAuthor(Professor professor,EntityManager em, boolean closeConnection){

		TypedQuery<Quiz> query=em.createQuery("SELECT entity FROM Quiz entity WHERE entity.author=:professor",Quiz.class);
		query.setParameter("professor", professor);
		List<Quiz> quizs=query.getResultList();
		if(closeConnection)
			em.close();
		return quizs;
	}
}