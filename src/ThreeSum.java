import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] arr) {
        if(arr == null || arr.length == 0) {
            return new ArrayList<>();
        }
        //sort the array first
        Arrays.sort(arr); //{-4,-1,-1,0,1,2}
        Set<List<Integer>> set = new HashSet<>();
           for(int i = 0; i < arr.length - 2; i++) {
            int left = i+1;
            int right = arr.length-1;
            int sum = 0;
            //compare index
            while(left < right) {
                sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    set.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                } else if(sum > 0){
                    right--;
                } else {
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
    public static void main(String[] args) {
        ThreeSum t = new ThreeSum();
        int[] arr = {-1,0,1,2,-1,-4}; // {0,1,1} return [] array
        List<List<Integer>> result = t.threeSum(arr);
        for(int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
        }

    }
}
