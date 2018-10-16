package fr.dawan.bean;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DbObject implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// ********************Getters / Setters******************
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	// ******************** Others ********************

}
