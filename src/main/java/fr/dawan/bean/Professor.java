package fr.dawan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * The Class Professor.
 */
@Entity
@Table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Professor extends Person{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The administrator. */
	private boolean administrator;
	
	/** The classes. */
	@ManyToMany(mappedBy="professors")
	private List<Classe> classes=new ArrayList<Classe>();

	/**
	 * Checks if is administrator.
	 *
	 * @return true, if is administrator
	 */
	//********************Getters / Setters******************
	public boolean isAdministrator() {
		return administrator;
	}
	
	/**
	 * Sets the administrator.
	 *
	 * @param administrator the new administrator
	 */
	public void setAdministrator(boolean administrator) {
		this.administrator = administrator;
	}
	
	/**
	 * Gets the classes.
	 *
	 * @return the classes
	 */
	public List<Classe> getClasses() {
		return classes;
	}
	
	/**
	 * Sets the classes.
	 *
	 * @param classes the new classes
	 */
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
	// ******************** Methods **********************

	public void addClasse(Classe classe) {
		if (!this.classes.contains(classe))
			this.classes.add(classe);
	}
}
