package es.tintomax.server.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the garment database table.
 *
 */
@Entity
@Table(name="test")
@NamedQuery(name="Test.findAll", query="SELECT t FROM Test t")
public class Test{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;

	protected Test(){}
	
	public Test(String name,String surname){
		this.name=name;
		this.surname=surname;
	}

}