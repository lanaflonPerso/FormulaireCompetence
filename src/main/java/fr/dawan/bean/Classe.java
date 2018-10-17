package fr.dawan.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The Class Classe.
 */
@Entity
public class Classe extends DbObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The name. */
	private String name;

	/** The quizs. */
	@ManyToMany(cascade = { CascadeType.PERSIST })
	private Set<Quiz> quizs = new HashSet<Quiz>();

	/** The professor. */
	@ManyToMany(cascade = { CascadeType.PERSIST })
	private List<Professor> professors = new ArrayList<Professor>();

	/** The students. */
	@ManyToMany(cascade = { CascadeType.PERSIST })
	private List<Student> students = new ArrayList<Student>();

	/** The start date. */
	@Temporal(TemporalType.DATE)
	private Date startDate;

	/** The end date. */
	@Temporal(TemporalType.DATE)
	private Date endDate;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	// ********************Getters / Setters******************
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the quizs.
	 *
	 * @return the quizs
	 */
	public Set<Quiz> getQuizs() {
		return quizs;
	}

	/**
	 * Sets the quizs.
	 *
	 * @param quizs the new quizs
	 */
	public void setQuizs(Set<Quiz> quizs) {
		this.quizs = quizs;
	}

	/**
	 * Gets the professor.
	 *
	 * @return the professor
	 */
	public List<Professor> getProfessor() {
		return professors;
	}

	/**
	 * Sets the professor.
	 *
	 * @param professor the new professor
	 */
	public void setProfessor(List<Professor> professor) {
		this.professors = professor;
	}

	/**
	 * Gets the students.
	 *
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Sets the students.
	 *
	 * @param students the new students
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	// ******************** Methods **********************

	/**
	 * Adds the student.
	 *
	 * @param student the student
	 */
	public void addStudent(Student student) {
		if (!students.contains(student))
			students.add(student);
	}

	/**
	 * Adds the professor.
	 *
	 * @param professor the professor
	 */
	public void addProfessor(Professor professor) {
		if (!professors.contains(professor))
			professors.add(professor);
	}

	/**
	 * Adds the quizz.
	 *
	 * @param quiz the quiz
	 */
	public void addQuizz(Quiz quiz) {
		quizs.add(quiz);
	}

}
