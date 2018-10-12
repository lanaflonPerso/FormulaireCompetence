package fr.dawan.bean;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Abstract Class Person.
 * @author PierreM
 */
@Table
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Person extends DbObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private List<Classe> classes;
	
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
	public List<Classe> getClasses() {
		return classes;
	}
	
	/**
	 * Sets the competences.
	 *
	 * @param competences the new competences
	 */
	public void setClasses(List<Classe> classe) {
		this.classes = classe;
	}
}
