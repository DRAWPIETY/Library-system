package com.hcq.book.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.hcq.book.control.IUserFunctional;

public class User implements IUserFunctional {
	private String userName;
	private String passWord;
	private Map<Book, Integer> books = new HashMap<>();

	@Override
	public boolean equals(String userName, String password) {
		return this.userName.equals(userName) && this.passWord.equals(password);
	}

	public User(String userName, String passWord) {
		super();
		this.userName = userName;
		this.passWord = passWord;
	}

	public User(String userName, String passWord, Map<Book, Integer> books) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.books = books;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Map<Book, Integer> getBooks() {
		return books;
	}

	public void setBooks(Map<Book, Integer> books) {
		this.books = books;
	}

	@Override
	public void showAllBooks() {
		Set<Entry<Book, Integer>> set = books.entrySet();
		System.out.println("　书名　\t作者\t　数量　");
		for (Entry<Book, Integer> entry : set) {
			System.out.println(entry.getKey().getName() + "\t" + entry.getKey().getAuthor() + "\t" + entry.getValue());
		}
	}

	@Override
	public boolean borrowBook(Map<Book, Integer> borrowBook) {
		if (borrowBook == null)
			return false;
		Set<Entry<Book, Integer>> set = borrowBook.entrySet();
		for (Entry<Book, Integer> entry : set) {
			Book book = entry.getKey();
			Integer addNum = entry.getValue();
			Integer oldNum = this.books.get(book);
			if (oldNum == null) {
				this.books.put(book, addNum);
			} else {
				this.books.put(book, 0 + oldNum + addNum);
			}

		}

		return true;
	}

	@Override
	public boolean hasExitsBook(String bookName, String author) {
		return books.containsKey(new Book(bookName, author));
	}

	@Override
	public Map<Book, Integer> returnBook(String bookName, String author, int num) {
		Book book = new Book(bookName, author);
		Integer bookNum = books.get(book);
		if (num > bookNum) {
			return null;

		}
		HashMap<Book, Integer> map = new HashMap<>();
		if (num == bookNum) {
			books.remove(book);
			map.put(book, bookNum);
		} else {
			books.put(book, bookNum - num);
			map.put(book, num);
		}

		return map;

	}

}
