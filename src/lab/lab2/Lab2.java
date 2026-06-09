package lab.lab2;

import java.util.Arrays;

public class Lab2 {
	private void checkNullArr(int[] a) {
		if (a == null || a.length == 0) {
			throw new IllegalArgumentException("Null arr");
		}
	}

	private int maxValue(int[] a) {
		int max = a[0];
		for (int e : a) {
			if (e > max) {
				max = e;
			}
		}
		return max;
	}

	private int minValue(int[] a) {
		int min = a[0];
		for (int e : a) {
			if (e < min) {
				min = e;
			}
		}
		return min;
	}

	private int indexOfMaxValue(int[] a) {
		int indexMax = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > a[indexMax]) {
				indexMax = i;
			}

		}
		return indexMax;
	}

	private int sumMaxValue(int[] a) {
		int max = maxValue(a);
		int totalMax = 0;
		for (int e : a) {
			if (e == max) {
				totalMax += max;
			}
		}
		return totalMax;

	}

	private int[] sumMaxValue(int[] a, int[] b) {
		boolean flag = a.length >= b.length;
		int[] result;
		if (flag) {
			result = a;
			for (int i = 0; i < b.length; i++) {
				result[i] += b[i];
			}
		} else {
			result = b;
			for (int i = 0; i < a.length; i++) {
				result[i] += a[i];
			}
		}
		return result;

	}

	public static void main(String[] args) {
		Lab2 lab = new Lab2();
	
		int[] arr1 = { 3, 7, 2, 7, 5 };
		int[] arr2 = { 1, 2, 3 };
		lab.checkNullArr(arr1);
		lab.checkNullArr(arr2);
		System.out.println("Array 1: " + Arrays.toString(arr1));

		System.out.println("Max value: " + lab.maxValue(arr1));
		System.out.println("Min value: " + lab.minValue(arr1));
		System.out.println("Index of max: " + lab.indexOfMaxValue(arr1));
		System.out.println("Sum of max values: " + lab.sumMaxValue(arr1));

		System.out.println();
		System.out.println("Array 2: " + Arrays.toString(arr2));
		int[] result = lab.sumMaxValue(arr1, arr2);
		System.out.println("Sum of two arrays: " + Arrays.toString(result));
	}
}