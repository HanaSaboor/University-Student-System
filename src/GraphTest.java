public class GraphTest {

    public static void main(String[] args) {

        Graph graph = new Graph();

        // Add campus locations
        graph.addLocation("Main Gate");
        graph.addLocation("Library");
        graph.addLocation("Cafeteria");
        graph.addLocation("Computer Lab");

        // Add connections
        graph.addConnection("Main Gate", "Library");
        graph.addConnection("Main Gate", "Computer Lab");
        graph.addConnection("Library", "Cafeteria");
        graph.addConnection("Library", "Computer Lab");

        // Display connections
        System.out.println();
        graph.displayConnections();

        // BFS
        System.out.println();
        graph.BFS("Main Gate");

        // DFS
        System.out.println();
        graph.DFS("Main Gate");
    }
}