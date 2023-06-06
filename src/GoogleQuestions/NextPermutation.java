package GoogleQuestions;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2; //1
        while(i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if(i>=0) {
            int j = nums.length - 1;
            while(nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j); //2,1,3
        }
        reverse(nums, i+1, nums.length - 1);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int i, int j) {
        while( i < j) {
            swap(nums, i++ , j--);
        }
    }
    public static void main(String[] args) {
        NextPermutation n = new NextPermutation();
        int[] nums = {1,2,3};
        n.nextPermutation(nums);
    }
}
