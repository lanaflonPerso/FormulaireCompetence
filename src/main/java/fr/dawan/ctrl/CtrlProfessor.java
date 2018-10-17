package fr.dawan.ctrl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dawan.bean.Professor;
import fr.dawan.dao.ProfessorDao;

public class CtrlProfessor extends Ctrl {
	
	private String msgConnection;
	private Professor professor;

	public void ctrlEmailAndPassword(String email, String password) {
		EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
		EntityManager em= eef.createEntityManager();
		ProfessorDao dao= new ProfessorDao();
		Professor professor= dao.findByEmailAndPassword(email, MySQLPassword(password), em, true);
		if (professor == null) {
			this.professor= new Professor();
			this.professor.setEmail(email);
			msgConnection= "les identifiants ne son pas correct!";
			error= true;
		} else {
			this.professor= professor;
		}
	}

	//********************Getters*****************************
	public String getMsgConnection() {
		return msgConnection;
	}
	public Professor getProfessor() {
		return professor;
	}
}
