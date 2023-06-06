import java.util.*;

public class TwoSum {
    public int[] addTwoElements(int[] nums, int target) {
        // edge cases: array is empty, all negatives, are there any combination of negative and positive elements
        if(nums == null ) { // array is empty
            return new int[0];
        }
        if(nums.length == 0) {
            return new int[0];
        }
        // initialize index of size 2
        int[] arr = new int[2];
        int result = 0;
        Map<Integer, Integer> map = new HashMap();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i],i);
            }
            result = target - nums[i]; //11,6,2
            if(map.containsKey(result)) {
                arr[0] = map.get(result); //2,0
                arr[1] = i; //0,2
            }
        }
        return arr; // [0,2]
    }
    public static void main(String[] args) {
        TwoSum t = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 13;
        System.out.println(Arrays.toString(t.addTwoElements(nums, target)));
    }
}

// TC - O(n) - traversed n number of elements at least once
// SC - O(1) - can store n number of elements.

//in case of boolean - O(n^2)
/*
for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                if(nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
 */
/* brute force solution - O(n^2)
 public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        // In case there is no solution, we'll just return 0
        return 0;
    }
 */