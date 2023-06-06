package GoogleQuestions;

public class LongestPalindrome {
    int start = 0;
    int end = 0;
    public String longestPalindromeSubstring(String s) {
        if(s.length() == 0 || s.length() == 1)
            return s;

        for (int i = 0; i< s.length(); i++) { //i=0,1,2,3,4,5
            findSubstringForPalindrome(s, i, i); //"babad",0,0 //"babad",3,3
            findSubstringForPalindrome(s, i, i+1); //"babad",3,4//"babad",4,5
        }

        return s.substring(start, start + end); //start=1, end =3
    }

    private void findSubstringForPalindrome(String s, int i, int j) { //"babad",0,0//"babad",0,1//"babad",3,4
        while(i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            i--; // i = -1,0,-1,2,1,0,2,3 			//b,a,b,a
            j++; // s= 4, j=1,2,3,3,4,4,5  //b,a,b,a,
        }
        if (end < j - i - 1) { // end = 1,3
            start = i + 1; //start = 0,1
            end = j - i - 1; // end = 1,3
        }
    }
    public static void main(String[] args) {
        LongestPalindrome l = new LongestPalindrome();
        String s = "babad"; //
        String str = l.longestPalindromeSubstring(s);
        System.out.println(str); // "aba" can also be palindrome
    }
}
