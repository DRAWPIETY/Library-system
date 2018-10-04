package com.hcq.book.view;

import java.util.Map;

import com.hcq.book.control.IBookMannagerFunctinal;
import com.hcq.book.control.IUserFunctional;
import com.hcq.book.model.Book;
import com.hcq.book.utils.InputUtils;

public class BookManagerView {
	private IBookMannagerFunctinal bookManager;

	public BookManagerView(IBookMannagerFunctinal bookManager) {
		super();
		this.bookManager = bookManager;
	}

	// 登录成功主界面
	public void in(IUserFunctional login) {
		while (true) {
			System.out.println("**********XXXX图书馆**********");
			switch (InputUtils.inputInt("请选择：1、借书；2、还书；3、查阅图书馆；4、查阅用户书包；0；退出", 5)) {
			case 1:
				borrowBookView(login);
				break;
			case 2:
				returnBookView(login);
				break;
			case 3:
				bookManager.showAllBooks();
				break;
			case 4:
				login.showAllBooks();
				break;

			default:
				System.out.println("退出登录！");
				return;
			}

		}
	}

	// 还书界面
	private void returnBookView(IUserFunctional login) {
		System.out.println("**********XXXX图书馆还书界面**********");
		while (true) {
			String bookName = InputUtils.inputStr("请输入你要归还的图书名称：");
			String author = InputUtils.inputStr("请输入你要归还的图书作者：");
			boolean hasExistsBooks = login.hasExitsBook(bookName, author);
			if (!hasExistsBooks) {
				System.out.println("您要归还的书本《" + bookName + "," + author + "》书包没有！");
				continue;
			}
			int num = InputUtils.inputInt("请输入你要归还的图书数量：");
			Map<Book, Integer> returnBook = login.returnBook(bookName, author, num);
			if (returnBook == null) {
				System.out.println("归还失败，数量不够！");
			} else {
				boolean borrowBook = bookManager.returnBook(returnBook);
				System.out.println(borrowBook ? "归还成功！" : "归还失败!");
			}
			return;
		}
	}
	// 借书界面

	private void borrowBookView(IUserFunctional login) {

		System.out.println("**********XXXX图书馆借书界面**********");
		while (true) {
			String bookName = InputUtils.inputStr("请输入你要借阅的图书名称：");
			String author = InputUtils.inputStr("请输入你要借阅的图书作者：");
			boolean hasExistsBooks = bookManager.hasExistsBooks(bookName, author);
			if (!hasExistsBooks) {
				System.out.println("您要借阅的书本《" + bookName + "," + author + "》图书馆没有！");
				continue;
			}
			int num = InputUtils.inputInt("请输入你要借阅的图书数量：");
			Map<Book, Integer> map = bookManager.borrow(bookName, author, num);
			if (map == null) {
				System.out.println("图书数量不够");
			} else {
				boolean borrowBook = login.borrowBook(map);
				System.out.println(borrowBook ? "借书成功！" : "借书失败!");
			}
			return;
		}
	}
}
