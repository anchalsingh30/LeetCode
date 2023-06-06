package DFS;

import java.util.ArrayList;

public class AllPathsSourceTarget {
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
        public static void printAllPaths(ArrayList<Edge>[] graph, boolean vis[], int curr, String path, int target) {
            // base case
            if(curr == target) { //0,1,3,4,5//0,2,4
                System.out.println(path); //01345//0135//02435//0245
                return;
            }
            for(int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i); //1,0,3,1,4,2,0,3// 5//2
                if(!vis[e.dest]) {
                    vis[curr] = true; //0,1,3,4,//3
                    printAllPaths(graph, vis, e.dest, path + e.dest, target);//1 //0134//01342//01345
                    vis[curr] = false; //5,4,3,2 //everything will reset to false adtr 2nd path// //set visited ele to false so that next path can be made by visiting the same ele
                }
            }
        }

    public static void main(String[] args){
                int V = 7;
/*
            1---3
        /       |   \
        0       |    5 -- 6
        \       |   /
          2 --- 4
 */
                ArrayList<Edge>[] graph = new ArrayList[V];
                createGraph(graph);
                int src = 0, target = 5;
                printAllPaths(graph, new boolean[V], src, "0", target);
            }
}

