package fr.dawan.bean;

import java.time.LocalDate;

import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Abstract Class Person.
 * @author PierreM
 */
public abstract class Person extends DbObject {

	/** The lastname. */
	private String lastname;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;
	
	/** The birth date. */
	@Temporal(TemporalType.DATE)
	private LocalDate birthDate;
	
	/** The competences. */
	@ManyToOne
	private Classe[] classes;
	
	//********************Getters / Setters******************
	
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * Gets the competences.
	 *
	 * @return the competences
	 */
	public Classe[] getClasses() {
		return classes;
	}
	
	/**
	 * Sets the competences.
	 *
	 * @param competences the new competences
	 */
	public void setCompetences(Classe[] classe) {
		this.classes = classe;
	}
	
	
}
