package fr.dawan.bean;

import java.util.Date;
import java.util.HashSet;
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
	
	@ManyToOne(cascade = { CascadeType.PERSIST})
	private Competence competence;
	
	@OneToMany(cascade= {CascadeType.PERSIST})
	private Set<Question> questions= new HashSet<Question>();
	
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	@ManyToOne(cascade= {CascadeType.PERSIST})
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
	
	//******************** Methods **********************
	
	/**
	 * Checks if is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		Date now = new Date();
		return now.after(dateDebut) && now.before(dateFin);
	}
	
	/**
	 * Adds the question.
	 *
	 * @param question the question
	 */
	public void addQuestion(Question question) {
		if(!questions.contains(question))
			questions.add(question);
	}

}
