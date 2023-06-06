import java.util.HashMap;
import java.util.Map;

public class CharPalindrome {
        public static String solution(String s) {
            // Create a map to store the frequencies of each character in the string.
            Map<Character, Integer> frequencies = new HashMap<>();
            for (char c : s.toCharArray()) {
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }

            // Find the longest palindrome that can be formed with the characters in the map.
            String longestPalindrome = "";
            for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
                char c = entry.getKey();
                int frequency = entry.getValue();

                // If the character has an odd frequency, we can only form a palindrome of length 1.
                if (frequency % 2 == 1) {
                    longestPalindrome += c;
                }

                // Otherwise, we can form a palindrome of length frequency / 2.
                else {
                    for (int i = 0; i < frequency / 2; i++) {
                        longestPalindrome += c;
                    }
                }
            }

            // Sort the string lexicographically.
            return longestPalindrome.toLowerCase();
        }

        public static void main(String[] args) {
            String s = "aaabb";
            System.out.println(solution(s));

            s = "aaabbbcc";
            System.out.println(solution(s));
        }

}




