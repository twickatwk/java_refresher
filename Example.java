import java.util.ArrayList;
import java.util.Arrays;
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

    // 1.1 Write a method to check if a string has all unique characters
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

    // 1.1 Solution: Write a method to check if a string has all unique characters
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

    // 1.2 Check Permutation, Given two strings, check whether they are permuation of each other
    // Time: O(N Log N) - Sorting | Space: O(N)
    public static boolean checkPermutation(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s2Chars);

        return String.valueOf(s1Chars).equals(String.valueOf(s2Chars));
    }

    // 1.3 URLify a given String. Example: "Mr John Smith   " ->  "Mr%20John%20Smith"
    // Time: O(N) | Space: O(1)
    public static String URLify(String s){

        s = s.trim();
        s = s.replaceAll("\\s+", "%20");

        return s;
    }

    // 1.4 Palinedome Permutation: Given a String, check if it is a permutation of Palindrome
    // Time: O(N) | Space: O(N)
    public static boolean checkPalindomePermutation(String s){
        // Remove any spaces between the words
        s = s.replaceAll("\\s+", "");

        s = s.toLowerCase();

        HashMap<String, Integer> dict = new HashMap<String, Integer>();

        int differenceMargin = 0;
        if (s.length() % 2 == 1) {
            differenceMargin = 1;
        }

        // Count the occurrences of each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (dict.containsKey(s.charAt(i)+"")) {
                dict.put(s.charAt(i)+"", dict.get(s.charAt(i)+"")+1);
            }else {
                dict.put(s.charAt(i)+"", 1);
            }
        }

        

        // Check the numbe of variance of characters in the string
        for (String character:dict.keySet()){
            int count = dict.get(character);
            if (count % 2 == 1) {
                differenceMargin--;
            }
            if (differenceMargin < 0) {
                return false;
            }
        }

        return true;


    }


    public static void main(String[] args) {

        String s = "Tact Coa";
        System.out.println(checkPalindomePermutation(s));

        /* Test for URLify() method 
        String s = "Mr John Smith   ";
        System.out.println(URLify(s));
        */

        /* Test for checkPermutation() method
        String s1 = "abc";
        String s2 = "bca";
        System.out.println(checkPermutation(s1, s2));
        */

        /* Test for isUnique() method
        String s = "abbc";
        System.out.println(isUnique2(s));
        */
        
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