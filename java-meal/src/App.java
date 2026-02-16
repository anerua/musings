public class App {
    public static void main(String[] args) throws Exception {
        var numToWords = new NumberToWords();
        String result = numToWords.numberInWords(666);
        System.out.println("The number in words is:");
        System.out.println(result);
    }
}
