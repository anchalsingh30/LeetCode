public class InsertionSort {
    public static void printSelectionSortArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]); // 1,2,3,7,8
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2}; // sorted --> 7 | 8,3,1,2 <-- unsorted// 7,8|3,1,2 //
        //insertion sort
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i]; // 8,3,1,2
            int j = i-1; // 0,1,2,3
            while(j >= 0 && current < arr[j]) {
                 arr[j+1] = arr[j]; // 3
                 j--;
            }
            //placement
            arr[j+1] = current; // 8,3,1,2
        }
        printSelectionSortArray(arr);
    }
}
// TC = O(n^2)