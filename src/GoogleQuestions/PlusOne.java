package GoogleQuestions;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) {
            return new int[0];
        }
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i]++; //4
                return digits; //[1,2,4]
            }
            digits[i] = 0;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        int[] digits = {1,2,3}; // {4,3,2,1} {9}
        int[] res = p.plusOne(digits);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
//TC O(n)
//SC O(n)