package GoogleQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SmallerNumbers {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums.length == 0 || Objects.isNull(nums)) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums.length];
        int[] copyArr = nums.clone(); //[1,2,2,3,8]
        Arrays.sort(copyArr);

        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(copyArr[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            ans[i] = map.get(nums[i]);
        }
        return  ans;
    }
    public static void main(String[] args) {
        SmallerNumbers s = new SmallerNumbers();
        int[] nums = {8,1,2,2,3};
        int[] res = s.smallerNumbersThanCurrent(nums);
        for(int r : res) {
            System.out.println(r);
        }
    }
}
