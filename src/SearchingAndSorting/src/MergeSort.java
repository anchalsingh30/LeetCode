public class MergeSort {
    //TC = O(nlogn)
    public static void conquer(int[] arr, int si, int mid, int ei) {
        int[] mergeArray = new int[ei - si + 1]; // array size starts from 0 so will add +1 to get the length
        int indx1 = si; // this variable is tracking first array of original array after divide
        int indx2 = mid+1; // this variable is tracking second array of original array divide
        int x = 0; // x is tracking mergeArray

        //O(n) - linear time
        while(indx1 <= mid && indx2 <= ei) {
            if(arr[indx1] <= arr[indx2]) {
                mergeArray[x] = arr[indx1];//3,6
                x++; //2,4
                indx1++; //1,2
            }
            else {
                mergeArray[x] = arr[indx2]; //2,5,8
                x++; //1,3,5
                indx2++; //4,5,6
            }
        }

        while(indx1 <= mid) { //indx1=2,mid=2
            mergeArray[x] = arr[indx1]; //9
            x++;//6
            indx1++;//3
        }
        while(indx2 <=  ei) {
            mergeArray[x] = arr[indx2];
            x++;
            indx2++;
        }
        // copy the mergedArray to original array
        for(int i = 0, j = si; i < mergeArray.length; i++, j++) {
            arr[j] = mergeArray[i];
        }
    }
    public static void divide(int[] arr, int si, int ei) {
        if(si >= ei) { // edge case
            return;
        }
        //O(logn)
        int mid = si + (ei - si) / 2; // si+ei/2 is normal math for index but not using it because it can cause index error
        divide(arr, si, mid);
        divide(arr, mid + 1, ei);
        conquer(arr, si, mid, ei); // arr,0,2,5
    }
    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;

        divide(arr,0,n-1);
        for(int i = 0; i < n ; i++) {
            System.out.println(arr[i] + " ");
        }
        System.out.println();

    }
}
// TC = conquer O(n)+ divide O(logn) = O(nlogn) -> worst
// SC in worst= O(n)