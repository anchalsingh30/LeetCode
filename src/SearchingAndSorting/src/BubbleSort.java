import java.util.Arrays;

public class BubbleSort {
    public static void printBubbleSortArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int[] arr = {7,8,3,1,2}; // 7,3,1,2,8 // 3,1,2,7,8 // 1,2,3,7,8
        // bubble sort the elements in n-1
        for(int i = 0; i < arr.length-1; i++) { // i = 0,1,2,3,4
            for(int j = 0; j < arr.length-i-1; j++) { // len = 4,3,
                if(arr[j] > arr[j+1]) { //compare 7,8 // 8,3 // 8,1 // 8,2 ||
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; // 7,3,1,2,8 // 3,1,2,7,8 // 1,2,3,7,8
                }
            }
        }
        printBubbleSortArray(arr);
    }
}
// The TC is worst but this sorting should not be used anywhere.
// TC = O(n^2)