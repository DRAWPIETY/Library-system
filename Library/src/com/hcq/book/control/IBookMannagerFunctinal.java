package com.hcq.book.control;

import java.util.Map;

import com.hcq.book.model.Book;

public interface IBookMannagerFunctinal {
	void showAllBooks();// �鿴����ͼ��

	boolean hasExistsBooks(String bookName, String author);// ����ͼ�����ֲ����Ƿ���ڸ�ͼ��

	Map<Book, Integer> borrow(String bookName, String author, int num);// ����

	boolean returnBook(Map<Book, Integer> returnBook);// ����

}
