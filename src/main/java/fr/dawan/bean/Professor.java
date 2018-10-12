package fr.dawan.bean;

import javax.persistence.Entity;

/**
 * The Class Professor.
 */
@Entity
public class Professor extends Person{
	
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
