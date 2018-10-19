package fr.dawan.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Classe extends DbObject {
	private static final long serialVersionUID = 1L;

	private String name;

	@ManyToMany(cascade = { CascadeType.PERSIST })
	private Set<Quiz> quizs = new HashSet<Quiz>();

	@ManyToMany(cascade = { CascadeType.PERSIST })
	private List<Professor> professors = new ArrayList<Professor>();

	@OneToMany(mappedBy="classe")
	private List<Student> students = new ArrayList<Student>();

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	// ********************Getters / Setters******************
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Quiz> getQuizs() {
		return quizs;
	}
	public void setQuizs(Set<Quiz> quizs) {
		this.quizs = quizs;
	}
	public List<Professor> getProfessor() {
		return professors;
	}
	public void setProfessor(List<Professor> professor) {
		this.professors = professor;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
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
