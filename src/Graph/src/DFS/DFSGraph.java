package DFS;

import java.util.ArrayList;

public class DFSGraph {
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
                graph[i] = new ArrayList<Edge>(); // creating an empty arraylist at each index in array of graph
            }
            // now start adding edges at graph[]index
            graph[0].add(new Edge(0,1));
            graph[0].add(new Edge(0,2));

            graph[1].add(new Edge(1,0));
            graph[1].add(new Edge(1,3));

            graph[2].add(new Edge(2,0));
            graph[2].add(new Edge(2,4));

            graph[3].add(new Edge(3,1));
            graph[3].add(new Edge(3,4));
            graph[3].add(new Edge(3,5));

            graph[4].add(new Edge(4,2));
            graph[4].add(new Edge(4,3));
            graph[4].add(new Edge(4,5));

            graph[5].add(new Edge(5,3));
            graph[5].add(new Edge(5,4));
            graph[5].add(new Edge(5,6));

            graph[5].add(new Edge(5,5));
        }

        public static void dfs(ArrayList<Edge> graph[], int curr, boolean[] visitedEle) {
        /* steps for dfs
        it can also be done using Stack DS

        Using Recursion:
        1. print current value
        2. set visited ele to true
        3. visit curr's neighbours and check if the curr nghbr is visited if not then call recursion
        */
            System.out.print(curr+" "); //0,
            visitedEle[curr] = true; // [T,T,T,T,T,T,T] -> vis array will take care of visited ele in q

            for(int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i); // give the edge
                if (!visitedEle[e.dest]) { // visitedEle[curr] is false
                    dfs(graph, e.dest, visitedEle);
                }
            }
        }

    public static void main(String[] args) {
        int V = 7;
/*
            1 ---- 3
          /       |  \
        0         |    5 -- 6
          \       |  /
            2 --- 4
 */
        ArrayList<Edge> graph[] = new ArrayList[V]; // array of arraylist
        createGraph(graph);
        boolean[] visitedEle = new boolean[V];
        dfs(graph, 0, visitedEle); // 0 is starting
        System.out.println();

    }
}
// TC O(V+E)