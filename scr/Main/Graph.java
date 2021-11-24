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
            List<Edge> edges = new ArrayList<>(List.of());
            for(int i = 0; i<15;i++){
                for(int j = 0; j<15; j++){
                    if(relationship[i][j] == 1)
                        edges.add(new Edge(i, j, Edge.getWeight(i,j,0)));
                }
            }
        return edges;
        }
        private static int getWeight(int src, int dest , int delay) throws Exception {
            // Get city's names
            String origin = cities.get(src);
            String destination = cities.get(dest);

            //Get distance
            float distance = DistancieApis.getData(origin + "CostaRica",destination + "CostaRica");
//            System.out.println("La distancia es:");
//            System.out.println(distance);

            // Conversion to time
            float time = distance/80;

            // conversion to minutes
            float timeMinutes = time*60;
//            System.out.println("El tiempo en min es : " + timeMinutes);

            // create weight

            return Math.round(timeMinutes) + delay;
        }
        public static String getName(int scr){
            return cities.get(scr);
        }
        public static int getCode(String Name){
            return cities.indexOf(Name);
        }
    }
    // Graph class
    class Graph {
        // node of adjacency list
        static class Node {
            int value, weight;
            String name;
            Node(int value, int weight)  {
                this.value = value;
                this.name = Edge.getName(value);
                this.weight = weight;
            }
        }

// define adjacency list

        List<List<Node>> adj_list = new ArrayList<>();

        // Atributes


        //Graph Constructor
        public Graph(List<Edge> edges)
        {


            // adjacency list memory allocation
            for (int i = 0; i < 15; i++)
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
                System.out.print("Vertex:" + src_vertex);
                for (Node edge : graph.adj_list.get(src_vertex)) {
                    System.out.print(" from: "+ Edge.getName(src_vertex) + " to: " + edge.name + " peso: " + edge.weight + " \t");
                }

                System.out.println();
                src_vertex++;
            }
        }

        private int coWeight(int index, int CO){

            for(int i = 0; i < adj_list.get(index).size(); i++){
                if(adj_list.get(index).get(i).value == CO)
                    return adj_list.get(index).get(i).weight;
            }
            return 0;

        }
        private int coNextValue(int index, int CO){

            for(int i = 0; i < adj_list.get(index).size()-1; i++){
                if(adj_list.get(index).get(i).value == CO)
                    return adj_list.get(index).get(i+1).value;
            }
            return -1;

        }


        public String[] dijkStra(int index, int end, int delay){


            int CO;
            int headIndex = index;
            float[] distance = new float[15];
            for (int i = 0; i < 15 ; i++) {
                distance[i] = Float.POSITIVE_INFINITY;
            }

            String[] path = new String[15];
            for (int i = 0; i < 15 ; i++) {
                path[i] = "";
            }
            boolean[] isVisited = new boolean[16];


            distance[index]=0;


            while (!isVisited[headIndex]){

                // CO es la primera CO que no ha sido visitada
                CO = adj_list.get(headIndex).get(0).value;
                while(isVisited[CO]){
                    CO = coNextValue(headIndex, CO);
                    if (CO == -1) break;
                }

                if (CO==-1) {
                    isVisited[headIndex]=true;
                    //System.out.println("Coordinate not found ");
                }
                else {
                    while (!isVisited[CO]) {
                        isVisited[headIndex]=true;
                        float currentDis = distance[headIndex] + coWeight(headIndex,CO) + delay;
                        if (currentDis<distance[CO]) {
                            distance[CO] = currentDis;

                            path[CO] = path[headIndex]+" "+Edge.getName(headIndex);
                        }
                        CO = coNextValue(headIndex, CO);
                        if (CO == -1)
                            break;

                    }
                }

                headIndex = indexGet(distance,isVisited);


            }
            for (int i = 0; i <15 ; i++) {
                path[i] = path[i]+" "+Edge.getName(i);
            }
 //           System.out.println("Iniciar nodo:"+Edge.getName(index));
//            for (int i = 0; i <15 ; i++) {
                System.out.println(Edge.getName(end)+"   "+distance[end]+"   "+path[end]);
//            }
            return new String[]{Edge.getName(end), String.valueOf(distance[end]), path[end]};


        }
        public int indexGet(float[] distance, boolean[] isVisited){
            int j=0;
            double mindis=Double.POSITIVE_INFINITY;
            for (int i = 0; i < distance.length; i++) {
                if (!isVisited[i]){
                    if(distance[i]<mindis){
                        mindis=distance[i];
                        j=i;
                    }
                }
            }
            return j;
        }
    }

//    class Main{
//        public static void main (String[] args) throws Exception {
//
//            // call graph class Constructor to construct a graph
//            Graph graph = new Graph(Edge.createEdgeList());
//
//            // print the graph as an adjacency list
//            System.out.println(graph.adj_list.get(1).get(2).value);
//            System.out.println(graph.dijkStra(0, 4)[1]);
//            //Graph.printGraph(graph);
//        }
//    }


