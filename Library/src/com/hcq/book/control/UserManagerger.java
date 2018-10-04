package com.hcq.book.control;

import java.util.ArrayList;
import java.util.List;

import com.hcq.book.model.User;

public class UserManagerger implements IUserManagerFunctional {
	// �û����
	private List<User> users = new ArrayList<>();
	// ��ʼ���û�
	{
		users.add(new User("user123", "Abc123"));
		users.add(new User("user223", "Abc123"));

	}

	// �ж��û��Ƿ����
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

	// �û���¼
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

	// �û�ע��
	@Override
	public boolean register(String userName, String passWord) {
		if (userName == null || passWord == null || "".equals(userName) || "".equals(passWord))
			return false;
		users.add(new User(userName, passWord));
		return true;
	}

}
