package com.hcq.book.utils;

import java.util.Scanner;

public class InputUtils {

	private static Scanner sc;

	static {
		sc = new Scanner(System.in);
	}

	/**
	 * 从控制台输入int值，并对输入的类型进行类型检测，并限制只能输入[startBound,endBound]的值
	 * 
	 * 
	 * startBound 和 endBound 必须大于0，并且 endBound>startBound，否则不对输入的内容做限制
	 * 
	 * @param tip
	 *            提示输入文本
	 * @param startBound
	 *            输入的范围，从startBound开始，包含startBound
	 * @param endBound
	 *            输入的范围，到endBound结束，包含endBound
	 * @return 返回输入成功的int值
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
	 * 从控制台输入int值，并对输入的类型进行类型检测，并限制只能输入[0,bounds)的值 。 bounds 必须大于0，否则不对输入的int做限制
	 * 
	 * @param tip
	 *            提示输入文本
	 * @param bounds
	 *            输入的范围，从0开始，不包含 bounds
	 * @return 返回输入成功的int值
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
	 * 从控制台输入int值，并对输入的类型进行类型检测
	 * 
	 * @param tip
	 *            提示输入文本
	 *
	 * @return 返回输入成功的int值
	 */
	public static int inputInt(String tip) {
		return inputInt(tip, null);
	}

	/**
	 * 从控制台输入int值，并对输入的类型进行类型检测，且限制只能输入 nums数组中的数值
	 * 
	 * 如果 nums为null，或者 nums的长度为0，则不对输入的int做限制
	 * 
	 * @param tip
	 *            提示输入文本
	 * @param nums
	 *            限制只能输入 nums中的数值
	 * @return 返回输入成功的int值
	 */
	public static int inputInt(String tip, int... nums) {
		while (true) {
			System.out.println(tip);
			boolean hasNextInt = sc.hasNextInt();
			if (!hasNextInt) {
				sc.next();
				sc.nextLine();
				System.out.println("输入的不是int类型，请重新输入！");
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
			System.out.println("没有这个选项，请重新输入！");
		}

	}

	public static String inputStr(String tip) {
		System.out.println(tip);
		return sc.next();
	}

}
