package home;

import java.util.StringTokenizer;

public class Bai12 {
    String[] months = {
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"
    };

    // (4) Viết chương trình nhận vào ngày tháng theo định dạng“21/12/2000”, sau đó
    // in ra theo định dạng 21 December 2000
    public String formatDate(String date) {

        String[] splitedArr = date.split("/");
        if (splitedArr.length != 3) {
            return "sai";
        }
        String month = months[Integer.parseInt(splitedArr[1]) - 1];
        return splitedArr[0] + " " + month + " " + splitedArr[2];

    }

    public String formatDate1(String date) {

        StringTokenizer st = new StringTokenizer(date, "/");
        if (st.countTokens() != 3) {
            return "sai";
        }

        String day = st.nextToken();
        String month = months[Integer.parseInt(st.nextToken()) - 1];
        String year = st.nextToken();
        return day + " " + month + " " + year;

    }

    public static void main(String[] args) {
        Bai12 bai12 = new Bai12();
        System.out.println(bai12.formatDate1("21/12/2000"));
    }
}
