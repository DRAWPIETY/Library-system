package com.hcq.book.utils;

public class Validate {
	// �û���������ĸСд������6λ�����룺�������Сд��ĸ����д��ĸ�����֣�����6λ��
	// �û�����֤
	public static boolean validateUsername(String username) {
		if ("".equals(username)) {
			return false;
		}

		boolean matches = username.matches("[a-z][a-zA-Z0-9]{5,}");
		return matches;
	}

	// ������֤�������Сд�ַ�����д��ĸ�����֣�������6-16λ
	public static boolean validatePassword(String pass) {
		if ("".equals(pass)) {
			return false;
		}
		String regex = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,16}";
		boolean matches = pass.matches(regex);
		return matches;
	}
}
