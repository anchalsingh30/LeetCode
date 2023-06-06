public class StringtoInt {
    public int myAtoi(String str) {
        // edge cases - empty string, all can be letters, mix of integers and letter,
        // positive or negative signs with integers, spaces in the string

        //case in leetcode:
        /*
        1. white space
        2. Sign(-,+)
        3. if have word/letter after digits
        4. String does not exist
        5. first sequence is not numeric and no white spaces
        6. out of range
         */
        // ignore white space is at starting
        // if non digits and no white space
        // start with -, + signs or start with digit chars
        //if all are chars then return 0
        // if "-91283475869797"it's out of range from int then return 0
        if(str==null) return 0;

        str=str.trim();

        if(str.length()==0) return 0;
        int sign = +1;
        long ans = 0;
        if(str.charAt(0) == '-') sign = -1;

        int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;

        // initiate the starting pointer
        int i = (str.charAt(0) == '+' || str.charAt(0) == '-') ? 1 : 0;

        while(i < str.length()) {
            if(str.charAt(i) == ' ' || !Character.isDigit(str.charAt(i))) break;
            ans = ans * 10 + str.charAt(i)-'0';
            // check the conditions
            if(sign == -1 && -1*ans < MIN) return MIN;
            if(sign == 1 && ans > MAX) return MAX;

            i++;
        }

        return (int)(sign*ans);

//        String value = "";
//        int i = 0;
//        while(i < str.length()) {
//            i++;
//            if(!(str.charAt(i) == ' ' && (str.charAt(i) >= 'a' || str.charAt(i) <= 'z') && (str.charAt(i) >= 'A' || str.charAt(i) <= 'Z'))) { // space,
//                value = value + str.charAt(i); // "-42"
//            }
////            else {
////                i++; //1,2,3,4,5
////            }
//        }
//        // convert string to integer
//        int result = Integer.parseInt(value);
//
//        return result;
    }
    public static void main(String[] args) {
        StringtoInt s = new StringtoInt();
        String str = "  -42"; // "42" , "30 Anchal", "Java"
        System.out.println(s.myAtoi(str));
    }
}
