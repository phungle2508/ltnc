package home;

public class Bai3 {
    // Bài Tập 3.(1) Xác định số chữ số của 1 số nguyên bắt kỳ

    public int countDigit(int num) {
        num = Math.abs(num);
        if (num == 0) {
            return 1;
        }
        int count = 0;
        while (num > 0) {
            count++;
            num = num / 10;
        }
        return count;
    }

    public static void main(String[] args) {
        Bai3 bai3 = new Bai3();
        System.out.println(bai3.countDigit(1));
        System.out.println(bai3.countDigit(2));
        System.out.println(bai3.countDigit(30));
        System.out.println(bai3.countDigit(1090));
    }
}
