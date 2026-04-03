package lab3;

import java.util.Arrays;

public class Lab3 {
	private void pascalWith1DMatrix(int size) {
		int[] arr = new int[size];
		arr[0] = 1;
		System.out.println(Arrays.toString(arr));
		for (int i = 1; i < size - 1; i++) {
			for (int j = i; j > 0; j--) {
				arr[j] = arr[j] + arr[j - 1];
			}
			System.out.println(Arrays.toString(arr) + " " + i);
		}

	}

	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private void pascalWithoutMatrix(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					System.out.print(1);
				} else {
					int result = factorial(i) / (factorial(j) * factorial(i - j));
					System.out.print(result);
				}
			}
			System.out.println();
		}

	}

	private int[][] pascal(int size) {
		int[][] arr2d = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) {
					arr2d[i][j]  = 1;
				} else {
					arr2d[i][j] = factorial(i) / (factorial(j) * factorial(i - j));
				}
			}
		}
		return arr2d;

	}

	private void print2DMatrix(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
	    Lab3 lab3 = new Lab3();

	    System.out.println("Printing Pascal's Triangle with a 1D array:");
	    lab3.pascalWith1DMatrix(6);

	    System.out.println("\nPrinting Pascal's Triangle without using a 2D array:");
	    lab3.pascalWithoutMatrix(6);

	    System.out.println("\nPrinting Pascal's Triangle with a 2D array:");
	    int[][] matrix = lab3.pascal(6);
	    lab3.print2DMatrix(matrix);
	}
}
