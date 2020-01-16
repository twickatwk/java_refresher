import java.util.HashMap;

public class MostCommonWord {

        // Time: O(N^2) | SpaceL O(N)
        public static String getMostCommonWord(String paragraph, String[] banned) {
        
        // Use a dictionary for banned words (HashMap)
        HashMap<String, Boolean> bannedWords = new HashMap<String, Boolean>();
        
        // Use another dictionary to track the number of occurrences of words
        HashMap<String, Integer> wordCount = new HashMap<String, Integer>();
        
        
        // Time: O(N)
        for (String word : banned) {
            bannedWords.put(word, true);
            
        }
        
        paragraph = paragraph.replaceAll(",", " ");
        paragraph = paragraph.replaceAll("\\s+", " ");
        String[] listOfWords = paragraph.split(" ");
        
        // Time: O(N)
        for (String s : listOfWords) {
            // Time: O(N)
            if (!s.chars().allMatch(Character::isLetter)) {
                s = s.substring(0, s.length() - 1);  
            }

            s = s.toLowerCase();
        
            if (!bannedWords.containsKey(s)) {
                if (wordCount.containsKey(s)) {
                    wordCount.put(s, wordCount.get(s)+1);
                }else{
                    wordCount.put(s, 1);
                }
            }
        }
        
        int maxCount = 0;
        String maxWord = null;
        
        // Time: O(N)
        for (String key : wordCount.keySet()) {
            int count = wordCount.get(key);
            if (count > maxCount) {
                maxCount = count;
                maxWord = key;
            }    
            
        }
        
        return maxWord;
        
        
    }

    public static void main(String[] args) {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(getMostCommonWord(s, banned));

    }
}