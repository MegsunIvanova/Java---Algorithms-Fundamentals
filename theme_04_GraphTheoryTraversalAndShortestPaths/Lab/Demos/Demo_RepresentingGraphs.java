package theme_04_GraphTheoryTraversalAndShortestPaths.Lab.Demos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Demo_RepresentingGraphs {
    public static void main(String[] args) {

        //Adjacency List:

        List<List<Integer>> graph = new ArrayList<>();

        //adding 10 nodes
        for (int i = 0; i < 10 + 1; i++) {
            graph.add(new ArrayList<>());
        }

        graph.get(1).addAll(Arrays.asList(9, 8, 5));//adding path from node 1 to nodes 5,8,9
        graph.get(2).add(10);//adding path from node 2 to node 10
        graph.get(3).add(1);//adding path from node 3 to node 1
        graph.get(5).add(1);//adding path from node 5 to node 1
        graph.get(8).add(1);//adding path from node 8 to node 1
        graph.get(9).add(1);//adding path from node 9 to node 1

        for (Integer child : graph.get(1)) {
            System.out.println(child);
        }

        //Adjacency Matrix:
        int nodes = 10;
        int[][] graphMatrix = new int[nodes + 1][nodes + 1];

        //3 -> 6
        graphMatrix[3][6] = 1;

        graphMatrix[10][10] = 1;


        //Matrix of weight:
        int[][] graphMatrixOfWeight = new int[3][3];
        graphMatrixOfWeight[1][2] = 12;

        //Representation with classes:
        //1 -> 2, 3, 4, 5, 6
        List<Edge> graphRepresentation1 = new ArrayList<>();
        graphRepresentation1.add(new Edge(1, 2));
        graphRepresentation1.add(new Edge(1, 3));
        graphRepresentation1.add(new Edge(1, 4));
        graphRepresentation1.add(new Edge(1, 5));
        graphRepresentation1.add(new Edge(1, 6));

        Graph graphRepresentation2 = new Graph(1);
        graphRepresentation2.edges.add(new Edge(1, 2));

    }

}
