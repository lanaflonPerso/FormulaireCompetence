package fr.dawan.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * The Class Student.
 * 
 * @author PierreM
 */
@Entity
@Table
public class Student extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The competences. */
	@ManyToOne
	private List<Competence> competences;

	/**
	 * Gets the competences.
	 *
	 * @return the competences
	 */
	public List<Competence> getCompetences() {
		return competences;
	}

	/**
	 * Sets the competences.
	 *
	 * @param competences the new competences
	 */
	public void setCompetences(List<Competence> competence){
		this.competences = competence;
	}

}
