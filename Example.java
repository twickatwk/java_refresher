import java.util.ArrayList;

public class Example {

    // Create a method to combine two ArrayList together
    // Time: O(N) | Space: O(1)
    public static ArrayList<String> merge(ArrayList<String> words, ArrayList<String> more) {

        for (String word : more) {
            words.add(word);
        }

        return words;

    }

    // Write a method to conatenate a list of Strings
    // Time:O(N^2) - Everytime a word is appended, a new string is recreateed | Space: O(N)
    public static String joinWords(String[] words) {
        String sentence = "";

        for (String word : words) {
            sentence += " " + word;
        }

        return sentence;
    }

    public static void main(String[] args) {

        String[] words = {"Hello", "World"};
        System.out.println(joinWords(words));



        /* Test for merge() method
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("a");
        a1.add("b");
        a1.add("c");
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("a");
        a2.add("b");
        a2.add("c");
        System.out.println(merge(a1, a2));
        */

    }
}