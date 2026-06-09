package home;

import java.util.Scanner;

public class Bai1 {
    // Bài Tập 1.(1)
    // Viết chương trình nhận vào số thực từ bàn phím và làm tròn một số thực x
    // thành số nguyên (Nếu phần lẻ <5 thì làm tròn xuống, ngược lại làm tròn lên.
    // VD: 3.4→ 3;
    // 3.6→4)

    public int roundNumber(float number) {
        return (int) (number + 0.5);

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bai1 bai1 = new Bai1();
        System.out.println(bai1.roundNumber(scanner.nextFloat()));
        scanner.close();
    }
}
