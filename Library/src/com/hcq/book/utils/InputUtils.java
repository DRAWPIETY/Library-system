package com.hcq.book.utils;

import java.util.Scanner;

public class InputUtils {

	private static Scanner sc;

	static {
		sc = new Scanner(System.in);
	}

	/**
	 * �ӿ���̨����intֵ��������������ͽ������ͼ�⣬������ֻ������[startBound,endBound]��ֵ
	 * 
	 * 
	 * startBound �� endBound �������0������ endBound>startBound�����򲻶����������������
	 * 
	 * @param tip
	 *            ��ʾ�����ı�
	 * @param startBound
	 *            ����ķ�Χ����startBound��ʼ������startBound
	 * @param endBound
	 *            ����ķ�Χ����endBound����������endBound
	 * @return ��������ɹ���intֵ
	 */
	public static int inputInt(String tip, int startBound, int endBound) {
		if (startBound < 0 || endBound < 0 || startBound >= endBound) {
			return inputInt(tip);
		}
		int nums[] = new int[endBound - startBound + 1];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = startBound++;
		}
		return inputInt(tip, nums);
	}

	/**
	 * �ӿ���̨����intֵ��������������ͽ������ͼ�⣬������ֻ������[0,bounds)��ֵ �� bounds �������0�����򲻶������int������
	 * 
	 * @param tip
	 *            ��ʾ�����ı�
	 * @param bounds
	 *            ����ķ�Χ����0��ʼ�������� bounds
	 * @return ��������ɹ���intֵ
	 */
	public static int inputInt(String tip, int bounds) {
		if (bounds <= 0)
			return inputInt(tip);
		int nums[] = new int[bounds];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
		return inputInt(tip, nums);
	}

	/**
	 * �ӿ���̨����intֵ��������������ͽ������ͼ��
	 * 
	 * @param tip
	 *            ��ʾ�����ı�
	 *
	 * @return ��������ɹ���intֵ
	 */
	public static int inputInt(String tip) {
		return inputInt(tip, null);
	}

	/**
	 * �ӿ���̨����intֵ��������������ͽ������ͼ�⣬������ֻ������ nums�����е���ֵ
	 * 
	 * ��� numsΪnull������ nums�ĳ���Ϊ0���򲻶������int������
	 * 
	 * @param tip
	 *            ��ʾ�����ı�
	 * @param nums
	 *            ����ֻ������ nums�е���ֵ
	 * @return ��������ɹ���intֵ
	 */
	public static int inputInt(String tip, int... nums) {
		while (true) {
			System.out.println(tip);
			boolean hasNextInt = sc.hasNextInt();
			if (!hasNextInt) {
				sc.next();
				sc.nextLine();
				System.out.println("����Ĳ���int���ͣ����������룡");
				continue;
			}
			int nextInt = sc.nextInt();
			if (nums == null || nums.length == 0) {
				return nextInt;
			}
			for (int i : nums) {
				if (i == nextInt) {
					return i;
				}
			}
			System.out.println("û�����ѡ����������룡");
		}

	}

	public static String inputStr(String tip) {
		System.out.println(tip);
		return sc.next();
	}

}
