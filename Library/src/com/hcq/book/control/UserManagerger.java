package com.hcq.book.control;

import java.util.ArrayList;
import java.util.List;

import com.hcq.book.model.User;

public class UserManagerger implements IUserManagerFunctional {
	// 用户书包
	private List<User> users = new ArrayList<>();
	// 初始化用户
	{
		users.add(new User("user123", "Abc123"));
		users.add(new User("user223", "Abc123"));

	}

	// 判断用户是否存在
	@Override
	public boolean hasExistsUserName(String userName) {
		if (userName == null)
			return false;
		for (User user : users) {
			if (user.getUserName().equals(userName))
				return true;
		}
		return false;
	}

	// 用户登录
	@Override
	public User login(String userName, String password) {
		if (userName == null || password == null)
			return null;
		for (User user : users) {
			boolean equals = user.equals(userName, password);
			if (equals) {
				return user;
			}
		}
		return null;
	}

	// 用户注册
	@Override
	public boolean register(String userName, String passWord) {
		if (userName == null || passWord == null || "".equals(userName) || "".equals(passWord))
			return false;
		users.add(new User(userName, passWord));
		return true;
	}

}
