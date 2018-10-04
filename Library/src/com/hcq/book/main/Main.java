package com.hcq.book.main;

import com.hcq.book.control.BookManager;
import com.hcq.book.control.UserManagerger;
import com.hcq.book.view.UserManagerView;

public class Main {
	// ³ÌÐòÈë¿Ú
	public static void main(String[] args) {
		UserManagerger userManagerger = new UserManagerger();
		BookManager bookManager = new BookManager();
		UserManagerView.start(userManagerger, bookManager);

	}

}
