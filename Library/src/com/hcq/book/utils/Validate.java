package com.hcq.book.utils;

public class Validate {
	// 用户名：首字母小写，至少6位。密码：必须包含小写字母，大写字母，数字，至少6位）
	// 用户名验证
	public static boolean validateUsername(String username) {
		if ("".equals(username)) {
			return false;
		}

		boolean matches = username.matches("[a-z][a-zA-Z0-9]{5,}");
		return matches;
	}

	// 密码验证必须包括小写字符，大写字母，数字，密码在6-16位
	public static boolean validatePassword(String pass) {
		if ("".equals(pass)) {
			return false;
		}
		String regex = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z]).{6,16}";
		boolean matches = pass.matches(regex);
		return matches;
	}
}
