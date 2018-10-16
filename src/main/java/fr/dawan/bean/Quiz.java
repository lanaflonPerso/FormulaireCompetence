package fr.dawan.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Quiz extends DbObject{
	private static final long serialVersionUID = 1L;

	private String name;
	private Competence competence;
	
	@OneToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Set<Question> questions;
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@ManyToOne
	private Professor author;
	
	//******************** Constructors ********************
	public Quiz() {}
	public Quiz(String name, Professor author) {
		setName(name);
		this.author = author;
	}
	
	//********************Getters / Setters******************
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public Professor getAuthor() {
		return author;
	}
	public void setAuthor(Professor author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
