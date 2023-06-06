package GoogleQuestions;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left)/2; // (left+right)/2, this was it doesn't overflows
            if(target == nums[mid]) {
                return mid;
            }
            if(nums[left] <= nums[mid]) {
               if(target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                   left = mid + 1;
               }
            } else {
                if(target >= nums[mid] && target <= nums[right]) {
                    right = mid + 1;
                } else {
                    left = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        SearchInRotatedArray s = new SearchInRotatedArray();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(s.search(nums, target));
    }
}
