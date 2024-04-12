package ExtraCredit.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;

public class TopologicalSort { // Graph representation using 2D ArrayList
    
    public static LinkedList<Integer> Kahn(ArrayList<ArrayList<Integer>> graph) throws Exception {
        LinkedList<Integer> output = new LinkedList<Integer>();

        int[] indegree = new int[graph.size()];
        for (ArrayList<Integer> a : graph) {
            if (a == null) continue;
            for (Integer i : a) {
                indegree[i]++;
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer current = queue.pop();
            if (graph.get(current) == null) continue;
            output.add(current);
            for (Integer i : graph.get(current)) {
                indegree[i]--;
                if (indegree[i] == 0) queue.add(i);
            }
        }

        for (int i : indegree) {
            if (i != 0) throw new Exception("Graph is not a DAG");
        }

        return output;
    }

    public static LinkedList<Integer> BFSApproach(ArrayList<ArrayList<Integer>> graph) throws Exception { // Same thing as Kahn's algorithm
        LinkedList<Integer> output = new LinkedList<Integer>();

        int[] indegree = new int[graph.size()];
        for (ArrayList<Integer> a : graph) {
            if (a == null) continue;
            for (Integer i : a) {
                indegree[i]++;
            }
        }
        
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0) queue.add(i);
        }

        while (!queue.isEmpty()) {
            Integer current = queue.pop();
            if (graph.get(current) == null) continue;
            output.add(current);
            for (Integer i : graph.get(current)) {
                indegree[i]--;
                if (indegree[i] == 0) queue.add(i);
            }
        }

        for (int i : indegree) {
            if (i != 0) throw new Exception("Graph is not a DAG");
        }

        return output;
    }

    public static LinkedList<Integer> DFSApproach(ArrayList<ArrayList<Integer>> graph) throws Exception {
        LinkedList<Integer> output = new LinkedList<Integer>();

        boolean[] added = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i) == null || added[i]) {
                continue;
            }
            boolean[] visited = new boolean[graph.size()];
            if (!DFSRecurse(graph, added, visited, output, i)) throw new Exception("Graph is not a DAG");
        }

        return output;
    }

    private static boolean DFSRecurse(ArrayList<ArrayList<Integer>> graph, boolean[] added, boolean visited[], LinkedList<Integer> output, Integer i) {
        boolean cyclicCheck = true;
        if (visited[i]) cyclicCheck = false;
        visited[i] = true;
        for (Integer j : graph.get(i)) {
            if (!added[j]) {
                cyclicCheck = cyclicCheck && DFSRecurse(graph, added, visited, output, j);
            }
        }
        added[i] = true;
        output.push(i);
        return cyclicCheck;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp;

        // 0 not a value in graph
        graph.add(null);
        // 1: 3
        temp = new ArrayList<Integer>();
        temp.add(3);
        graph.add(temp);
        // 2 : 4
        temp = new ArrayList<Integer>();
        temp.add(4);
        graph.add(temp);
        // 3: 5, 6, 7
        temp = new ArrayList<Integer>();
        temp.add(5);
        temp.add(6);
        temp.add(7);
        graph.add(temp);
        // 4: 5, 6, 7
        temp = new ArrayList<Integer>();
        temp.add(5);
        temp.add(6);
        temp.add(7);
        graph.add(temp);
        // 5: 8
        temp = new ArrayList<Integer>();
        temp.add(8);
        graph.add(temp);
        // 6: 8
        temp = new ArrayList<Integer>();
        temp.add(8);
        graph.add(temp);
        // 7: 8
        temp = new ArrayList<Integer>();
        temp.add(8);
        graph.add(temp);
        // 8:
        graph.add(new ArrayList<Integer>());


        try {
            System.out.println(TopologicalSort.Kahn(graph));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(TopologicalSort.BFSApproach(graph));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(TopologicalSort.DFSApproach(graph));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
