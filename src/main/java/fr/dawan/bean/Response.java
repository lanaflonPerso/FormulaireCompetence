package fr.dawan.bean;

import javax.persistence.Entity;

/**
 * The Class Response.
 * @author PierreM
 */

@Entity
public class Response extends DbObject {

	/** The is valid. */
	private boolean isValid;
	
	//********************Getters / Setters******************
	
	/**
	 * Checks if is valid.
	 *
	 * @return true, if is valid
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Sets the valid.
	 *
	 * @param isValid true if it's a right response or false if it's a wrong response.
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	//******************** Constructors ********************
	
	/**
	 * Instantiates a new reponse.
	 *
	 * @param value the name
	 * @param isValid :  right or wrong response.
	 */
	public Response(String value, boolean isValid) {
		this.setName(value);
		this.isValid = isValid;
	}
	
	//******************** Others ********************
	
	/* (non-Javadoc)
	 * @see fr.dawan.bean.DbObject#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (isValid ? 1231 : 1237);
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
		Response other = (Response) obj;
		if (isValid != other.isValid)
			return false;
		return true;
	}
	
	
	
}
