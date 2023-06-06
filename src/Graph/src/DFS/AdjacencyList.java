package DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdjacencyList {
    public static class Edge {
        int source;
        int dest;
        int weight;

        public Edge(int s, int d, int w) {
            this.source = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        // Create an empty arraylist at each index of graph[] array, because initially array will be having null
        // and we can't add edges when array index is null it will throw a NullPointerException error
         for(int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
         // now start adding edges at graph[]index
        graph[0].add(new Edge(0,2, 2));

        graph[1].add(new Edge(1,2, 10));
        graph[1].add(new Edge(1,3, 0));

        graph[2].add(new Edge(2,0, 2));
        graph[2].add(new Edge(2,1, 10));
        graph[2].add(new Edge(2,3, -1));

        graph[3].add(new Edge(3,1, 0));
        graph[3].add(new Edge(3,2, -1));
    }

    public static void main(String[] args) {
        int V = 4; // no. of vertcies in a graph
        ArrayList<Edge> graph[] = new ArrayList[V]; // created array of arraylist of size vertices
        createGraph(graph);

        //find out neighbours of any Vertices, graph's index at 2's neighbours. You can find the nghbrs for all vertices 0,1,2,3
        for(int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i); // storing neighbours
            System.out.println("Printing the destination of graph 2's index neighbours :" + e.dest+ " and its weight is : "+ e.weight);
        }

    }
}
// TC = O(x)  x no. of neighbours