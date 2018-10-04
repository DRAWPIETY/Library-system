package com.hcq.book.view;

import com.hcq.book.control.IBookMannagerFunctinal;
import com.hcq.book.control.IUserManagerFunctional;
import com.hcq.book.model.User;
import com.hcq.book.utils.InputUtils;
import com.hcq.book.utils.Validate;

public class UserManagerView {
	private IUserManagerFunctional userManager;

	private BookManagerView mBookManagerView;

	public UserManagerView(IUserManagerFunctional manager, IBookMannagerFunctinal bookManager) {
		super();
		this.userManager = manager;
		mBookManagerView = new BookManagerView(bookManager);
	}

	public static void start(IUserManagerFunctional manager, IBookMannagerFunctinal bookManager) {
		new UserManagerView(manager, bookManager).view();
	}

	public void view() {
		while (true) {
			System.out.println("***************欢迎登录XXXX图书管理系统***************");
			switch (InputUtils.inputInt("请选择：1、登录； 2、注册、3、退出")) {
			case 1:
				loginView();
				break;
			case 2:
				registerView();
				break;
			case 3:
				System.out.println("谢谢使用...");
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	// 用户注册页面
	private void registerView() {
		System.out.println("********XXXX注册界面*********");
		while (true) {
			String userName = InputUtils.inputStr("请输入用户名：");
			if (!Validate.validateUsername(userName)) {
				System.out.println("用户名格式不正确，请重新输入");
				continue;
			}
			boolean hasExistsUserName = userManager.hasExistsUserName(userName);
			if (hasExistsUserName) {
				System.out.println("用户名存在，请重新输入");
				continue;
			}
			String passWord = InputUtils.inputStr("请输入密码：");
			if (!Validate.validatePassword(passWord)) {
				System.out.println("密码格式不正确，请重新输入");
				continue;
			}
			boolean register = userManager.register(userName, passWord);
			System.out.println(register ? "注册成功" : "注册失败");
			return;
		}
	}

	// 用户登录页面
	private void loginView() {
		System.out.println("********XXXX登录界面*********");

		while (true) {
			String userName = InputUtils.inputStr("请输入用户名：");
			if (!Validate.validateUsername(userName)) {
				System.out.println("用户名格式不正确，请重新输入");
				continue;
			}
			boolean hasExistsUserName = userManager.hasExistsUserName(userName);
			if (!hasExistsUserName) {
				System.out.println("用户名不存在，请重新输入");
				continue;
			}
			String passWord = InputUtils.inputStr("请输入密码：");
			if (!Validate.validatePassword(passWord)) {
				System.out.println("密码格式不正确，请重新输入");
				continue;
			}
			User login = userManager.login(userName, passWord);
			if (login == null) {
				System.out.println("密码错误，登录失败！");
				return;
			}
			System.out.println("登录成功！");
			// 登录成功，进入图书馆的流程
			mBookManagerView.in(login);

			break;
		}
	}
}
