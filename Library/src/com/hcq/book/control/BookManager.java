package com.hcq.book.control;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.hcq.book.model.Book;

public class BookManager implements IBookMannagerFunctinal {
	// ͼ������
	private Map<Book, Integer> books = new HashMap<>();
	// ��ʼ��ͼ��
	{
		books.put(new Book("��¥��", "��ѩ��"), 4);
		books.put(new Book("��������", "�޹���"), 8);
		books.put(new Book("���μ�", "��ж�"), 5);
		books.put(new Book("ˮ䰴�", "ʩ����"), 3);

	}

	// ��ʾͼ������е�ͼ��
	@Override
	public void showAllBooks() {
		Set<Entry<Book, Integer>> set = books.entrySet();
		System.out.println("��������\t ���� \t��������");
		for (Entry<Book, Integer> entry : set) {
			System.out.println(entry.getKey().getName() + "\t" + entry.getKey().getAuthor() + "\t" + entry.getValue());
		}
	}

	// �ж�ͼ���Ƿ����
	@Override
	public boolean hasExistsBooks(String bookName, String author) {

		return books.containsKey(new Book(bookName, author));
	}

	// ��ͼ��
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

	// ��ͼ��
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
