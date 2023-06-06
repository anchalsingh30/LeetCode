package GoogleQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GoodPairs {
    public int getIdenticalPairs(int[] nums) {
        if(nums.length == 0 || Objects.isNull(nums)) {
            return -1;
        }
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums)
        {
            int value = map.getOrDefault(i,0); //0,0,0,1,2,1
            count = count + value; //0,0,0,1,3,4
            map.put(i,value+1); // [[1,1][2,1][3,1]] //[[2,1][1,3][3,2]]
        }
        return count;
    }
    public static void main(String[] args) {
        GoodPairs g = new GoodPairs();
        int[] nums = {1,1,1,1};
        System.out.println(g.getIdenticalPairs(nums));
    }
}
