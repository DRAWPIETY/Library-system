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
			System.out.println("***************��ӭ��¼XXXXͼ�����ϵͳ***************");
			switch (InputUtils.inputInt("��ѡ��1����¼�� 2��ע�ᡢ3���˳�")) {
			case 1:
				loginView();
				break;
			case 2:
				registerView();
				break;
			case 3:
				System.out.println("ллʹ��...");
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	// �û�ע��ҳ��
	private void registerView() {
		System.out.println("********XXXXע�����*********");
		while (true) {
			String userName = InputUtils.inputStr("�������û�����");
			if (!Validate.validateUsername(userName)) {
				System.out.println("�û�����ʽ����ȷ������������");
				continue;
			}
			boolean hasExistsUserName = userManager.hasExistsUserName(userName);
			if (hasExistsUserName) {
				System.out.println("�û������ڣ�����������");
				continue;
			}
			String passWord = InputUtils.inputStr("���������룺");
			if (!Validate.validatePassword(passWord)) {
				System.out.println("�����ʽ����ȷ������������");
				continue;
			}
			boolean register = userManager.register(userName, passWord);
			System.out.println(register ? "ע��ɹ�" : "ע��ʧ��");
			return;
		}
	}

	// �û���¼ҳ��
	private void loginView() {
		System.out.println("********XXXX��¼����*********");

		while (true) {
			String userName = InputUtils.inputStr("�������û�����");
			if (!Validate.validateUsername(userName)) {
				System.out.println("�û�����ʽ����ȷ������������");
				continue;
			}
			boolean hasExistsUserName = userManager.hasExistsUserName(userName);
			if (!hasExistsUserName) {
				System.out.println("�û��������ڣ�����������");
				continue;
			}
			String passWord = InputUtils.inputStr("���������룺");
			if (!Validate.validatePassword(passWord)) {
				System.out.println("�����ʽ����ȷ������������");
				continue;
			}
			User login = userManager.login(userName, passWord);
			if (login == null) {
				System.out.println("������󣬵�¼ʧ�ܣ�");
				return;
			}
			System.out.println("��¼�ɹ���");
			// ��¼�ɹ�������ͼ��ݵ�����
			mBookManagerView.in(login);

			break;
		}
	}
}
