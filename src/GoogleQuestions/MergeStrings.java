package GoogleQuestions;

public class MergeStrings {
    public String mergeAlternately(String word1, String word2) {
        /* By using two pointers and char array to store chars from both words
        char[] resultArr = new char[length1 + length2];
        if (pointer1 < length1) {
                resultArr[resultPointer++] = word1.charAt(pointer1++);
            }
            if (pointer2 < length2) {
                resultArr[resultPointer++] = word2.charAt(pointer2++);
            }
         */
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < word1.length() || i < word2.length()) {
            //
            if(i < word1.length()) {
                sb.append(word1.charAt(i));
            }
            if(i < word2.length()) {
                sb.append(word2.charAt(i));
            }
            i++;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        MergeStrings m = new MergeStrings();
        String word1 = "ab";
        String word2 = "pqrs";
        System.out.println(m.mergeAlternately(word1, word2));
    }
}
