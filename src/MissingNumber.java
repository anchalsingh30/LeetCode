import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        // compare index i=0 with j=0=nums[0] //nums[3,0,1]= 0-3
        //hashset

//       for(int i = 0; i < nums.length; i++) { // 0,1,2
////           for (int j = 0; j < nums.length; j++) { // 0,1,2//0,1,2//0,1,2
//           int j=0;
//           while(j<nums.length) {
//               if (i != nums[j]) { // 2>0 && 2<3 (i>nums[j] && i<nums[j])
//
//               }
//
//           }
//       }
        if(nums == null || nums.length == 0 ) {
            return -1; // null
        }

        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]); // [3,0,1] // [0,1]
            }
        }
        for(int j = 0; j <= set.size(); j++) {
            if(!set.contains(j)) {
                return j;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        MissingNumber m = new MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        int missValue = m.missingNumber(nums);
        System.out.println(missValue);
    }
}
//TC O(n)+O(n) = O(2n) = O(n)
//SC O(1)