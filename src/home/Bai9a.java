package home;

public class Bai9a {
    public String formatNum(int num) {
        if (num < 1000) {
            return String.valueOf(num);
        }

        String result = "";

        while (num >= 1000) {
            result = String.format(",%03d%s", num % 1000, result);
            num /= 1000;
        }

        return num + result;
    }

    public static void main(String[] args) {
        Bai9a bai9 = new Bai9a();
        System.err.println(bai9.formatNum(1005));

    }
}
