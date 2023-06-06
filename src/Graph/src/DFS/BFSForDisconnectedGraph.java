package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSForDisconnectedGraph {
        public static class Edge {
            int source;
            int dest;

            public Edge(int s, int d) {
                this.source = s;
                this.dest = d;
            }
        }

        public static void createGraph(ArrayList<Edge> graph[]) {
            // Create an empty arraylist at each index of graph[] array, because initially array will be having null
            // and we can't add edges when array index is null it will throw a NullPointerException error
            for(int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<Edge>();
            }
            // now start adding edges at graph[]index
            graph[0].add(new Edge(0,1));

            graph[1].add(new Edge(1,2));

            graph[3].add(new Edge(3,4));

            graph[4].add(new Edge(4,5));

            graph[5].add(new Edge(5,6));

        }

        public static void bfs(ArrayList<Edge> graph[], int V, boolean[] visitedEle, int start ) {
        /* steps for bfs
        1. print current value from queue
        2. set visited ele to true
        3. add its neighbours
         */
            //create a queue
            Queue<Integer> q = new LinkedList<>();
            q.add(start); // at this point you can add any ele/vertex/node from graph because does not have any root node

            while (!q.isEmpty()) { // loop gets exit after ele 2 bcz it has no nghbrs// loop start again with ele 3
                int curr = q.remove();
                if (!visitedEle[curr]) { //visitedEle[curr] is false //[F,]
                    System.out.print(curr + " "); //0,1,2,3,4,5,6
                    visitedEle[curr] = true; // [T,T,T,T,T,T,T] -> vis array will take care of visited ele in q

                    for (int i = 0; i < graph[curr].size(); i++) {
                        Edge e = graph[curr].get(i); // give the edge
                        q.add(e.dest); //1, 2-> no nghbr/ 4,5,6  add its neighbours
                    }
                }
            }
        }
    public static void main(String[] args) {
        int V = 7;
        /*
                    0 --- 1 --- 2

                    3 ---- 4 --- 5 --- 6
         */
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        boolean[] visitedEle = new boolean[V];
        for(int i = 0; i < V; i++) { // visiting all disconnected vertices, V=7, first loop through i=0-2 and second loop through i=3-6
            if(!visitedEle[i]) { //visitedEle[i]== false
                bfs(graph,V, visitedEle, i); // i is start
            }
        }
        System.out.println();
    }
}
// TC O(V+E)