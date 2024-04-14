package HW.HW12;

import java.util.ArrayList;
import java.util.Arrays;

public class HW12 {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        Boolean[] supplied = new Boolean[n];
        Arrays.fill(supplied, false);
        int cost = 0;
        ArrayList<int[]> sortedPipes = new ArrayList<>();
        outer:
        for (int i = 0; i < n; i++) {
            for (int[] pipe : pipes) {
                if ((pipe[0] == i+1 || pipe[1] == i+1) && pipe[2] < wells[i]) {
                    continue outer;
                }
            }
            cost += wells[i];
            supplied[i] = true;
            addConnectedPipes(i+1, pipes, supplied, sortedPipes);
        }       
        while (Arrays.asList(supplied).contains(false)) {
            if (sortedPipes.isEmpty()) {
                int minWell = -1;
                for (int i = 0; i < supplied.length; i++) {
                    if (!supplied[i] && (minWell == -1 || wells[i] < wells[minWell])) {
                        minWell = i;
                    }
                }
                cost += wells[minWell];
                supplied[minWell] = true;
                addConnectedPipes(minWell+1, pipes, supplied, sortedPipes);
                continue;
            }
            int[] pipe = sortedPipes.remove(0);
            if (supplied[pipe[0]-1] && supplied[pipe[1]-1]) continue;
            cost += pipe[2];
            if (supplied[pipe[0]-1]) {
                supplied[pipe[1]-1] = true;
                addConnectedPipes(pipe[1], pipes, supplied, sortedPipes);
            } else {
                supplied[pipe[0]-1] = true;
                addConnectedPipes(pipe[0], pipes, supplied, sortedPipes);
            }
        }
        return cost;
    }
    private void addConnectedPipes(int house, int[][] pipes, Boolean[] supplied, ArrayList<int[]> sortedPipes) {
        for (int[] pipe : pipes) {
            if (pipe[0] == house && !supplied[pipe[1]-1] || pipe[1] == house && !supplied[pipe[0]-1]) {
                if (sortedPipes.isEmpty() || pipe[2] > sortedPipes.get(sortedPipes.size()-1)[2]) {
                    sortedPipes.add(pipe);
                    continue;
                }
                for (int j = 0; j < sortedPipes.size(); j++) {
                    if (pipe[2] < sortedPipes.get(j)[2]) {
                        sortedPipes.add(j, pipe);
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        HW12 tester = new HW12();
        int[] wells = {1, 2};
        int[][] pipes = {{1, 2, 1}, {1, 2, 2}};
        System.out.println(tester.minCostToSupplyWater(2, wells, pipes));
        int[] wells2 = {5, 4, 1};
        int[][] pipes2 = {{1, 2, 1}, {1, 2, 2}};
        System.out.println(tester.minCostToSupplyWater(3, wells2, pipes2));
        int[] wells3 = {0, 10, 10, 10, 10, 10, 10};
        int[][] pipes3 = {{1, 2, 2}, {1, 4, 5}, {1, 5, 8}, {1, 7, 9}, {7, 5, 15}, {6, 4, 4}, {6, 3, 6}, {5, 2, 2}, {2, 3, 2}, {3, 4, 2}};
        System.out.println(tester.minCostToSupplyWater(7, wells3, pipes3));
    }
}
