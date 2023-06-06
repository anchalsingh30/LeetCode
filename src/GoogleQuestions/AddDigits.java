package GoogleQuestions;

public class AddDigits {
    public int addDigits(int nums) {
        if(nums == 0) {
            return 0;
        }
        /*else if(nums % 9 == 0) return 9;
        else return nums % 9; */

        int sum = 0;
        String s = String.valueOf(nums);
        for(int i = 0 ; i < s.length(); i++) {
            sum += s.charAt(i) - '0';
        }
        if(sum < 10) {
            return sum;
        }
        return addDigits(sum);
    }
    public static void main(String[] args) {
        AddDigits a = new AddDigits();
        int nums = 38;
        System.out.println(a.addDigits(nums));
    }
}
