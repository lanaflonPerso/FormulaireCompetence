package fr.dawan.bean;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-15T21:42:02.773+0200")
@StaticMetamodel(Quiz.class)
public class Quiz_ extends DbObject_ {
	public static volatile SingularAttribute<Quiz, Competence> competence;
	public static volatile SetAttribute<Quiz, Question> questions;
	public static volatile SingularAttribute<Quiz, LocalDate> dateDebut;
	public static volatile SingularAttribute<Quiz, LocalDate> dateFin;
	public static volatile SingularAttribute<Quiz, Professor> author;
}
