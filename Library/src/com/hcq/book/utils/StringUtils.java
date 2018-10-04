package com.hcq.book.utils;

public class StringUtils {

	/**
	 * ���ַ���������ĸתΪ��д
	 * 
	 * @param s
	 *            ��Ҫת�����ַ���
	 * @return ���ر�ת������ַ���
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
	 * ��char �ַ�תΪ��д
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
