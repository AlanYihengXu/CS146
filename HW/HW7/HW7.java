package HW.HW7;

import java.util.ArrayList;

public class HW7 {
    public int minMeetingRooms(int[][] intervals) {  
        ArrayList<Integer> endTimes = new ArrayList<>();
        outer:
        for (int[] interval : intervals) {
            for (int i = 0; i < endTimes.size(); i++) {
                if (endTimes.get(i) <= interval[0]) {
                    endTimes.set(i, interval[1]);
                    continue outer;
                }
            }
            endTimes.add(interval[1]);
        }
        return endTimes.size();
    }

    public static void main(String[] args) {
        HW7 tester = new HW7();
        int[][] test1 = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(tester.minMeetingRooms(test1));
        int[][] test2 = {{0, 1}, {1, 2}, {2, 3}};
        System.out.println(tester.minMeetingRooms(test2));
    }
}
