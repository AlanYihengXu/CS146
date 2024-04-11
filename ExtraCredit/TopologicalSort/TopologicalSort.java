package ExtraCredit.TopologicalSort;

import java.util.ArrayList;
import java.util.LinkedList;

public class TopologicalSort { // Graph representation using 2D ArrayList
    
    private static boolean cyclicCheck(ArrayList<ArrayList<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        outer:
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(0) == null) {
                continue;
            }
            for (int j = 0; j < graph.get(0).size();) {
                stack.push(graph.get(i).get(j));
                break outer;
            }
        }

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            if (visited[current]) return false;
            visited[current] = true;
            for (Integer i : graph.get(current)) {
                stack.push(i);
            }
        }

        return true;
    }
    
    public static LinkedList<Integer> Kahn(ArrayList<ArrayList<Integer>> graph) throws Exception {
        if (!cyclicCheck(graph)) {
            throw new Exception("Graph is not a DAG");
        }
        
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

        return output;
    }

    public static LinkedList<Integer> BFS(ArrayList<ArrayList<Integer>> graph) throws Exception { // Same thing as Kahn's algorithm
        if (!cyclicCheck(graph)) {
            throw new Exception("Graph is not a DAG");
        }
        
        LinkedList<Integer> output = new LinkedList<Integer>();

        return output;
    }

    public static LinkedList<Integer> DFS(ArrayList<ArrayList<Integer>> graph) throws Exception {
        if (!cyclicCheck(graph)) {
            throw new Exception("Graph is not a DAG");
        }
        
        LinkedList<Integer> output = new LinkedList<Integer>();

        return output;
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
    }
}
