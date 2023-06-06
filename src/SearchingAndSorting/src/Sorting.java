import java.util.Arrays;
// to test my knowledge in sorting by using two for loops
public class Sorting {

    public static void swap(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < n; j++) { // or j < n -i will also be running till 5
                if(arr[j - 1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j - 1] = temp;
                }
            }
        }
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8};
        swap(arr);
        // sorting in ascending order

    }
}
