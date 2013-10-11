package com.gnites.modules.person.service;

import com.sylvan41.service.IService;

public interface IPersonService<T> extends IService<T>{

	/**
	 *  Login User
	 * 
	 * @param user
	 * @return
	 */
	public T loginUser(T user);

}
