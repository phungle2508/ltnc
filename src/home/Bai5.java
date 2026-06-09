package home;

import java.util.Arrays;

public class Bai5 {
    // Bài Tập 5. (2) Viết chương trình nhận vào 2 con số a và b, chương trình sẽ in
    // ra b số nguyên tố đầu tiên lớn hơn a.Ví dụ người dùng nhập vào 15 và 5 thì sẽ
    // in ra 5 con số nguyên tố đầu tiên tìm thấy lớn 15 là:17,19,23,29,31

    public boolean checkIfPrime(int number) {
        if (number == 1) {
            return false;
        }
        int count = 2;
        while (number != count) {
            if (number % count++ == 0)
                return false;
        }
        return true;
    }

    public int[] fromAfindBPrime(int a, int b) {
        int[] result = new int[b];
        int count = 0;
        while (count < b) {
            if (checkIfPrime(a)) {
                result[count] = a;
                count++;
            }
            a++;
        }
        return result;
    }

    public static void main(String[] args) {
        Bai5 bai5 = new Bai5();
        System.out.println(Arrays.toString(bai5.fromAfindBPrime(20, 6)));
    }
}
