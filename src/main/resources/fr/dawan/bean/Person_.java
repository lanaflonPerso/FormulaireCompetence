package fr.dawan.bean;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-15T22:48:18.453+0200")
@StaticMetamodel(Person.class)
public class Person_ extends DbObject_ {
	public static volatile SingularAttribute<Person, String> lastname;
	public static volatile SingularAttribute<Person, String> password;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile SingularAttribute<Person, Date> birthDate;
	public static volatile SingularAttribute<Person, Object> classes;
	public static volatile SingularAttribute<Person, String> firstname;
}
