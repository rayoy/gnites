package com.gnites.modules.person.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnites.modules.person.model.Person;
import com.gnites.modules.person.service.IPersonService;
import com.sylvan41.service.ServiceImpl;

@Service
public class PersonService extends ServiceImpl<Person> implements
		IPersonService<Person> {

	@Override
	public Person loginUser(Person user) {

		Person p = null;
		List<Person> users = super.findByExample(user);

		if (users.size() > 0) {
			p = users.get(0);
		}
		return p;
	}

}
