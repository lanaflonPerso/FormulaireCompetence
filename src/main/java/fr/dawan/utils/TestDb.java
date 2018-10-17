package fr.dawan.utils;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dawan.bean.Classe;
import fr.dawan.bean.Competence;
import fr.dawan.bean.Professor;
import fr.dawan.bean.Question;
import fr.dawan.bean.Quiz;
import fr.dawan.bean.Student;
import fr.dawan.dao.GenericDao;
import fr.dawan.enums.CompetenceStatus;

public class TestDb {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("FormulaireCompetence");
		EntityManager em = emf.createEntityManager();
		generate(em);
	}
	/**
	 * Generate.
	 *
	 * @param em the em
	 */
	public static void generate(EntityManager em) {
		GenericDao dao = new GenericDao();
		Professor prof1 = genProfessor("Gene", "Hunt", "lom70");
		prof1.setAdministrator(true);
		Professor prof2 = genProfessor("Sam", "Tyler", "lom70");
		Professor prof3 = genProfessor("Alex", "Drake", "ata80");

		Student stud1 = genStudent("Kevin", "Dupond", "123456");
		Student stud2 = genStudent("Jonathan", "Durand", "123456");
		Student stud3 = genStudent("Steven", "Bertrand", "123456");
		Student stud4 = genStudent("Toufik", "Anseur", "123456");
		Student stud5 = genStudent("Pascal", "Lucas", "123456");
		Student stud6 = genStudent("Alain", "Aubry", "123456");
		Student stud7 = genStudent("Frédérique", "Courdesse", "123456");
		Student stud8 = genStudent("Daniel", "Courdesse", "123456");
		Student stud9 = genStudent("Nelly", "Boeuf", "123456");
		Student stud10 = genStudent("Freddy", "Coppin", "123456");
		stud10.addCompetence(new Competence("Jpa", CompetenceStatus.Acquis));

		Competence comp1 = new Competence("Collection java");
		Competence comp2 = new Competence("L'objet en java");
		Competence comp3 = new Competence("Jpa");

		Quiz quiz1 = genQuiz("Quiz 1 sur les collections java", comp1, prof1, new Date(), 10, 4);
		Quiz quiz2 = genQuiz("Quiz 2 sur les collections java", comp1, prof3, new Date(), 20, 3);
		Quiz quiz3 = genQuiz("Quiz sur les objets en java", comp2, prof2, new Date(), 10, 3);
		Quiz quiz4 = genQuiz("Quiz sur jpa", comp3, prof1, new Date(), 15, 2);
		Quiz quiz5 = genQuiz("Quiz sur hibernate", comp3, prof2, new Date(), 10, 3);

		Classe classe1 = genClasse("DUT Info année 1", prof1, new Date());
		affectStudentToCLasse(classe1,stud1);
		affectStudentToCLasse(classe1,stud2);
		affectStudentToCLasse(classe1,stud3);
		affectStudentToCLasse(classe1,stud4);
		classe1.addQuizz(quiz1);
		classe1.addQuizz(quiz2);
		classe1.addQuizz(quiz3);

		Classe classe2 = genClasse("DUT Info année 2", prof3, new Date());
		affectStudentToCLasse(classe2,stud5);
		affectStudentToCLasse(classe2,stud6);
		affectStudentToCLasse(classe2,stud7);
		classe2.addQuizz(quiz2);
		classe2.addQuizz(quiz5);

		Classe classe3 = genClasse("Licence pro info", prof2, new Date());
		affectStudentToCLasse(classe3,stud8);
		affectStudentToCLasse(classe3,stud9);
		classe3.addQuizz(quiz1);
		classe3.addQuizz(quiz4);
		
		Classe classe4 = genClasse("Licence info année 3", prof1, new Date());
		affectStudentToCLasse(classe4,stud2);
		affectStudentToCLasse(classe4,stud3);
		affectStudentToCLasse(classe4,stud4);
		classe4.addQuizz(quiz5);
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2018);
		c.set(Calendar.MONTH, 7);
		c.set(Calendar.DAY_OF_MONTH, 10);
		Classe classe5 = genClasse("Licence info année 1", prof1, c.getTime());
		classe5.addStudent(stud10);
		classe5.addQuizz(quiz4);

		dao.saveOrUpdate(classe1, em, false);
		dao.saveOrUpdate(classe2, em, false);
		dao.saveOrUpdate(classe3, em, false);
		dao.saveOrUpdate(classe4, em, false);
		dao.saveOrUpdate(classe5, em, true);

		System.out.println("Base de test générée");
	}

	/**
	 * Gen professor.
	 *
	 * @param firstName the first name
	 * @param name the name
	 * @param password the password
	 * @return the professor
	 */
	private static Professor genProfessor(String firstName, String name, String password) {
		Professor p = new Professor();
		p.setFirstname(firstName);
		p.setLastname(name);
		p.setEmail(firstName.toLowerCase() + "." + name.toLowerCase() + "@laposte.net");
		p.setPassword(password);
		p.setBirthDate(new Date());
		return p;
	}

	/**
	 * Gen student.
	 *
	 * @param firstName the first name
	 * @param name the name
	 * @param password the password
	 * @return the student
	 */
	private static Student genStudent(String firstName, String name, String password) {
		Student s = new Student();
		s.setFirstname(firstName);
		s.setLastname(name);
		s.setEmail(firstName.toLowerCase() + "." + name.toLowerCase() + "@gmail.com");
		s.setPassword(password);
		s.setBirthDate(new Date());
		return s;
	}

	/**
	 * Gen question.
	 *
	 * @param intitule the intitule
	 * @param nbReponse the nb reponse
	 * @param numValide the num valide
	 * @return the question
	 */
	private static Question genQuestion(String intitule, int nbReponse, int numValide) {
		Question q = new Question();
		q.setTitleQuestion(intitule);
		for (int i = 0; i < nbReponse; i++) {
			if (i == numValide)
				q.addValidResponse("Reponse " + i);
			else
				q.addUnvalidResponse("Reponse " + i);
		}
		return q;
	}

	/**
	 * Gen quiz.
	 *
	 * @param name the name
	 * @param competence the competence
	 * @param creator the creator
	 * @param startDate the start date
	 * @param nbQuestion the nb question
	 * @param nbResponse the nb response
	 * @return the quiz
	 */
	private static Quiz genQuiz(String name, Competence competence, Professor creator, Date startDate, int nbQuestion,
			int nbResponse) {
		Quiz quiz = new Quiz();
		quiz.setName(name);
		quiz.setAuthor(creator);
		quiz.setCompetence(competence);
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		c.add(Calendar.WEEK_OF_MONTH, 1);
		quiz.setDateDebut(c.getTime());
		c.add(Calendar.WEEK_OF_MONTH, 1);
		quiz.setDateFin(c.getTime());
		for (int i = 0; i < nbQuestion; i++) {
			quiz.addQuestion(genQuestion("Question " + i, nbResponse, 1));
		}
		return quiz;
	}

	/**
	 * Gen classe.
	 *
	 * @param nom the nom
	 * @param professor the professor
	 * @param startDate the start date
	 * @return the classe
	 */
	private static Classe genClasse(String nom, Professor professor, Date startDate) {
		Classe classe = new Classe();
		classe.setName(nom);
		affectProfessorToCLasse(classe,professor);
		classe.setStartDate(startDate);
		Calendar c = Calendar.getInstance();
		c.setTime(startDate);
		c.add(Calendar.MONTH, 1);
		classe.setEndDate(c.getTime());
		return classe;
	}
	
	
	private static void affectStudentToCLasse(Classe classe, Student student) {
		classe.addStudent(student);
		student.addClasse(classe);
	}
	
	private static void affectProfessorToCLasse(Classe classe, Professor professor) {
		classe.addProfessor(professor);
		professor.addClasse(classe);
	}
}
