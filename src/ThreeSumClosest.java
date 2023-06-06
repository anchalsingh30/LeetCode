import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] arr, int target) {
        if(arr == null) {
            return 0;
        }
        if(arr.length == 0) {
            return 0;
        }
        //sort the array first
        Arrays.sort(arr); // [-4,-1,1,2]
        int sum = 0;
        int diff = arr[arr.length-3] + arr[arr.length - 2] + arr[arr.length - 1]; // -3
        for(int i = 0; i < arr.length ; i++) {
            int left = i+1;
            int right = arr.length -1;
            while(left < right) {
                sum = arr[i] + arr[left] + arr[right]; // -3
                if(Math.abs(sum - target) < Math.abs(diff - target)) { //-4
                    diff = sum;
                }
                if(sum > target) {
                    right--;
                } else if(sum < target) {
                    left++;//2
                } else {
                    return target;
                }
            }
        }
        return diff;
    }
    public static void main(String[] args) {
        ThreeSumClosest t = new ThreeSumClosest();
        int[] arr = {-1,2,1,-4}; //
        int target = 1;
        System.out.println(t.threeSumClosest(arr, target));

    }
}
