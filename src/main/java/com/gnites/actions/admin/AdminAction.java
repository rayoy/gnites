package com.gnites.actions.admin;

import com.gnites.modules.blog.model.Blog;
import com.gnites.modules.person.model.Person;
import com.sylvan41.action.BaseAction;

public class AdminAction extends BaseAction {

	private static final long serialVersionUID = -1018295962953545586L;

	/**
	 * 获得session中的user
	 * 
	 * @return session中的user
	 */
	protected Person getS_user() {
		return (Person) session.get("s_user");
	}
	
	/**
	 * 获得session中的blog
	 * 
	 * @return session中的blog
	 */
	protected Blog getS_blog() {
		return (Blog) session.get("s_blog");
	}

}
