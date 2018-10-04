package com.hcq.book.utils;

public class StringUtils {

	/**
	 * 将字符串的首字母转为大写
	 * 
	 * @param s
	 *            需要转换的字符串
	 * @return 返回被转换后的字符串
	 */
	public static String UpperFirstChar(String s) {
		if (s == null || "".equals(s) || s.length() <= 0) {
			return s;
		}
		char firstChar = s.charAt(0);
		if (firstChar >= 'a' && firstChar <= 'z') {
			char upperFirstChar = (char) (firstChar - ('a' - 'A'));
			StringBuilder sb = new StringBuilder(s);
			sb.replace(0, 1, upperFirstChar + "");
			String result = sb.toString();
			return result;
		}
		return s;
	}

	/**
	 * 将char 字符转为大写
	 * 
	 * @param c
	 * @return
	 */
	public static char UpperChar(char c) {
		if (c >= 'a' && c <= 'z') {
			return (char) (c - ('a' - 'A'));
		}
		return c;
	}

	public static char LowerChar(char c) {
		if (c >= 'A' && c <= 'Z') {
			return (char) (c - ('A' - 'a'));
		}
		return c;
	}

	public static String reverseString(String s) {
		return new StringBuilder().append(s).reverse().toString();

	}

}
