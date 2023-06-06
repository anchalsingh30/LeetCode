import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class LongestSubstring {
    public int longestStringNoRepChar(String str)
    {
        //edge case - Non char, String is empty, All caps/small or mix
        int max=0;
        int right=0;
        int left=0;
        HashSet<Character> set = new HashSet<>();

        if(str == null || str.length() == 0){ // string is empty
            return 0;
        }

        while(right<str.length()) { // (7<7)false
            if(!set.contains(str.charAt(right))) { // if no matching char
                set.add(str.charAt(right)); //p,
                max=Math.max(set.size(),max); //1,2,3 // set = abc/bca/cab/abc/acb
                right++; // 1,2,3,4,5,6,7
            } else { // if matching char then remove
                set.remove(str.charAt(left)); // removed from set= a,b,c,a,b
                left++; //1,2,3,4,5
            }
        }
        return max;

    }
    public static void main(String[] args) {
        LongestSubstring sub = new LongestSubstring();
        String str = "abcabcbb"; // "bbbbb", "pwwkew"
        System.out.println(sub.longestStringNoRepChar(str));

    }
}
/*
store hashset
store char = a+b+c
find longest string
find length
j=i+1
!s.charAt(i) == s.charAt(j)
p
 */

//        Map<Character, Integer> map = new HashMap<>();//[0,0] //[a,2] [b,4] [c, 2]//[b,4]// [p,1][w,3][k,1][e,1]
////        char[] ch = new char[str.length()];
//        String res = "";
//        for(int i=0; i < str.length(); i++) {
//            if(!map.containsKey(str.charAt(i))) {
//                map.put(str.charAt(i), i);//pwke-1,3,1,1
//            }
//            res = ""+ str.charAt(i); //p
//            if(!map.containsKey(str.charAt(i) )) {
//                res = res + str.charAt(i); // "p"
//            }
//
//        }



//        char[] ch = str.toCharArray(); // [p,w,w,k,e,w]
//        String r = "";
//        for(int i = 0; i < str.length(); i++) {
//            r = r+str.charAt(i); // p
//            for (int j = i + 1; j < str.length(); j++) {
//                if (str.charAt(i) != str.charAt(j)) { // i=p,w,w,k,e  j=w,w,k,e,w
//                    r = r + str.charAt(j); // "pwkew"
//                }
//            }
//