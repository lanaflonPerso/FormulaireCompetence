package fr.dawan.bean;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-15T21:42:02.561+0200")
@StaticMetamodel(Classe.class)
public class Classe_ extends DbObject_ {
	public static volatile SetAttribute<Classe, Quiz> quizs;
	public static volatile SingularAttribute<Classe, Professor> professor;
	public static volatile ListAttribute<Classe, Student> students;
	public static volatile SingularAttribute<Classe, Date> startDate;
	public static volatile SingularAttribute<Classe, Date> endDate;
}
