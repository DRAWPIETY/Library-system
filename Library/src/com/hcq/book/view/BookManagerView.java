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

	// ��¼�ɹ�������
	public void in(IUserFunctional login) {
		while (true) {
			System.out.println("**********XXXXͼ���**********");
			switch (InputUtils.inputInt("��ѡ��1�����飻2�����飻3������ͼ��ݣ�4�������û������0���˳�", 5)) {
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
				System.out.println("�˳���¼��");
				return;
			}

		}
	}

	// �������
	private void returnBookView(IUserFunctional login) {
		System.out.println("**********XXXXͼ��ݻ������**********");
		while (true) {
			String bookName = InputUtils.inputStr("��������Ҫ�黹��ͼ�����ƣ�");
			String author = InputUtils.inputStr("��������Ҫ�黹��ͼ�����ߣ�");
			boolean hasExistsBooks = login.hasExitsBook(bookName, author);
			if (!hasExistsBooks) {
				System.out.println("��Ҫ�黹���鱾��" + bookName + "," + author + "�����û�У�");
				continue;
			}
			int num = InputUtils.inputInt("��������Ҫ�黹��ͼ��������");
			Map<Book, Integer> returnBook = login.returnBook(bookName, author, num);
			if (returnBook == null) {
				System.out.println("�黹ʧ�ܣ�����������");
			} else {
				boolean borrowBook = bookManager.returnBook(returnBook);
				System.out.println(borrowBook ? "�黹�ɹ���" : "�黹ʧ��!");
			}
			return;
		}
	}
	// �������

	private void borrowBookView(IUserFunctional login) {

		System.out.println("**********XXXXͼ��ݽ������**********");
		while (true) {
			String bookName = InputUtils.inputStr("��������Ҫ���ĵ�ͼ�����ƣ�");
			String author = InputUtils.inputStr("��������Ҫ���ĵ�ͼ�����ߣ�");
			boolean hasExistsBooks = bookManager.hasExistsBooks(bookName, author);
			if (!hasExistsBooks) {
				System.out.println("��Ҫ���ĵ��鱾��" + bookName + "," + author + "��ͼ���û�У�");
				continue;
			}
			int num = InputUtils.inputInt("��������Ҫ���ĵ�ͼ��������");
			Map<Book, Integer> map = bookManager.borrow(bookName, author, num);
			if (map == null) {
				System.out.println("ͼ����������");
			} else {
				boolean borrowBook = login.borrowBook(map);
				System.out.println(borrowBook ? "����ɹ���" : "����ʧ��!");
			}
			return;
		}
	}
}
