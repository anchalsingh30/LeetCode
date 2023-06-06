package GoogleQuestions;

public class ConcatenationArray {
    public int[] getConcatenation(int[] nums) {
        if(nums.length == 0) {
            return new int[0];
        }
//        int[] ans = new int[2 * nums.length];
//        for(int i = 0; i < nums.length; i++) {
//            ans[i] = nums[i];   // ans[0,1,2]=ans[1,2,1]
//            ans[i + nums.length] = nums[i]; //ans[0+3,1+3,2+3]=ans[1,2,1]
//        }
//        return ans;

        int[] ans = new int[2 * nums.length];
        for(int i = 0, j = nums.length; i < nums.length; i++, j++) {
            ans[i] = nums[i];   // ans[0,1,2]=ans[1,2,1]
            ans[j] = nums[i]; //ans[0+3,1+3,2+3]=ans[1,2,1]
        }
        return ans;

    }
    public static void main(String[] args) {
        ConcatenationArray c = new ConcatenationArray();
        int[] nums = {1,2,1};
        int[] res = c.getConcatenation(nums);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }
}
