package com.gnites.modules.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.gnites.modules.person.model.Person;
import com.sylvan41.model.BaseEntity;

@Entity
public class Blog extends BaseEntity {

	private static final long serialVersionUID = 233293643209812934L;
	
	@Id 
	@GeneratedValue(generator = "system-uuid")  
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	private String name;
	
	@ManyToOne
	private Person person;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	


}
