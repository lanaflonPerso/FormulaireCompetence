package fr.dawan.bean;

import javax.persistence.Entity;

import fr.dawan.enums.CompetenceStatus;

/**
 * The Class Competence.
 * @author PierreM
 */

@Entity
public class Competence extends DbObject {

	/** The status. */
	private CompetenceStatus status;

	
	//********************Getters / Setters******************
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public CompetenceStatus getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(CompetenceStatus status) {
		this.status = status;
	}
	
	
	//******************** Constructors ********************
	
	/**
	 * Instantiates a new competence.
	 *
	 * @param name the name
	 * @param status the status
	 */
	public Competence(String name, CompetenceStatus status) {
		this.setName(name);
		this.status = status;
	}
	
	/**
	 * Instantiates a new competence.
	 *
	 * @param name the name of the competence
	 */
	public Competence(String name) {
		this.setName(name);
	}

	
	//******************** Others ********************
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + " : " + status ;
	}

	/* (non-Javadoc)
	 * @see fr.dawan.bean.DbObject#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see fr.dawan.bean.DbObject#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
}
