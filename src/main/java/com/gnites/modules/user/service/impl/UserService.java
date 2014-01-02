package com.gnites.modules.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gnites.modules.user.model.User;
import com.gnites.modules.user.service.IUserService;
import com.sylvan41.service.ServiceImpl;

@Service
public class UserService extends ServiceImpl<User> implements
		IUserService<User> {

	@Override
	public User loginUser(User user) {

		User p = null;
		List<User> users = super.findByExample(user);

		if (users.size() > 0) {
			p = users.get(0);
		}
		return p;
	}

	@Override
	public User login(User user) {
		User p = null;
		List<User> users = super.findByExample(user);

		if (users.size() > 0) {
			p = users.get(0);
		}
		return p;
	}

}
