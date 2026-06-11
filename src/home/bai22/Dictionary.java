package home.bai22;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private List<Word<String, String>> words;

    public Dictionary() {
        words = new ArrayList<>();
    }

    public void addWord(String vietName, String englist) {
        words.add(new Word<String, String>(vietName, englist));
    }

    // tra cứu
    public String search(String english) {
        for (Word<String, String> w : words) {
            if (w.getKey().equalsIgnoreCase(english)) {
                return w.getValue();
            }
        }
        return "Khong tim thay";
    }

    // liệt kê
    public void printAllWords() {
        for (Word<String, String> w : words) {
            System.out.println(w);
        }
    }
}