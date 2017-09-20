import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class SimpleWebScraping {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static int countWords(final String str) {
        int count = 1;
        for (int i = 0; i <= str.length() - 1; i++) {
            if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
                count++;
            }
        }
        return count;
    }

    public static int countOneWord(final String str, final String search) {
         int count = 0;
         int wordLength = 0;
         String searchUpper = search.toUpperCase();
         for (int i = 0; i < str.length(); i++) {
             int j = 0;
             char k = str.charAt(i);
             String word = "";
             while (k != ' ') {
                 j++;
                 wordLength++;
                 k = str.charAt(i + j);
                 word += k;
             }
             if (str.length() - i - 1 > i + wordLength) {
                 word = word.toUpperCase();
                 if (word.compareTo(searchUpper) == 0) {
                     count++;
                 }
             }
             wordLength = 0;
         }
        return count;
    }

    /**
     * It runs.
     *
     * @param args the argument
     */
    public static void main(final String[] args) {
        String url = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(url);
        System.out.println(countWords(url));
        System.out.println(countOneWord(url + " ", "Prince"));
    }
}
