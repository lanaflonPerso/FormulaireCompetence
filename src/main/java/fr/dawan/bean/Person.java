package fr.dawan.bean;

import java.util.Date;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Person extends DbObject {
	private static final long serialVersionUID = 1L;

	private String firstname;
	private String lastname;
	private String password;
	private String email;
	@Temporal(TemporalType.DATE)
	private Date birthDate;

	@ManyToOne
	private Classe classes;
	
	//********************Getters / Setters******************
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public Classe getClasses() {
		return classes;
	}
	public void setClasses(Classe classes) {
		this.classes = classes;
	}
}
