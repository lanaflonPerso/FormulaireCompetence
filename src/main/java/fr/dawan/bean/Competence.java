package fr.dawan.bean;

import javax.persistence.Entity;

import fr.dawan.enums.CompetenceStatus;

@Entity
public class Competence extends DbObject {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private CompetenceStatus status;

	//******************** Constructors ********************
	public Competence() {}
	public Competence(String name, CompetenceStatus status) {
		this.setName(name);
		this.status = status;
	}
	public Competence(String name) {
		this.setName(name);
	}
	
	//********************Getters / Setters******************
	public CompetenceStatus getStatus() {
		return status;
	}
	public void setStatus(CompetenceStatus status) {
		this.status = status;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
