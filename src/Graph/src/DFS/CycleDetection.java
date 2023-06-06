package DFS;

import java.util.ArrayList;

// to detect a cycle from a directed and undirected graph
public class CycleDetection {
    public static class Edge {
        int source;
        int dest;

        public Edge(int s, int d) {
            this.source = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean vis[], int curr, boolean recStack[]) {
        vis[curr] = true;
        recStack[curr] = true;

        for(int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(recStack[e.dest]) {
                return true; // cycle detected
            } else if(!vis[e.dest]) {
                if(isCycleDirected(graph, vis, e.dest, recStack)) {
                    return true; // suppose if a neighbr has a cycle from its vertex then it will also return true
                }
            }
        }
        recStack[curr] = false;
        return false;

    }


    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V]; // array of arraylist
        createGraph(graph);
        boolean[] vis = new boolean[V];
        boolean[] recStack =  new boolean[V];
        System.out.println(isCycleDirected(graph, vis, 0, recStack));


        //for the disconnect cycle detection graph
//        for(int i = 0; i < V; i++) {
//            if(!vis[i]) {
//                boolean isCycle = isCycleDirected(graph, vis, i, recStack);
//                if(isCycle) {
//                    System.out.println(isCycle);
//                    break;
//                }
//            }
//        }

    }
}
