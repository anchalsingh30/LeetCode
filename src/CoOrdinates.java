public class CoOrdinates {
    //check whether the given Long and Langi => [10, 20] are valid or not
    int posLongitude = 90;
    int negLongitude = -90;

    int posLangitude = 180;
    int negLangitude = -180;
    public boolean validCoordinates(int[] arr) {

        //edge cases [0,0]=T, [-90,-90]=T, [90,90]=T, [-180, -180]=F, [180, 180]=F
        if(negLongitude <= arr[0] && arr[0] <= posLongitude) {
            return negLangitude <= arr[1] && arr[1] <= posLangitude; // if condition under if() : it means if both conditions are true return true
        }
        return false;
    }
    public static void main(String[] args) {
        CoOrdinates co = new CoOrdinates();
     int[] arr = {10,20}; //[long, langi]
        System.out.println("Given coordinates are : " + co.validCoordinates(arr));
    }
}

// TC - O()
// SC - O()