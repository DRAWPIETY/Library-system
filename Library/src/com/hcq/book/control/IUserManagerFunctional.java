package com.hcq.book.control;

import com.hcq.book.model.User;

public interface IUserManagerFunctional {
	// �����û����ж��û��Ƿ����
	boolean hasExistsUserName(String userName);

	// ��¼�����û�����
	User login(String userName, String password);

	// ע��
	boolean register(String userName, String passWord);

}
