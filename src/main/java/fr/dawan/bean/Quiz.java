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

/**
 * The Class Quiz.
 */
@Entity
public class Quiz extends DbObject{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private String name;
	
	/** The competence. */
	@ManyToOne(cascade = { CascadeType.PERSIST})
	private Competence competence;
	
	/** The questions. */
	@OneToMany(cascade= {CascadeType.PERSIST})
	private Set<Question> questions= new HashSet<Question>();
	
	/** The date debut. */
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	
	/** The date fin. */
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	
	/** The author. */
	@ManyToOne(cascade= {CascadeType.PERSIST})
	private Professor author;
	
	/**
	 * Instantiates a new quiz.
	 */
	//******************** Constructors ********************
	public Quiz() {}
	
	/**
	 * Instantiates a new quiz.
	 *
	 * @param name the name
	 * @param author the author
	 */
	public Quiz(String name, Professor author) {
		setName(name);
		this.author = author;
	}
	
	/**
	 * Gets the competence.
	 *
	 * @return the competence
	 */
	//********************Getters / Setters******************
	public Competence getCompetence() {
		return competence;
	}
	
	/**
	 * Sets the competence.
	 *
	 * @param competence the new competence
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	/**
	 * Gets the questions.
	 *
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return questions;
	}
	
	/**
	 * Sets the questions.
	 *
	 * @param questions the new questions
	 */
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	
	/**
	 * Gets the date debut.
	 *
	 * @return the date debut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}
	
	/**
	 * Sets the date debut.
	 *
	 * @param dateDebut the new date debut
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	
	/**
	 * Gets the date fin.
	 *
	 * @return the date fin
	 */
	public Date getDateFin() {
		return dateFin;
	}
	
	/**
	 * Sets the date fin.
	 *
	 * @param dateFin the new date fin
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	
	/**
	 * Gets the author.
	 *
	 * @return the author
	 */
	public Professor getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author.
	 *
	 * @param author the new author
	 */
	public void setAuthor(Professor author) {
		this.author = author;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
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
