package com.hcq.book.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hcq.book.model.Book;

public class BookManager implements IBookMannagerFunctinal {
	// 图书馆书库
	private Map<Book, Integer> books = new HashMap<>();
	// 初始化图书
	{
		books.put(new Book("红楼梦", "曹雪芹"), 4);
		books.put(new Book("三国演义", "罗贯中"), 8);
		books.put(new Book("西游记", "吴承恩"), 5);
		books.put(new Book("水浒传", "施耐庵"), 3);

	}

	// 显示图书馆所有的图书
	@Override
	public void showAllBooks() {
		Set<Entry<Book, Integer>> set = books.entrySet();
		System.out.println("　书名　\t 作者 \t　数量　");
		for (Entry<Book, Integer> entry : set) {
			System.out.println(entry.getKey().getName() + "\t" + entry.getKey().getAuthor() + "\t" + entry.getValue());
		}
	}

	// 判断图书是否存在
	@Override
	public boolean hasExistsBooks(String bookName, String author) {

		return books.containsKey(new Book(bookName, author));
	}

	// 借图书
	@Override
	public Map<Book, Integer> borrow(String bookName, String author, int num) {
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

	// 还图书
	@Override
	public boolean returnBook(Map<Book, Integer> returnBook) {
		if (returnBook == null)
			return false;
		Set<Entry<Book, Integer>> set = returnBook.entrySet();
		for (Entry<Book, Integer> entry : set) {
			Book book = entry.getKey();
			Integer addNum = entry.getValue();
			Integer oldNum = books.get(book);
			if (oldNum == null) {
				books.put(book, addNum);
			} else {
				books.put(book, 0 + oldNum + addNum);
			}

		}
		return true;
	}

}
