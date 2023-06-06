package GoogleQuestions;

public class MultiplyStrings {
    public String multiplyStrings(String num1, String num2) {
        //check for valid input
        if(num1 == null || num2 == null) {
            return "0";
        }
        int m = num1.length(); // 3
        int n = num2.length(); //3

        // base conditions
        if(m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        if ("1".equals(num1)) {
            return num2;
        }
        if ("1".equals(num2)) {
            return num1;
        }

        // Result can be maximum of length M + N.
        // For example 99 * 99 = 9801 (Result is of length 4)
        int[] result = new int[m + n]; // 6

        for(int i = m - 1; i >= 0; i--) { // i = 2,1,0
            for(int j = n - 1; j >= 0; j--) { // j = 2,1,0//2,1,0//2,1,0
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0'); // 18,15,12//12,10,8//6,5,4
                //Adding prev value to result array into this product
                product = product + result[i+j+1]; // 18+0,15+1,12+1//12+6,10+1,8+2//6+4,5+1,4+0

                // Adding the new product into result array
                result[i+j+1] = product % 10; // remainder:  8,6,3,8//1,4,0//0,6,5
                result[i+j] = result[i+j] + product / 10; // quotient: 1,1,1//1,2,1//1,1
            }//result= [0,5,6,0,8,8]
        }
        // Generating the result string
        StringBuilder sb = new StringBuilder();
        for(int r : result) { // result=[0,5,6,0,8,8]
            // Ignoring leading zeros
            if(sb.length() == 0 && r == 0) { // sb= 0,56088 // r= 0,5,6,0,8,8
                continue;
            }
            sb.append(r); // "56088"
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        MultiplyStrings m = new MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        System.out.println(m.multiplyStrings(num1, num2));
    }
}

// TC = O(M*N)
// SC = O(M+N)


// by using BigInteger
    /*
public String multiply(String num1, String num2) {
    BigInteger a=new BigInteger(num1);
    BigInteger b=new BigInteger(num2);
    BigInteger result=a.multiply(b);
    return String.valueOf(result);

}

// other way
if((num1.isEmpty() || num2.isEmpty()) && (num1.length() !=0 && num2.length() != 0)) {
            return "invalid";
        }
        int a = Integer.parseInt(num1); // 2
        int b = Integer.parseInt(num2); //6
        int result = 0;
        if(a >= 0 && b >= 0) {
            result = a*b;
        }
        return Integer.toString(result);
*/
