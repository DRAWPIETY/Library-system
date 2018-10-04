package com.hcq.book.control;

import java.util.Map;

public interface IUserFunctional {
	void showAllBooks();// �û��������ͼ���б�

	boolean hasExitsBook(String bokName, String author);// ����ʱ�ж�������Ƿ��и�ͼ��

	Map<com.hcq.book.model.Book, Integer> returnBook(String bookName, String author, int num);// ����

	boolean equals(String userName, String password);

	// ����
	boolean borrowBook(Map<com.hcq.book.model.Book, Integer> borrowBook);

}
