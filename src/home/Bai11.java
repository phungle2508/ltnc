package home;

import java.util.Arrays;

public class Bai11 {
    // Bài Tập 11.(4)Cho 1 mảng số nguyên bất kỳ arr và 1 số nguyên bất kỳ qty (qty
    // < kích thước mảng arr) viết phương thức trả về mảng số nguyên có qty phần tử
    // lấy ngẫu nhiên từ mảng arr
    public int[] subArray(int[] arr, int qty) {
        int[] result = new int[qty];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[(int) ((Math.random() * (arr.length - 1)) + 1)];
        }
        return result;
    }

    public static void main(String[] args) {
        Bai11 bai11 = new Bai11();
        int[] arr = new int[] { 1, 2, 2, 4, 5, 6 };
        System.out.println(Arrays.toString(bai11.subArray(arr, 5)));

    }
}
