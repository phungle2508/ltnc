package home;

import java.util.Arrays;

public class Bai4 {
    // Bài Tập 4. (2)Viết phương thức cộng 2 mạng số nguyên bất kỳ có độ dài bất kỳ
    public int[] arrayPlus(int[] arr1, int[] arr2) {
        int lengthOfMin = arr1.length >= arr2.length ? arr2.length : arr1.length;
        int[] result = arr1.length >= arr2.length ? arr1 : arr2;
        for (int i = 0; i < lengthOfMin; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        return result;

    }

    public static void main(String[] args) {
        Bai4 bai4 = new Bai4();
        int[] arr1 = new int[] { 1, 2, 3, 4, 5, 7, 8 };
        int[] arr2 = new int[] { 1, 2, 3, 4, 5, 7, 8 , 10 , 20 };
        System.out.println(Arrays.toString(bai4.arrayPlus(arr1, arr2)));

    }
}
