package com.hcq.book.control;

import com.hcq.book.model.User;

public interface IUserManagerFunctional {
	// 输入用户名判断用户是否存在
	boolean hasExistsUserName(String userName);

	// 登录返回用户对象
	User login(String userName, String password);

	// 注册
	boolean register(String userName, String passWord);

}
