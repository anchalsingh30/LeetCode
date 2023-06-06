public class MostWaterContainer {
    // maxArea = length * breadth => height * index
    // two pointer approach
    public int maxArea(int[] arr) {
        if(arr == null) {
            return 0;
        }
        if(arr.length == 0) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = arr.length-1; //8,7,6,5,4
        int maxAns = 0;
        while(leftHeight <= rightHeight) { // index is getting compared
            maxAns = Math.max(Math.min(arr[leftHeight], arr[rightHeight]) * (rightHeight - leftHeight),maxAns); //8,49,18,40,32
            if(arr[leftHeight] < arr[rightHeight]){ // height is getting compared
                leftHeight++; //1,
            } else {
                rightHeight --;
            }
        }
        return maxAns;
    }
    public static void main(String[] args) {
        MostWaterContainer m = new MostWaterContainer();
        int[] height = {1,8,6,2,5,4,8,3,7}; // ans= 49 // [1,1] ans =1
        System.out.println(m.maxArea(height));

    }
}
