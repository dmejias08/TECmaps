package Main;
import java.util.*;

    //class to store edges of the weighted graph
    class Edge {
        int src, dest, weight;
        public static final List<String> cities = Arrays.asList("Quebradilla","Tejar", "Cartago", "Paraiso","Turrialba", "Ochomogo", "TresRios", "Curridabat", "Desamparados", "SanPedro", "SanJose", "SantaAna","CiudadColon", "Alajuela", "Heredia");
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public static List<Edge> createEdgeList() throws Exception {
            int[][] relationship =
                    //       0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14
                    {       {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //0
                            {1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
                            {0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //2
                            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //3
                            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
                            {0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, //5
                            {0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0}, //6
                            {0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0}, //7
                            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0}, //8
                            {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}, //9
                            {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1}, //10
                            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0}, //11
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, //12
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1}, //13
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0}, //14
                    };
            List<Edge> edges = new ArrayList<Edge>(List.of());
            for(int i = 0; i<15;i++){
                for(int j = 0; j<15; j++){
                    if(relationship[i][j] == 1)
                        edges.add(new Edge(i, j, getWeight(i,j,10)));
                }
            }
        return edges;
        }
        public static int getWeight(int src, int dest , int delay) throws Exception {
            // Get city's names
            String origin = cities.get(src);
            String destination = cities.get(dest);

            //Get distance
            float distance = DistancieApis.getData(origin,destination);

            // Conversion to time
            float time = distance/80;

            // conversion to minutes
            float timeMinutes = time/60;

            // create weight
            int weight = Math.round(timeMinutes) + delay;

            return weight;
        }
    }
    // Graph class
    class Graph {
        // node of adjacency list
        static class Node {
            int value, weight;
            Node(int value, int weight)  {
                this.value = value;
                this.weight = weight;
            }
        };

// define adjacency list

        List<List<Node>> adj_list = new ArrayList<>();

        //Graph Constructor
        public Graph(List<Edge> edges)
        {
            // adjacency list memory allocation
            for (int i = 0; i < edges.size(); i++)
                adj_list.add(i, new ArrayList<>());

            // add edges to the graph
            for (Edge e : edges)
            {
                // allocate new node in adjacency List from src to dest
                adj_list.get(e.src).add(new Node(e.dest, e.weight));
            }
        }
        // print adjacency list for the graph
        public static void printGraph(Graph graph)  {
            int src_vertex = 0;
            int list_size = graph.adj_list.size();

            System.out.println("The contents of the graph:");
            while (src_vertex < list_size) {
                //traverse through the adjacency list and print the edges
                for (Node edge : graph.adj_list.get(src_vertex)) {
                    System.out.print("Vertex:" + src_vertex + " ==> " + edge.value +
                            " (" + edge.weight + ")\t");
                }

                System.out.println();
                src_vertex++;
            }
        }
    }
    class Main{
        public static void main (String[] args) {
            // define edges of the graph
            List<Edge> edges = Arrays.asList(new Edge(0, 1, 2),new Edge(0, 2, 4),
                    new Edge(1, 2, 4),new Edge(2, 0, 5), new Edge(2, 1, 4),
                    new Edge(3, 2, 3), new Edge(4, 5, 1),new Edge(5, 4, 3));

            // call graph class Constructor to construct a graph
            Graph graph = new Graph(edges);

            // print the graph as an adjacency list
            Graph.printGraph(graph);
        }
    }

