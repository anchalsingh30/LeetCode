public class XOROperation {
    public int xorOperation(int n, int start) {
        if(n == 0 || start == -1) {
            return 0;
        }
        int[] nums = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            nums[i] = start + 2 * i; //[0,2,4,6,8]
        }
        for(int i = 0; i < nums.length; i++) {
            sum = sum ^ nums[i]; //
        }
        return sum;
    }
    public static void main(String[] args) {
        XOROperation x = new XOROperation();
        int n =5;
        int start = 0;
        System.out.println(x.xorOperation(n, start));
    }
}
