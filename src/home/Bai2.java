package home;

public class Bai2 {
    // Bài Tập 2.(1) Viết CT nhận 1 số nguyên bất kỳ và cho biết
    // ● Số đó là chẵn hay lẻ
    // ● Số có phải là số nguyên tố hay không

    public boolean checkIfEvenOrOddNumber(int number) {
        if (number % 2 == 0)
            return true;
        else
            return false;
    }

    public boolean checkIfTheNumberIsPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int count = 2;
        while (number != count) {
            if (number % count++ == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Bai2 bai2 = new Bai2();
        System.out.println(bai2.checkIfTheNumberIsPrime(2));
    }
}
