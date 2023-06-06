package GoogleQuestions;

import java.util.HashMap;

//Problem similar to longest substring with most character k = 2
public class FruitBaskets {
    public int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        int i = 0,j = 0;
        while(j < fruits.length) {
            if(map.size() <= 2) { //size=1,2,2
                map.put(fruits[j], j); //map=[1,0][2,1][3,2]//[2,1][3,2]//[2,3][3,2]//[2,4][3,2]
                j++;//j=1,2,3,4,5
            }
            if(map.size() > 2) { //3
                int min = fruits.length - 1; //4
                for(int value : map.values()) { //[[1,0][2,1][3,2][2,3][2,4]]
                    min = Math.min(min, value); //0
                }
                i = min + 1; //1
                map.remove(fruits[min]); // removed=[1,0][3,2]
            }
            max = Math.max(max, j - i); //1,2,3-1,4-1,5-1
        }
        return max; //4
    }
    public static void main(String[] args) {
        FruitBaskets f = new FruitBaskets();
        int[] fruits = {1,2,3,2,2}; //{1,2,3} // {1,2,2} {0,1,2,1}
        System.out.println(f.totalFruit(fruits));
    }
}

//TC = O(n^2) - worst case