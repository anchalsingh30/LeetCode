package GoogleQuestions;

import java.util.Objects;

public class ProductandSum {
    public int subtractProductAndSum(int n){
        if(n == 0 || Objects.isNull(n)) {
            return 0;
        }
        int diffResult = 0;
        int product = 1;
        int sum = 0;
        while(n != 0) {
            product = product * (n % 10); // 4*3=12*2=24
            sum = sum + (n % 10); //4+3=7+2=9
            n = n/10; //23,2,0
        }
        diffResult = product - sum; // 24-9
        return diffResult; //15
    }
    public static void main(String[] args) {
        ProductandSum p = new ProductandSum();
        int n = 234;
        System.out.println(p.subtractProductAndSum(n));
    }
}
