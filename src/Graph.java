import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    private HashMap<String, ArrayList<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Add a campus location
    public void addLocation(String location) {

        if (adjacencyList.containsKey(location)) {
            System.out.println("Location already exists.");
            return;
        }

        adjacencyList.put(location, new ArrayList<>());

        System.out.println("Location added successfully.");
    }

    // Remove a campus location
    public void removeLocation(String location) {

        if (!adjacencyList.containsKey(location)) {
            System.out.println("Location not found.");
            return;
        }

        adjacencyList.remove(location);

        // Remove this location from other connections
        for (ArrayList<String> connections : adjacencyList.values()) {
            connections.remove(location);
        }

        System.out.println("Location removed successfully.");
    }

    // Add a connection between two locations
    public void addConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {

            System.out.println("One or both locations do not exist.");
            return;
        }

        if (location1.equals(location2)) {
            System.out.println("A location cannot connect to itself.");
            return;
        }

        if (adjacencyList.get(location1).contains(location2)) {
            System.out.println("Connection already exists.");
            return;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        System.out.println("Connection added successfully.");
    }

    // Remove a connection
    public void removeConnection(String location1, String location2) {

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {

            System.out.println("One or both locations do not exist.");
            return;
        }

        adjacencyList.get(location1).remove(location2);
        adjacencyList.get(location2).remove(location1);

        System.out.println("Connection removed successfully.");
    }

    // Display all campus connections
    public void displayConnections() {

        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations found.");
            return;
        }

        System.out.println("Campus Connections:");

        for (String location : adjacencyList.keySet()) {

            System.out.print(location + " -> ");

            ArrayList<String> connections =
                    adjacencyList.get(location);

            if (connections.isEmpty()) {
                System.out.println("No connections");
            } else {
                System.out.println(String.join(", ", connections));
            }
        }
    }

    // Breadth-First Search
    public void BFS(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        ArrayList<String> visited = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(startLocation);
        visited.add(startLocation);

        System.out.println("BFS Traversal:");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.println(current);

            for (String neighbour : adjacencyList.get(current)) {

                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    // Depth-First Search
    public void DFS(String startLocation) {

        if (!adjacencyList.containsKey(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        ArrayList<String> visited = new ArrayList<>();

        System.out.println("DFS Traversal:");

        DFSRecursive(startLocation, visited);
    }

    private void DFSRecursive(
            String location,
            ArrayList<String> visited) {

        visited.add(location);

        System.out.println(location);

        for (String neighbour : adjacencyList.get(location)) {

            if (!visited.contains(neighbour)) {
                DFSRecursive(neighbour, visited);
            }
        }
    }
}