package com.hcq.book.control;

import java.util.Map;

import com.hcq.book.model.Book;

public interface IBookMannagerFunctinal {
	void showAllBooks();// 查看所有图书

	boolean hasExistsBooks(String bookName, String author);// 根据图书名字查找是否存在该图书

	Map<Book, Integer> borrow(String bookName, String author, int num);// 借书

	boolean returnBook(Map<Book, Integer> returnBook);// 还书

}
