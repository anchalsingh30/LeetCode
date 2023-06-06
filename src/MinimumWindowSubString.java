import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {
    public String minWindow(String s, String t) {
        //when case-sensitive
//        String s1 = s.toLowerCase();
//        String t1 = s.toLowerCase();

        if(s == null || s.length() < t.length() || s.length() == 0){
            return "";
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i); //
            if(map.containsKey(c)){
                map.put(c,map.getOrDefault(c,0)+1); // [[A,1],[B,1],[C,1]] each chars in map is having freq of 1
            } else {
                map.put(c,1); // if found duplicate char the if condition will get false and won't add the dupe char so it will come in else and add it with freq 1 itself
            }
        }

        int left = 0;
        int minLeft = 0;
        int minLen = s.length()+1; //13,14
        int count = 0;

        for(int right = 0; right < s.length(); right++){ //0,1,2,3,4,5// 6,7,8,9,10,11,12
            char startChar = s.charAt(right);
            if(map.containsKey(startChar)){ // t's hashmap
                map.put(startChar,map.get(startChar)-1); //[[A,0],[B,0],[C,0]] // [[B,-1],[A,0][C,0]]
                if(map.get(startChar) >= 0){
                    count ++; // map size is increasing =1,2,3 //3
                }
                //after desirable window of ABC
                while(count == map.size()){ //count=3, map size = 3 //
                    if(right - left + 1 < minLen){ //5-0+1<14, //10-1+1<6,10-2+1<6//12-9+1<5
                        minLeft = left; //0,1,2,3,4,5,6,7 // 7,8,9
                        minLen = right - left + 1; //6,5,4
                    }
                    char startChar2 = s.charAt(left); //A,D,O,B,E,C,O // D,E,B
                    if(map.containsKey(startChar2)){
                        map.put(startChar2,map.get(startChar2) + 1); // [[A,1],[B,1],[C,1]] // [[B,0]]
                        if(map.get(startChar2) > 0){ // 1>0,
                            count --; //count =2,1,0 // 3-1=2,
                        }
                    }
                    left ++ ; //1,2,3,4,5,6,7 // 8,9,10
                }
            }
        }
        if(minLen > s.length()) //4>13
        {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen); //(9, 9+4)

    }

    public static void main(String[] args) {
        MinimumWindowSubString min = new MinimumWindowSubString();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String minSub = min.minWindow(s, t);
        for(int i = 0; i < minSub.length(); i++) {
            System.out.print(minSub.charAt(i));
        }
    }
}
//TC O(n+m) = visiting String s and t
// SC O(n+m) = storing chars in a hashmap of string s and t

/*        int i = 0, j = 0, count = map.size(); //
        int left = 0, right = s.length() - 1, min = s.length(); // left=  //right=12 // min=13

        boolean found = false; //false,true

        // j will be traversing the s String
        while( j < s.length()) { //j=0 //2nd round j=6,7,8,9,10
            char endChar = s.charAt(j);
            j++;//1,2,3,4,5,6 //7,8,9,10,11
            if(map.containsKey(endChar)) { // if duplicate char in map
                map.put(endChar, map.get(endChar) - 1); //[[A,0][B,0][C,0]]//[[A,1-1=0][B,1-1=0][C,0]] decrease the count of that char
                if (map.get(endChar) == 0) { // have satisfied to have all char in a substring if char value is 0
                    count = count - 1; // count=3,2,1,0 //1,1,0 map size get decrease by 1
                }
            }
                if (count > 0) {
                    continue; // if this is true it means we haven't found a min window substring yet
                }

                // to shave off unnecessary char from a desired substring
                while(count == 0) {
                    char startChar =  s.charAt(i);
                    i++; //1, // everytime we extract a char from i pointer, we also need to move forward right after
                    if(map.containsKey(startChar)) {
                        map.put(startChar, map.get(startChar) + 1); //[[A,1][B,0][C,0]]
                        if(map.get(startChar) > 0) { //1,
                            count = count + 1; //0tha count, map size 1,
                        }
                    }
                }
                // compute the length of substring
                if((j-i) < min) { //j=6, //i=1, // j-i=6-1 => 5>13
                    left = i; //1,
                    right = j; //6,
                    min = j - i; // 5, //min is for convenience

                    found = true; //true
                }
            }
            return !found ? "" : s.substring(left-1, right);
        } */