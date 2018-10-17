package fr.dawan.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Question extends DbObject {
	private static final long serialVersionUID = 1L;
	
	private String titleQuestion;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Response> responses=new HashSet<Response>();
	
	//********************Setters Perso**********************
	public void setResponse(Response response) {
		this.responses.add(response);
	}
	
	//********************Getters / Setters******************
	public String getTitleQuestion() {
		return titleQuestion;
	}
	public void setTitleQuestion(String titleQuestion) {
		this.titleQuestion = titleQuestion;
	}
	public Set<Response> getResponses() {
		return responses;
	}
	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}

	//********************Override***************************
	@Override
	public String toString() {
		return "Question [titleQuestion=" + titleQuestion + ", responses=" + responses + "]";
	}
}
