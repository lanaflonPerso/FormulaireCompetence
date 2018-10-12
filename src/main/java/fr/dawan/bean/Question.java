package fr.dawan.bean;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * The Class Question.
 * @author PierreM
 */
@Entity
public class Question extends DbObject {
	
	/** The responses. */
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.MERGE})
	private Set<Response> responses;

	//********************Getters / Setters******************
	
	/**
	 * Gets the responses.
	 *
	 * @return the responses
	 */
	public Set<Response> getResponses() {
		return responses;
	}

	/**
	 * Sets the responses.
	 *
	 * @param responses the new responses
	 */
	public void setResponses(Set<Response> responses) {
		this.responses = responses;
	}

	//******************** Constructors ********************
	
	/**
	 * Instantiates a new question.
	 *
	 * @param value the value of the response
	 */
	public Question(String value) {
		setName(value);
	}

	//******************** Methods **********************
	
	/**
	 * Adds a valid response.
	 *
	 * @param value the value of the response
	 */
	public void addValidResponse(String value) {
		responses.add(new Response(value, true));
	}
	
	
	/**
	 * Adds an unvalid response.
	 *
	 * @param value the value of the response
	 */
	public void addUnvalidResponse(String value) {
		responses.add(new Response(value, false));
	}
	
	
	//******************** Others ********************
	
	/* (non-Javadoc)
	 * @see fr.dawan.bean.DbObject#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((responses == null) ? 0 : responses.hashCode());
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
		Question other = (Question) obj;
		if (responses == null) {
			if (other.responses != null)
				return false;
		} else if (!responses.equals(other.responses))
			return false;
		return true;
	}
	
}
