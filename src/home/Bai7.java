package home;

import java.util.Scanner;

public class Bai7 {
    public void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        int resultNumber = (int) ((Math.random() * 100) + 1);
        System.out.println(resultNumber);
        int count = 0;
        while (true) {
            count++;
            System.out.println("Nhap so vao di ");
            int guessNumber = scanner.nextInt();
            if (guessNumber > resultNumber) {
                System.out.println("Nhap so nho hon ");

            }
            if (guessNumber < resultNumber) {
                System.out.println("Nhap so lon hon ");

            }
            if (guessNumber == resultNumber) {
                System.out.println("Qua da voi so lan thu " + count);
                return;
            }

        }
    }

    public static void main(String[] args) {
        Bai7 bai7 = new Bai7();
        bai7.guessNumber();
    }
}
