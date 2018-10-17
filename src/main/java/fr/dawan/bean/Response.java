package fr.dawan.bean;

import javax.persistence.Entity;

@Entity
public class Response extends DbObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8079573036007897371L;
	
	private String value;
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private boolean valid;
	
	//********************Getters / Setters******************

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean isValid) {
		this.valid = isValid;
	}
	
	//******************** Constructors ********************

	public Response(String value, boolean valid) {
		super();
		this.value = value;
		this.valid = valid;
	}

	public Response() {

	}
}
	


