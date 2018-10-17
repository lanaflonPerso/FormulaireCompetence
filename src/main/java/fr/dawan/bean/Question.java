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
	@OneToMany(cascade = { CascadeType.PERSIST })
	private Set<Response> responses=new HashSet<Response>();
	
	//********************Getters / Setters******************
	public String getTitleQuestion() {
		return titleQuestion;
	}
	public void setTitleQuestion(String titleQuestion) {
		this.titleQuestion = titleQuestion;
	}
	
	// ******************** Methods **********************

	public void addValidResponse(String value) {
		responses.add(new Response(value, true));
	}

	public void addUnvalidResponse(String value) {
		responses.add(new Response(value, false));
	}


}
