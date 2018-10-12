package fr.dawan.bean;

import java.time.LocalDate;
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
	
	/** The competence. */
	private Competence competence;
	
	/** The questions. */
	@OneToMany(cascade= {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Set<Question> questions;
	
	/** The date debut. */
	@Temporal(TemporalType.DATE)
	private LocalDate dateDebut;
	
	/** The date fin. */
	@Temporal(TemporalType.DATE)
	private LocalDate dateFin;
	
	/** The author. */
	@ManyToOne
	private Professor author;
	
	//********************Getters / Setters******************

	/**
	 * Gets the competence.
	 *
	 * @return the competence
	 */
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
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Sets the date debut.
	 *
	 * @param dateDebut the new date debut
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Gets the date fin.
	 *
	 * @return the date fin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Sets the date fin.
	 *
	 * @param dateFin the new date fin
	 */
	public void setDateFin(LocalDate dateFin) {
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
	
	//******************** Constructors ********************
	
	public Quiz(String name, Professor author) {
		setName(name);
		this.author = author;
	}
	
	//******************** Methods **********************
	
	public boolean isActive() {
		LocalDate now = LocalDate.now();
		if ((now.isAfter(dateDebut) && now.isBefore(dateFin)))
			return true;
		return false;
	}
	
}
