public class SelectionSort {
    public static void printSelectionSortArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2}; // 3,8,7,1,2 // 3,7,8,1,2

        // find the smallest value in the array by comparing the first element from the array. If found then swap each other.
        for(int i = 0; i < arr.length-1; i++) { // after 1 swapping : [1,8,3,7,2], then 2nd arr[1,2,3,7,8], then 3rd arr[1,2,3,7,8], then 4th arr[1,2,3,7,8]
            int smallest = i; // 0,1,2
            for(int j = i+1; j < arr.length; j++) { // j =1,2,3,4  arr[j] = 8,3,1,2 , j = 2,3,
                if(arr[smallest] > arr[j]) { // arr[smallest] = 3,1
                    smallest = j; // smallest= 2,3 // 2,3
                }
            }
            int temp = arr[smallest]; // temp = 3,7,
            arr[smallest] = arr[i]; // arr[smallest] = 7,
            arr[i] = temp; // arr[i] = 3,
        } // 3,8,7,1,2 // 3,7,8,1,2
        printSelectionSortArray(arr);
    }
}
// TC = O(n^2)