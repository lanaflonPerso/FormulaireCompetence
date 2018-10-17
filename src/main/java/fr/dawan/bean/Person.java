package fr.dawan.bean;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Person.
 */
@MappedSuperclass
public abstract class Person extends DbObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The firstname. */
	private String firstname;
	
	/** The lastname. */
	private String lastname;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;
	
	/** The birth date. */
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	//********************Getters / Setters******************
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
	public Date getBirthDate() {
		return birthDate;
	}
	
	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
