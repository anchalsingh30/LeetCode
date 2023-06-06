import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int min = Arrays.stream(arr).min().orElse(0);
        int max = Arrays.stream(arr).max().orElse(Integer.MAX_VALUE);

        int[] countArray = new int[max - min + 1];
        //taking a diff from value-min to get the index of that value from orig array
        for( int value : arr) {
            countArray[value-min]++;
        }

        int arrayIndex = 0;
        for(int i = 0; i < max-min+1; i++) { // if you want to print the sorted array in descending order // for(int i = max-min;i>=0;i--) and everyhing will be same
            while (countArray[i] > 0) {
                arr[arrayIndex] = i+min;
                countArray[i]--;
                arrayIndex++;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
        System.out.println(Arrays.toString(arr));
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
// this algo is not sufficient for thousands or more length, you need to look for advcd algo which is Radix sort
// TC O(n+k)
//SC O(n+k)
