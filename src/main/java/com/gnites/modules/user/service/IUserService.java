package com.gnites.modules.user.service;

import com.sylvan41.service.IService;

public interface IUserService<T> extends IService<T>{

	/**
	 *  Login User
	 * 
	 * @param user
	 * @return
	 */
	public T loginUser(T user);
	
	public T login(T user);

}
