package home;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai10 {
    public void sortArrDesc(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) <= list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list);

    }

    public void sortArrAsc(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) >= list.get(j)) {
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println(list);

    }

    public static void main(String[] args) {
        Bai10 bai9 = new Bai10();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        bai9.sortArrAsc(list);

    }
}
