package com.ghlegacy.codesample;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class trySomeCode {

	public static void main(String[] args) {

//		convertToHex();
//
//		removeNegativeItemFromList();
//
//		arrangeWordsAlphabeticOrder();
//
//		stdInputInJava();

		Boolean[][] aB = new Boolean[29][29];

		aB[0][0] = true;
		aB[1][0] = false;
		aB[2][0] = true;

		int a = aB.length;
		int b = aB[25].length;

		System.out.println(a);
		System.out.println(b);

	}

	/**
	 * 
	 */
	private static void stdInputInJava() {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine() && !((scan.nextLine()).equals("exit"))) {

			String s = scan.next();
			int i = scan.nextInt();
		}

		scan.close();
	}

	/**
	 * 
	 */
	private static void convertToHex() {
		System.out.println("This is a test");
		int x = ~0x7fffffff | 0x2;
		System.out.println(Integer.toHexString(x));
	}

	/**
	 * 
	 */
	private static void removeNegativeItemFromList() {
		List<Integer> aList = new ArrayList<Integer>();

		aList.add(5);
		aList.add(6);
		aList.add(-3);

		Iterator<Integer> it = aList.iterator();

		while (it.hasNext()) {
			Integer z = (Integer) it.next();
			if (z < 0) {
				it.remove();
			}

		}

		System.out.println(aList);

	}

	/**
	 * Arrange words in dictionary order or alphabetic order
	 */
	private static void arrangeWordsAlphabeticOrder() {
		String names[] = new String[4];

		names[0] = "Rauli";
		names[1] = "Olok";
		names[2] = "Aro";
		names[3] = "Zolo123";

		int n = names.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (names[i].compareTo(names[j]) > 0) {
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}

		for (int k = 0; k < n; k++) {
			System.out.println(names[k]);
		}
	}

}
