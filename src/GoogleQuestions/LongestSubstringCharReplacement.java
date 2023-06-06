package GoogleQuestions;

public class LongestSubstringCharReplacement {
    public int charReplacement(String s, int k) {
        if(s.isEmpty() || k == 0) {
            return 0;
        }
        int[] count = new int[26]; // count the freq of each char
        int maxCount = 0; // track of max count of chars in current window
        int maxLen = 0; // track max len of substring
        int start = 0; // start of the current window

        for(int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A'; //0,1,2,3
            count[index]++; //1,2,2 // is incrementing the value in the array indexed by s.charAt(i) - 'A'.
            maxCount = Math.max(maxCount, count[index]); //1,1,2,2 // update the macCount of char

            // Check if the current window violates the constraint (k times operation)
            if( (i - start + 1) - maxCount > k) {
                // Shrink the window by moving the start pointer and updating the count
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLen = Math.max(maxLen, i - start + 1); //1,2,3,4// update max len
        }

        return maxLen;
    }
    public static void main(String[] args) {
        LongestSubstringCharReplacement l = new LongestSubstringCharReplacement();
        String s = "AABABBA";//"ABAB", k=2;
        int k = 1;
        System.out.println(l.charReplacement(s, k));
    }
}
