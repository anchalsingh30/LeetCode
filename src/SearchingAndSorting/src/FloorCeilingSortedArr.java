public class FloorCeilingSortedArr {
    public static int forCeiling(int[] arr, int x, int low, int high) {

//        int i = low;

//        //if first element in the array is less than x then return first index
//        if(x <= arr[i]) {
//            return i;
//        }
//
//        // if x lies between arr[i] and arr[i+1] including arr[i+1], then return arr[i+1]
//        for(i = low; i < high; i++) {
//
//            if(arr[i] == x) {
//                return i;
//            }
//
//            if( arr[i] < x && arr[i+1] >= x) {
//                return arr[i+1]; // if we need to return floor we will return i here
//            }
//        }

        // Method 2 : Binary search Tree
        int mid = 0;
        while(low <= high) {
            mid = low + (high-low)/2; // 3
            if(x == arr[mid]) {
                return arr[mid];
            }
            else if (x < arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if(low < arr.length) {
            return arr[low];
        }
        return -1;
    }

    public static int forFloor(int[] arr, int x, int low, int high) {
        int mid = 0;

        while (low <= high) {
            mid = low + (high-low)/2;
            if(x == arr[mid]) {
                return arr[mid];
            }
            else if( x < arr[mid]) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        if(high >= 0) {
            return arr[high];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x = 3;
        int n = arr.length;

        System.out.println("Ceiling of "+x+" is "+ forCeiling(arr, x, 0, n-1));
        System.out.println("Ceiling of "+x+" is "+ forFloor(arr, x, 0, n-1));
    }
}
// linear search
// TC O(n)
// SC O(1)

// binary search - better time c
// TC O(log n)
// SC O(1)
