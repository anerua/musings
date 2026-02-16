import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberToWords {

    Map<Integer, String> dictionary = new HashMap<>();

    public NumberToWords() {
        dictionary.put(0, "Zero");
        dictionary.put(1, "One");
        dictionary.put(2, "Two");
        dictionary.put(3, "Three");
        dictionary.put(4, "Four");
        dictionary.put(5, "Five");
        dictionary.put(6, "Six");
        dictionary.put(7, "Seven");
        dictionary.put(8, "Eight");
        dictionary.put(9, "Nine");
        dictionary.put(10, "Ten");
        dictionary.put(11, "Eleven");
        dictionary.put(12, "Twelve");
        dictionary.put(13, "Thirteen");
        dictionary.put(14, "Fourteen");
        dictionary.put(15, "Fifteen");
        dictionary.put(16, "Sixteen");
        dictionary.put(17, "Seventeen");
        dictionary.put(18, "Eighteen");
        dictionary.put(19, "Nineteen");
        dictionary.put(20, "Twenty");
        dictionary.put(30, "Thirty");
        dictionary.put(40, "Forty");
        dictionary.put(50, "Fifty");
        dictionary.put(60, "Sixty");
        dictionary.put(70, "Seventy");
        dictionary.put(80, "Eighty");
        dictionary.put(90, "Ninety");
        dictionary.put(100, "Hundred");
        dictionary.put(1000, "Thousand");
        dictionary.put(1000000, "Million");
        dictionary.put(1000000000, "Billion");
    }

    public String numberInWords(Integer number) {
        if (number > 1000000000) {
            throw new IllegalArgumentException("Input value cannot be greater than 1 billion");
        }

        ArrayList<String> words = breakdownNumber(number);

        String sentence = String.join(" ", words);

        return sentence;
    }

    private ArrayList<String> breakdownNumber(Integer number) {
        ArrayList<String> words = new ArrayList<>();

        if (number == 1000000000) {
            words.add(dictionary.get(number));
        } else if (number >= 1000000) {
            int whole = number / 1000000;
            words.addAll(breakdownNumber(whole));
            words.add(dictionary.get(1000000));
            int remainder = number % 1000000;
            if (remainder > 0) {
                words.addAll(breakdownNumber(remainder));
            }
        } else if (number >= 1000) {
            int whole = number / 1000;
            words.addAll(breakdownNumber(whole));
            words.add(dictionary.get(1000));
            int remainder = number % 1000;
            if (remainder > 0) {
                words.addAll(breakdownNumber(remainder));
            }
        } else if (number >= 100) {
            int whole = number / 100;
            words.addAll(breakdownNumber(whole));
            words.add(dictionary.get(100));
            int remainder = number % 100;
            if (remainder > 0) {
                words.addAll(breakdownNumber(remainder));
            }
        } else if (number >= 20) {
            int whole = number / 10;
            words.add(dictionary.get(whole * 10));
            int remainder = number % (whole * 10);
            if (remainder > 0) {
                words.add(dictionary.get(remainder));
            }
        } else if (number < 20) {
            words.add(dictionary.get(number));
        }

        return words;
    }

}
