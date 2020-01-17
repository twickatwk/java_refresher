import java.util.ArrayList;
import java.util.HashMap;

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

    // Write a method to concatenate a list of string in O(N) time
    // Time: O(N) | Space: O(N)
    public static String joinWords2(String[] words){
        StringBuilder sentence = new StringBuilder();
        for (String word : words){
            sentence.append(word);
        }
        return sentence.toString();
    }

    // Write a method to check if a string has all unique characters
    // TimeL O(N) | Space: O(N)
    public static boolean isUnique(String sentence){
        // Use a dictionary to track the number of characters and their count
        HashMap<Character, Integer> dict = new HashMap<Character, Integer>();
        
        for (int i = 0; i < sentence.length(); i++){
            char c = sentence.charAt(i);
            if (dict.containsKey(c)) {
                dict.put(Character.valueOf(c), dict.get(Character.valueOf(c))+1);
            }else{
                dict.put(Character.valueOf(c), 1);
            }
        }

        // return false if any of the count in the dictioary exceeds 1, else return true
        for (Character character : dict.keySet()){
            if (dict.get(character) > 1) {
                return false;
            }
        }

        return true;
    }

    // Solution: Write a method to check if a string has all unique characters
    // Time: O(N) | Space: O(1) - the size is always the same, 128
    public static boolean isUnique2(String sentence) {
        boolean[] characters = new boolean[128];

        for (int i = 0; i < sentence.length(); i++) {
            int value = sentence.charAt(i); // Converts the char to the int representation
            if (characters[value]) {
                return false; // if the character's int represetation is true, means it already exists
            }
            characters[value] = true;
        }

        return true;
    }


    public static void main(String[] args) {

        String s = "abbc";
        System.out.println(isUnique2(s));
        
        /* Test for joinWords method()
        String[] words = {"Hello", "World"};
        System.out.println(joinWords2(words));
        */


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