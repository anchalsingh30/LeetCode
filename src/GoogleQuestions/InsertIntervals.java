package GoogleQuestions;

import java.util.*;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if ((intervals.length == 0 || Objects.isNull(intervals)) && newInterval.length != 0)
            return new int[][]{newInterval};

        List<int[]> result = new ArrayList<>();
        int i = 0;

        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0] ); //1
            newInterval[1] = Math.max(newInterval[1], intervals[i][1] ); //5
            i++; //1
        }
        result.add(newInterval); //at result[0]: [1,5] so size is 1

        // It iterates through the remaining intervals starting from the index i and adds them one by one.
        while (i < intervals.length) { //i=1
            result.add(intervals[i]); // at intervals[1] -> [6,9]
            i++;
        }

        return result.toArray(new int[result.size()][]); // result size = 2//convert list to 2D array
    }
    public static void main(String[] args) {
        InsertIntervals in = new InsertIntervals();
        int[][] intervals = {{1,3},{6,9}};
        int[] newIntervals = {2,5};
        int[][] res = in.insert(intervals, newIntervals);
        for(int[] input : res) {
            System.out.println(Arrays.toString(input));
        }
    }
}
