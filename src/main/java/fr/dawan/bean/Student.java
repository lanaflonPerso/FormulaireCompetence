package fr.dawan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Class Student.
 */
@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Student extends Person {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The classes. */
	@ManyToMany(mappedBy = "students")
	private List<Classe> classes = new ArrayList<Classe>();

	/** The competences. */
	@OneToMany(cascade = { CascadeType.PERSIST })
	private List<Competence> competences = new ArrayList<Competence>();
	
	/** The token. */
	private String token;

	/**
	 * Gets the classes.
	 *
	 * @return the classes
	 */
	// ********************Getters / Setters******************
	public List<Classe> getClasses() {
		return classes;
	}

	/**
	 * Sets the classes.
	 *
	 * @param classes the new classes
	 */
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

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
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	// ******************** Methods **********************

	/**
	 * Adds the competence.
	 *
	 * @param competence the competence
	 */
	public void addCompetence(Competence competence) {
		if (!this.competences.contains(competence))
			this.competences.add(competence);
	}
	
	public void addClasse(Classe classe) {
		if (!this.classes.contains(classe))
			this.classes.add(classe);
	}
}
