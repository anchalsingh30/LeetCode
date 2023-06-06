public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // 8, 2
        int i = low - 1; //-1,-1,0// assume there no smaller ele from pivot, 'i' will keep track of smaller ele from pivot

        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                i++; //0,1,2,3
                //swap
                int temp = arr[i]; // temp: 6,3,9,
                arr[i] = arr[j];//6,3,5,2
                arr[j] = temp; // 6,3,9,9[6,3,5,2,9,8]
            }
        }
        // for larger ele
        i++; // 4,0,2
        int temp = arr[i]; //9,6
        arr[i] = pivot;//= arr[high] //2
        arr[high] = temp; // 9, [6,3,5,2,8,9]// 6

        return i; //4,0,3 pivot index
    }
    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) { //0-5 // 0-3 // 0 - (-1) // for large ele 1-3
            int pindx = partition(arr, low, high); // 4,0,3

            // will call quickSort again to sort/partition for smaller and larger elements in the array
            quickSort(arr, low, pindx - 1); //4-1=3-> it will sor [6,3,5,2,8,9]// // for smaller elements
            quickSort(arr, pindx + 1, high); //pindx =0+1,high=3 for larger elements

        }
    }
    public static void main(String[] args) {

        int[] arr = {6, 3, 9, 5, 2, 8};
        int n = arr.length;
        quickSort(arr, 0, n - 1);

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i]+" ");
        }
    }
}
//TC - O(nlog(n))- worst -> O(n^2)
//SC - worst-O(log n)