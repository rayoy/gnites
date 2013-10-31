package com.sylvan41.snippets;

public class Code1 {

	/**
	 * 生成数字
	 */
	public Integer[] generateNums() {

		Integer[] aa = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
				13, 14, 15 };
		// 选择次数
		Integer pickCount = (int) Math.round(Math.random() * 15 + 1);
		Integer[] words = new Integer[pickCount];
		for (int i = 0; i < pickCount; i++) {
			// 下标
			Integer pickMark = (int) Math.round(Math.random() * 14);
			words[i] = aa[pickMark];
		}
		System.out.print("共个" + pickCount + "数字,分别是:");
		this.printIntegers(words);
		return words;
	}

	/**
	 * 打印Integer[]
	 * 
	 * @param words
	 */
	public void printIntegers(Integer[] words) {
		for (int j = 0; j < words.length; j++) {
			System.out.print(words[j] + ",");
		}
	}

	public Boolean isSorted(Integer[] words) {
		Boolean flag = true;
		for (int i = 0; i < words.length - 1; i++) {
			if (words[i + 1] < words[i]) {
				flag = false;
				break;
			}
		}
		System.out.println("是否为单增数列:" + flag);
		return flag;
	}
}
