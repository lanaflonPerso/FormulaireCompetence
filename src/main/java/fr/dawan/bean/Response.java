package fr.dawan.bean;

import javax.persistence.Entity;

@Entity
public class Response extends DbObject {
	private static final long serialVersionUID = 8079573036007897371L;
	
	private String value;
	private boolean valid;
	
	//******************** Constructors ********************
	
	public Response(String value, boolean valid) {
		this.value = value;
		this.valid = valid;
	}
	
	public Response() {
		
	}
	
	//********************Getters / Setters******************
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean isValid) {
		this.valid = isValid;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	//********************Override***************************
	@Override
	public String toString() {
		return "Response [value=" + value + ", valid=" + valid + "]";
	}
}
	


