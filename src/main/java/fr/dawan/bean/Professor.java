package fr.dawan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Professor extends Person{	
	private static final long serialVersionUID = 1L;
	
	private boolean administrator;

	@ManyToMany(mappedBy="professors")
	private List<Classe> classes=new ArrayList<Classe>();


	//********************Getters / Setters******************
	public boolean isAdministrator() {
		return administrator;
	}
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}
	public List<Classe> getClasses() {
		return classes;
	}
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
	// ******************** Methods **********************
	public void addClasse(Classe classe) {
		if (!this.classes.contains(classe))
			this.classes.add(classe);
	}
}
