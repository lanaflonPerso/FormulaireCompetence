package fr.dawan.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Professor.
 */
@Entity
@Table
public class Professor extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The administrator. */
	private boolean administrator;

	/**
	 * Checks if is administrator.
	 *
	 * @return true, if is administrator
	 */
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

}
