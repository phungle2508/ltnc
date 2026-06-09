package home;

import java.util.Arrays;

public class Bai14 {
    int column = 5;

    public String encode(String input) {
        int row = input.length() / column + 1;
        char[][] arr = new char[row][column];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (count >= input.length()) {
                    arr[i][j] = '-';
                } else {
                    if (input.charAt(count) != ' ') {
                        arr[i][j] = input.charAt(count);
                    } else {
                        arr[i][j] = '-';
                    }
                    count++;
                }
            }
        }
        String result = "";
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                result += arr[i][j];
            }
        }
        return result;
    }

    public String decode(String input) {
        int row = input.length() / column;
        char[][] arr = new char[row][column];
        int count = 0;
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (count >= input.length()) {

                } else {
                    if (input.charAt(count) != '-') {
                        arr[i][j] = input.charAt(count);
                    } else {
                        arr[i][j] = ' ';
                    }
                    count++;
                }
            }
        }

        String result = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                result += arr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Bai14 bai14 = new Bai14();
        System.out.println(bai14.encode("I am student"));
        System.out.println(bai14.decode("Isn-ttau-md--e-"));
    }
}
