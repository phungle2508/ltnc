package homeT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bai1 {
    public static int roundNumber(float number) {
        return (int) (number + 0.5);

    }

    public static boolean coLaSoChan(int number) {
        return number % 2 == 0;

    }

    public static boolean coLaSoNguyenTo(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static int countDigit(int num) {

        int count = 1;
        while (num >= 10) {
            num = num / 10;
            count++;
        }
        return count;

    }

    public static int[] arrayPlus(int[] arr1, int[] arr2) {
        int longestArr = arr1.length > arr2.length ? arr1.length : arr2.length;

        int[] result = new int[longestArr];
        for (int i = 0; i < result.length; i++) {
            if (i >= arr1.length) {
                result[i] = arr2[i];
            } else if (i >= arr2.length) {
                result[i] = arr1[i];
            } else {
                result[i] = arr1[i] + arr2[i];
            }
        }
        return result;

    }

    public static List<Integer> listBNumberBiggerNumberA(int a, int b) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < b; i++) {
            while (!coLaSoNguyenTo(a)) {
                a++;
            }
            list.add(a);
            a++;
        }
        return list;
    }

    public static void numberGuess() {

        Scanner scanner = new Scanner(System.in);
        int result = (int) ((Math.random() * 100) + 1);
        while (true) {
            int guessNumber = scanner.nextInt();
            System.out.println(result + " " + guessNumber);
            if (result == guessNumber) {
                break;
            }
        }
        scanner.close();
    }

    public static void sortArrDesc(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list.toString());
    }

    public static String dateFormat(String date) {
        String[] months = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };
        String[] splited = date.split("/");
        if (splited.length < 3) {
            return null;
        }
        return splited[0] + " " + months[Integer.parseInt(splited[1]) - 1] + " " + splited[2];
    }

    public static String dateFormat1(String date) {
        String[] months = {
                "January", "February", "March", "April",
                "May", "June", "July", "August",
                "September", "October", "November", "December"
        };
        StringTokenizer stringTokenizer = new StringTokenizer(date, "/");
        if (stringTokenizer.countTokens() < 3) {
            return null;
        }
        return stringTokenizer.nextToken() + " " + months[Integer.parseInt(
                stringTokenizer.nextToken()) - 1] + " " + stringTokenizer.nextToken();
    }

    public static void main(String[] args) {
        // System.out.println(roundNumber(5.6f));
        // System.out.println(coLaSoChan(6));
        // System.out.println(coLaSoNguyenTo(6));
        // System.out.println(countDigit(2131255123));
        int[] arr1 = new int[] { 1, 2, 2, 3, 45, 6 };
        int[] arr2 = new int[] { 1, 32, 2, 3, 45, 6, 5 };

        // System.out.println(Arrays.toString(arrayPlus(arr1, arr2)));
        System.out.println(listBNumberBiggerNumberA(15, 5).toString());
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 3, 4, 2));
        System.out.println(dateFormat1("21/12/2000"));

    }
}
