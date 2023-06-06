import java.util.HashMap;
import java.util.Map;

public class FirstUniqCharacter {
    public int firstUniqChar(String s) {
        // edge case
        if(s == null || s.length() == 0) {
            return -1;
        }
        //1. compare first char with the next char
        // 2. if the char does not match return me the char
        // 3. and if the char matches, move to next char and repeat step2
        //two for loops- not a good plan
        // hashmap - will store all chars in map and compare by taking first char from the String s
        // if hashmap does not containsKey s.charAt(i) then return that char
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            //all the chars will be getting stored with its index and its value will be 1
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1); // map = [[l,0][o,][v,][e,][l,][e,][e,][t,][c,][o,][d,][e,]]
        }

        for(int j = 0; j < s.length(); j++) {
            if (map.get(s.charAt(j)) == 1)
                return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqCharacter f = new FirstUniqCharacter();
        String s =  "loveleetcode"; // "leetcode"
        System.out.println(f.firstUniqChar(s));;
    }
}

// TC
// SC

/*
// this won't work in case of string is having all duplicate chars "aabb"
HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hm.containsKey(s.charAt(i))) { // removed a,b
                hm.remove(s.charAt(i));
            }
            if (!hm.containsKey(s.charAt(i))) { //[a,0][a,1][b,2][b,3]
                hm.put(s.charAt(i), i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : hm.entrySet()) { //[a,1][b,3]
            if (min > entry.getValue())
                min = entry.getValue();
        }
        return min;
 */