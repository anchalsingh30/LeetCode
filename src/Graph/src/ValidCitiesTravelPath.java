import java.util.*;

public class ValidCitiesTravelPath {
    //Interview Question from People10 Technologies
    /* A graph traversal question
    Various travel paths are available as origin and destination string pairs
    (ex. {"Mangalore", "Bangalore"}, {"Bangalore", "Chennai"}, {"Chennai", "Bhubaneshwar"})
    find if the given paths help us to realize a travel route as Good (ex. "Mangalore", "Chennai")
    or Bad (ex. "Patna", "Mumbai" )?
     */

        public static boolean checkRouteValidity(String[] route, String[][] paths) {
            Map<String, List<String>> graph = buildGraph(paths);
            Set<String> visited = new HashSet<>();
            return isRouteValid(route[0], route[1], graph, visited);
        }

        public static Map<String, List<String>> buildGraph(String[][] paths) {
            Map<String, List<String>> graph = new HashMap<>();

            // Build the graph using the origin-destination pairs
            for (String[] path : paths) {
                String origin = path[0];
                String destination = path[1];

                // Add the origin and destination to the graph
                graph.putIfAbsent(origin, new ArrayList<>());
                graph.putIfAbsent(destination, new ArrayList<>());

                // Add the destination as a neighbor of the origin
                graph.get(origin).add(destination);
            }

            return graph;
        }

        public static boolean isRouteValid(String source, String destination, Map<String, List<String>> graph, Set<String> visited) {
            // Base case: If source and destination are the same, the route is valid
            if (source.equals(destination)) {
                return true;
            }

            visited.add(source);

            // Recursively check if a valid route exists from each neighbor of the source
            if (graph.containsKey(source)) {
                for (String neighbor : graph.get(source)) {
                    if (!visited.contains(neighbor) && isRouteValid(neighbor, destination, graph, visited)) {
                        return true;
                    }
                }
            }

            visited.remove(source);

            return false;
        }

    public static void main(String[] args) {
        // Define the paths as origin and destination string pairs
        String[][] paths = {
                {"Mangalore", "Bangalore"},
                {"Bangalore", "Chennai"},
                {"Mumbai", "Bhubaneshwar"}
        };

        // Test cases
        String[] goodRoute = {"Mangalore", "Bhubaneshwar"};
        String[] badRoute = {"Patna", "Mumbai"};

        // Check if the good route is valid
        boolean isGoodRoute = checkRouteValidity(goodRoute, paths); // true
        System.out.println("Is the good route valid? " + isGoodRoute); // true

        // Check if the bad route is valid
        boolean isBadRoute = checkRouteValidity(badRoute, paths); // false
        System.out.println("Is the bad route valid? " + isBadRoute); // false
        }

}
