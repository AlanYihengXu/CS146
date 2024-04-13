package Labs.Lab6;

import java.util.LinkedList;

public class Lab6 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] canTake = new boolean[numCourses];
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            stack.push(i);
            while (!stack.isEmpty()) {
                int current = stack.pop();
                if (canTake[current]) {
                    visited[current] = true;
                    continue;
                }
                if (visited[current]) return false;
                boolean canTakePrereq = true;
                for (int[] prereq : prerequisites) {
                    if (prereq[0] == current) {
                        canTakePrereq = canTakePrereq && canTake[prereq[1]];
                        stack.push(prereq[1]);
                    }
                }
                canTake[current] = canTakePrereq;
                visited[current] = true;
            }
            canTake[i] = true;
        }
        return true;
    }
    public static void main(String[] args) {
        Lab6 tester = new Lab6();
        int[][] test1 = {{1, 0}};
        System.out.println(tester.canFinish(2, test1));
        int[][] test2 = {{1, 0}, {0, 1}};
        System.out.println(tester.canFinish(2, test2));
        int[][] test3 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        System.out.println(tester.canFinish(4, test3));
        int[][] test4 = {};
        System.out.println(tester.canFinish(1, test4));
    }
}
