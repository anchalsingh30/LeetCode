package GoogleQuestions;

import java.util.HashSet;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
    if(nums.length == 0 || nums == null) return 0;
    HashSet<Integer> numSet = new HashSet<>(); // elements in set is not ordered internally
        for(int num : nums) {
        numSet.add(num);
    }

    int maxCount = 0;
    for (int num = 0; num <= nums.length; num++) {
        if (!numSet.contains(num - 1)) { // the difference in a consecutive integer is of 1 so num -1
            int currNum = num; //0,0
            while(numSet.contains(currNum + 1)) {
                currNum++; //1,2,3,4,5,6,7,8 // 1,2,3,4,5,6,7,8
            }
            maxCount = Math.max(maxCount, currNum - num + 1); //(0, 8-0+1)=9, again currNum is 9
        }
    }
        return maxCount; //9
}
    public static void main(String[] args) {
        LongestConsecutive l = new LongestConsecutive();
        int[] nums = {0,3,7,2,5,8,4,6,0,1}; // [100,4,200,1,3,2]
        int longestStreak = l.longestConsecutive(nums);
        System.out.println("Longest consecutive sequence length: " + longestStreak);
        // Output: Longest consecutive sequence length: 4
    }
}
