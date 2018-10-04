package com.hcq.book.control;

import java.util.Map;

public interface IUserFunctional {
	void showAllBooks();// 用户个人书包图书列表

	boolean hasExitsBook(String bokName, String author);// 还书时判断书包里是否有该图书

	Map<com.hcq.book.model.Book, Integer> returnBook(String bookName, String author, int num);// 还书

	boolean equals(String userName, String password);

	// 借书
	boolean borrowBook(Map<com.hcq.book.model.Book, Integer> borrowBook);

}
