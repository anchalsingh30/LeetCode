package GoogleQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        // Sort the intervals based on the start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // Use a min heap (priority queue) to track the end times of the ongoing meetings
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(intervals[0][1]);

        for(int i = 1; i < intervals.length; i++) {
            // If the current meeting can be accommodated in an existing room,
            // remove the meeting with the earliest end time and add the current meeting's end time
            if(intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            // add the current meetings end time in the queue
            queue.offer(intervals[i][1]);
        }
        return queue.size();

    }
    public static void main(String[] args) {
        MeetingRoom m = new MeetingRoom();
        int[][] intervals = {{0,30},{5,10},{15,20}};
        System.out.println(m.minMeetingRooms(intervals));
    }
}
