package fr.dawan.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Student extends Person {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Classe classe;
	@OneToMany
	private List<Competence> competences;
	private String token;

	//********************Getters / Setters******************
	public List<Competence> getCompetences() {
		return competences;
	}
	public void setCompetences(List<Competence> competences){
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
}
