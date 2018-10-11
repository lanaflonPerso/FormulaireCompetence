package fr.dawan.bean;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


// TODO: Auto-generated Javadoc
/**
 * The Class Student.
 * @author PierreM
 */
@Entity
public class Student extends Person {
	
	/** The competences. */
	@ManyToOne
	private Competence[] competences;

	
	/**
	 * Gets the competences.
	 *
	 * @return the competences
	 */
	public Competence[] getCompetences() {
		return competences;
	}

	/**
	 * Sets the competences.
	 *
	 * @param competences the new competences
	 */
	public void setCompetences(Competence[] competences) {
		this.competences = competences;
	}
	
	
	
}
