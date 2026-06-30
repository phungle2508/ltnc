package home.bai20;

import java.util.Arrays;
import java.util.Comparator;

public class CDMange {
    CD[] cdArr;

    public CDMange(CD[] cdArr) {
        this.cdArr = cdArr;
    }

    public void addCD(CD cd) {
        // TODO
    }

    public int countCD() {
        int count = 0;
        for (CD cd : cdArr) {
            if (cd != null) {
                count++;
            }
        }
        return count;
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (CD cd : cdArr) {
            if (cd != null) {
                totalPrice += cd.getPrice();
            }
        }
        return totalPrice;
    }

    public String printCD() {
        return Arrays.toString(cdArr);
    }

    public void sortByPriceDesc() {
        Arrays.sort(cdArr, new Comparator<CD>() {

            @Override
            public int compare(CD o1, CD o2) {
                // TODO Auto-generated method stub
                return 0;
            }
        });
    }

    public void sortByPriceDesc1() {
        Arrays.sort(cdArr, (arg0, arg1) -> Double.compare(arg0.price, arg1.price));
    }

    public void sortByPriceDesc2() {
        for (int i = 0; i < cdArr.length - 1; i++) {
            for (int j = i + 1; j < cdArr.length; j++) {
                if (cdArr[i].price < cdArr[j].price) {
                    CD temp = cdArr[i];
                    cdArr[i] = cdArr[j];
                    cdArr[j] = temp;

                }
            }
        }
    }

    public void sortByNameAsc() {
        Arrays.sort(cdArr, new Comparator<CD>() {

            @Override
            public int compare(CD arg0, CD arg1) {
                return arg0.getName().compareTo(arg1.getName());
            }

        });

    }

    public void sortByNameAsc1() {
        Arrays.sort(cdArr, (arg0, arg1) -> arg0.getName().compareTo(arg1.getName()));

    }

    public void sortByNameAsc2() {
        for (int i = 0; i < cdArr.length - 1; i++) {
            for (int j = i + 1; j < cdArr.length; j++) {
                if (cdArr[i].name.compareToIgnoreCase(cdArr[j].name) > 0) {
                    CD temp = cdArr[i];
                    cdArr[i] = cdArr[j];
                    cdArr[j] = temp;
                }
            }
        }
    }
}
