package me.ardikapras.selfnumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List a = generateSelfNumber(1, 5000);
		Collections.sort(a);
		a.forEach(e -> {
			System.out.print(e + " ");
		});
		int total = a.stream().mapToInt(e -> (int) e).sum();
		System.out.println("\nSum of all integer::" + total);
	}

	public static List generateSelfNumber(int startNum, int maxNum) {
		List listOfNumbers = new ArrayList();
		List listOfCalc = new ArrayList();
		for (int i = 1; i <= maxNum; i++) {
			listOfNumbers.add(i);
			listOfCalc.add(calculateSelfNumber(i));
		}
		listOfNumbers.removeAll(listOfCalc);
		return listOfNumbers;
	}

	public static int calculateSelfNumber(int number) {
		int res = 0;
		if (number > 0) {
			int len = String.valueOf(number).length();
			res += number;
			for (int j = 1; j <= len; j++) {
				int x = Integer.parseInt(String.valueOf(number).substring(j - 1, j));
				res += x;
			}
		}
		return res;
	}
}
