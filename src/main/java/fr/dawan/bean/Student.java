package fr.dawan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Student extends Person {
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade= CascadeType.ALL)
	private Classe classe= new Classe();

	@OneToMany(cascade = { CascadeType.PERSIST })
	private List<Competence> competences= new ArrayList<Competence>();
	
	@ManyToMany
	private List<Quiz> quizs= new ArrayList<Quiz>(); 
	
	private String token;
	
	//********************Setters Perso**********************
	public void setQuiz(Quiz quiz) {
		this.quizs.add(quiz);
	}

	// ********************Getters / Setters******************
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public List<Quiz> getQuizs() {
		return quizs;
	}
	public void setQuizs(List<Quiz> quizs) {
		this.quizs = quizs;
	}
}
