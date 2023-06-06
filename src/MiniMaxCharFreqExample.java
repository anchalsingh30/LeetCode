import java.util.HashMap;
import java.util.Map;

public class MiniMaxCharFreqExample {
    public void minSubstring(String s, String t) {
        //edge cases
        if (s == null || s.length() == 0 || s.length() < t.length()) {
            return;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        //printing chars with 0 freq
        for (int j = 0; j < t.length(); j++) {
            System.out.println(map.get(t.charAt(j)));
        }
        System.out.println();
        //increasing chars value when matches with existing chars in map
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1); // each chars freq increases
            }
        }
        //print chars with freq 1
        for (int k = 0; k < t.length(); k++) {
            System.out.println(map.get(t.charAt(k)));
        }
        System.out.println();

        //getting min freq. char and min freq
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        char maxChar = ' ';
        char minChar = ' ';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey(); //A,B,C
            int value = entry.getValue(); //3,4,4
            if (min > value) {
                min = value; //3
                minChar = key;
            }
            //getting max freq. char and max freq
            if (max < value) {
                max = value; //4
                maxChar = key; //4
            }
        }
        System.out.println("Min freq of a char : " + min);
        System.out.println("Min fre char :" + minChar);
        System.out.println();

        System.out.println("Max freq of a char : " + max);
        System.out.println("Max freq char : " + maxChar);

    }

    public static void main(String[] args) {
        MiniMaxCharFreqExample min = new MiniMaxCharFreqExample();
        String s = "ABCDOBECODEBANC";
        String t = "ABC";
        min.minSubstring(s, t);
    }
}
// TC O(n)+O(n)+O(n) = O(3n) = O(n)
// SC O(n)