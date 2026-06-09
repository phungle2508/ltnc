package lab.lab4;

public class Lab4 {
	private int column = 5;

	private String encode(String input) {
		int row = input.length() / column + (input.length() % column == 0 ? 0 : 1);
		int index = 0;
		String result = "";
		String[][] arr2d = new String[row][column];
		for (int i = 0; i < arr2d.length; i++) {
			for (int j = 0; j < arr2d[i].length; j++) {
				if (index >= input.length()) {
					arr2d[i][j] = "-";
				} else {
					char currentChar = input.charAt(index);
					arr2d[i][j] = currentChar != ' ' ? currentChar + "" : "-";
					index++;
				}
			}
		}
		for (int i = 0; i < arr2d[0].length; i++) {
			for (int j = 0; j < arr2d.length; j++) {
				result += arr2d[j][i];
			}
		}
		System.out.println("encode print");
		print2DMatrix(arr2d);
		return result;

	}

	private String decode(String input) {
		int row = input.length() / column + (input.length() % column == 0 ? 0 : 1);

		int index = 0;
		String result = "";
		String[][] arr2d = new String[row][column];
		for (int i = 0; i < arr2d[0].length; i++) {
			for (int j = 0; j < arr2d.length; j++) {
				if (index >= input.length()) {
					arr2d[j][i] = " ";
				} else {
					char currentChar = input.charAt(index);
					arr2d[j][i] = currentChar != '-' ? currentChar + "" : " ";
					index++;
				}
			}
		}
		for (int i = 0; i < arr2d.length; i++) {
			for (int j = 0; j < arr2d[0].length; j++) {
				result += arr2d[i][j];
			}
		}
		System.out.println("decode print");
		print2DMatrix(arr2d);
		return result;

	}

	private void print2DMatrix(String[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		String input = "I am a student";
		Lab4 lab4 = new Lab4();
		System.out.println(lab4.encode(input));
		System.out.println(lab4.decode(lab4.encode(input)));

	}
}
