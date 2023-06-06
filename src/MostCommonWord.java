import java.util.*;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.isEmpty() && paragraph.length() == 0 && banned.length == 0){
            return "";
        }
//        if(!paragraph.isEmpty() || banned == null || banned.length==0) {
//            return paragraph;
//        }
        //filter punctuation and make string to lowerCase, split spaces and store it in String array
        //store array of banned in set of string
        //
        String[] words = paragraph.replaceAll("[^A-Za-z]+", " ").toLowerCase().split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        Set<String> bannedWords = new HashSet<>();

        for(String word : banned) {
            bannedWords.add(word); // [hit]
        }

        for(int i = 0; i < words.length; i++){ //
            map.put(words[i], map.getOrDefault(words[i], 1) + 1);
        }

        int mostCommonWordCount = 0;
        String freqWord = "";
        for(Map.Entry<String, Integer> entry : map.entrySet()) { // []
            if(mostCommonWordCount <= entry.getValue() && !bannedWords.contains(entry.getKey())) { //[bobaballeballflewfaraderwas]
                mostCommonWordCount = entry.getValue();
                freqWord = entry.getKey();
            }
        }
        return freqWord;
    }

    public static void main(String[] args) {
        MostCommonWord m = new MostCommonWord();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String result = m.mostCommonWord(paragraph, banned);
        System.out.println(result);
    }
}
