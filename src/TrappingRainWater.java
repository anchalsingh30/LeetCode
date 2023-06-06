public class TrappingRainWater {
    public int trapWater(int[] height) {
        if (height.length == 0)
            return 0;

        int left = 0;
        int right = height.length -1;
        int result = 0;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;

        while(left<=right) {
            leftMax = Math.max(leftMax, height[left]); //0,1,1,1,2,2,2,2,2,2,3
            rightMax = Math.max(rightMax, height[right]); //1,1,2,2,2,3,3,3,3

            if(leftMax < rightMax) {
                result += leftMax-height[left]; //0,1,1,2,3,5,6
                left++; // 1,2,3,4,5,6,7
            } else {
                result += rightMax - height[right]; //1,2,2,6
                right--; //11,10,9,8,7,6
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(t.trapWater(height));
    }
}
