package fr.dawan.bean;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;

@Entity
public class Question extends DbObject {
	private static final long serialVersionUID = 1L;
	
	private String titleQuestion;
	@ElementCollection
	private Set<String> responses;
	
	//********************Getters / Setters******************
	public String getTitleQuestion() {
		return titleQuestion;
	}
	public void setTitleQuestion(String titleQuestion) {
		this.titleQuestion = titleQuestion;
	}
}
