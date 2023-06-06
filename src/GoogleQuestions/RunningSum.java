package GoogleQuestions;

import java.util.Arrays;
import java.util.Objects;

public class RunningSum {
    public int[] runningSum(int[] nums) {
        if(nums.length == 0 || Objects.isNull(nums)) {
            return new int[0];
        }

        for(int i = 1; i < nums.length; i++) { //i=1,2,3
            nums[i] = nums[i] + nums[i-1]; //at 1=2+nums[0], at 2=3+nums[1], at 3=6+nums[2]
        }//nums[i]=[1,3,6,10]
        return nums;
    }

    public static void main(String[] args) {
        RunningSum r = new RunningSum();
        int[] nums = {1,2,3,4};
        int[] res = r.runningSum(nums);
        for(int i :  res) {
            System.out.println(i);
        }
    }
}
