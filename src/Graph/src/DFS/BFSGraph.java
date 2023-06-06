package DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSGraph {
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

    public static void bfs(ArrayList<Edge>[] graph, int V) {
        /* steps for bfs
        1. print current value from queue
        2. set visited ele to true
        3. add its neighbours
         */
        //create a queue
        Queue<Integer> q = new LinkedList<>();
        boolean[] visitedEle = new boolean[V]; // length of vertices
        q.add(0); // at this point you can add any ele/vertex/node from graph because does not have any root node

        while(!q.isEmpty()){ //q=0//1,2//3//4/5
            int curr = q.remove(); //0//1//2//3//0//4//1//4//5
            if(!visitedEle[curr]) { //visitedEle is false? // already vis = 0,0,1,4,2,3,5,3,4,5==true
                System.out.print(curr+" "); //0,1,2,3,4,5,6
                visitedEle[curr] = true; // [T,T,T,T,T,T,T] -> vis array will take care of visited ele in q

                for(int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i); // give the edge
                    q.add(e.dest); //1,2/0,3/0,4/1,4,5/2,3,5/3,4,6  add its neighbours
                }
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
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph,V);
    }
}
// TC = O(V+E)