package fr.dawan.ctrl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dawan.bean.Competence;
import fr.dawan.bean.Quiz;
import fr.dawan.dao.CompetenceDao;

public class CtrlQuiz extends Ctrl {
	
	private final int LENGTH_NAME_MIN= 2;
	private final int LENGTH_NAME_MAX= 100;

	private Quiz quiz;
	private String msgDateDebut;
	private String msgDateFin;
	private String msgName;
	private String msgCompetence;
	
	public CtrlQuiz() {
		
	}
	
	public void createQuiz(String name, String competence, String dateDebut, String dateFin) {
		quiz= new Quiz();
		ctrlName(name);
		quiz.setName(name);
		Date valDateDebut= ctrlDate(dateDebut);
		Date valDateFin= ctrlDate(dateFin);
		ctrlTwoDate(valDateDebut, valDateFin);
		quiz.setDateDebut(valDateDebut);
		quiz.setDateFin(valDateFin);
		Competence objectCompetence= ctrlCompetence(competence);
		quiz.setCompetence(objectCompetence);
	}
	
	private Competence ctrlCompetence(String name) {
		EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
		EntityManager em= eef.createEntityManager();
		CompetenceDao dao= new CompetenceDao();
		Competence result= dao.findByName(name, em, true);
		if (result == null) {
			result= new Competence(name);
		}
		return result;
	}

	public void ctrlName(String name) {
		if (name.length() < LENGTH_NAME_MIN || name.length() > LENGTH_NAME_MAX) {
			msgName= "l'intitulé doit comprendre entre "+ LENGTH_NAME_MIN +" et "+ LENGTH_NAME_MAX;
			this.error= true;
		}
	}

	public Date ctrlDate(String date) {
		Date result= StringToDate( date);
		
		if(result == null) {
			error= true;	
		} 	
		return result;
	}

	public void ctrlTwoDate(Date begin, Date end) {
		Date transit= null;
		if (begin.compareTo(end) > 0) {
            transit= end;
            end= begin;
            begin= transit;            
        }
	}

	
	//********************Getters / Setters******************
	public Quiz getQuiz() {
		return quiz;
	}

	public String getMsgDateDebut() {
		return msgDateDebut;
	}

	public String getMsgDateFin() {
		return msgDateFin;
	}

	public String getMsgName() {
		return msgName;
	}

	public String getMsgCompetence() {
		return msgCompetence;
	}
}
