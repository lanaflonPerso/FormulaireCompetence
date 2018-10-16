package fr.dawan.ctrl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.dawan.bean.Student;
import fr.dawan.dao.StudentDao;

public class CtrlStudent extends Ctrl {
	
	private final LocalDate NOW= LocalDate.now(); 
	private final Pattern VALID_BITHDAY_REGEX= Pattern.compile("^[0-9]{4}-[0-9]{2}-[0-9]{2}$", Pattern.CASE_INSENSITIVE);
	private final Pattern VALID_EMAIL_ADDRESS_REGEX= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private final int LENGTH_NAME_MIN= 2;
	private final int LENGTH_NAME_MAX= 100;

	private String msgConnection;
	private String msgFirstname;
	private String msgLastname;
	private String msgEmail;
	private String msgBirthDate;
	private String msgPassword;
	private String msgToken;
	private Student student;
	
	public CtrlStudent() {
		
	}
	
	public CtrlStudent(String firstname, String lastname, String email, String birthDate) {
		student= new Student();
		ctrlFirstname(firstname);
		student.setFirstname(firstname);
		ctrlLastname(lastname);
		student.setLastname(lastname);
		ctrlEmail(email);
		student.setEmail(email);
		Date valdBirthDate= ctrlBirthDate(birthDate);
		student.setBirthDate(valdBirthDate);
	}
	
	public void ctrlTokenAndPassword(String token, String password, String confirm) {
		ctrlToken(token);
		ctrlPassword(password);
		ctrlPasswordEqual(password, confirm);
		student.setPassword(MySQLPassword(password));
	}
	
	public void ctrlEmailAndPassword(String email, String password) {
		EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
		EntityManager em= eef.createEntityManager();
		StudentDao dao= new StudentDao();
		Student student= dao.findByEmailAndPassword(email, MySQLPassword(password), em, true);
		if (student == null) {
			this.student= new Student();
			this.student.setEmail(email);
			msgConnection= "les identifiants ne son pas correct!";
			error= true;
		} else {
			this.student= student;
		}
	}
	
	public void ctrlPassword(String password) {
		if(password.length() < 7 ) {
			msgPassword= "le mot de passe doit comprendre 6 caractéres minimum";
			error= true;
		}
	}
	
	public void ctrlPasswordEqual(String password, String confirm) {
		if (!password.equals(confirm)) {
			msgPassword= "Erreur dans la confirmation du mot de passe";
			error= true;
		}
	}
	

	public void ctrlFirstname(String firstname) {
		if (firstname.length() < LENGTH_NAME_MIN || firstname.length() > LENGTH_NAME_MAX) {
			msgFirstname= "le prénom doit comprendre entre "+ LENGTH_NAME_MIN +" et "+ LENGTH_NAME_MAX;
			this.error= true;
		}
	}
	
	public void ctrlLastname(String lastname) {
		if (lastname.length() < LENGTH_NAME_MIN || lastname.length() > LENGTH_NAME_MAX) {
			msgLastname= "le nom doit comprendre entre "+ LENGTH_NAME_MIN +" et "+ LENGTH_NAME_MAX;
			this.error= true;
		}
	}
	
	public void ctrlEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if(!matcher.find()) {
        	msgEmail= "l'adresse email n'ai pas valide";
        	this.error= true;
        }
	}
	
	public Date ctrlBirthDate(String birthDate) {
		Date result= null;
		Matcher matcher = VALID_BITHDAY_REGEX.matcher(birthDate);
		
		if(!matcher.find()) {
			msgBirthDate= "date de naissance invalide";
			error= true;
		}else {
			String[] tab= birthDate.split("-");
			int day= Integer.valueOf(tab[2]);
			int month= Integer.valueOf(tab[1]);
			int year= Integer.valueOf(tab[0]);
			if(year > NOW.getYear()-2 || year < NOW.getYear()-62) {
				msgBirthDate= "l'âge n'est pas valide";
				error= true;
			}else {
				LocalDate localDate= LocalDate.of(year, month, day);
				result= Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
			}
		}		
		return result;
	}
	
	public void ctrlToken(String token) {
		EntityManagerFactory eef= Persistence.createEntityManagerFactory("FormulaireCompetence");
		EntityManager em= eef.createEntityManager();
		StudentDao dao= new StudentDao();
		Student student= dao.findByToken(token, em, true);
		if (student == null) {
			msgToken= "le token ne correspont a aucun compte";
			error= true;
		} else {
			this.student= student;
		}
	}
	
	//********************Getters*****************************
	public String getMsgFirstname() {
		return msgFirstname;
	}
	public String getMsgLastname() {
		return msgLastname;
	}
	public String getMsgEmail() {
		return msgEmail;
	}
	public String getMsgBirthDate() {
		return msgBirthDate;
	}
	public Student getStudent() {
		return student;
	}
	public String getMsgPassword() {
		return msgPassword;
	}
	public String getMsgToken() {
		return msgToken;
	}
	public String getMsgConnection() {
		return msgConnection;
	}

	@Override
	public String toString() {
		return "CtrlStudent [msgFirstname=" + msgFirstname + ", msgLastname=" + msgLastname + ", msgEmail=" + msgEmail
				+ ", msgBirthDate=" + msgBirthDate + "]";
	}
}
