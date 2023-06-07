package theme_04_GraphTheoryTraversalAndShortestPaths.Lab.Demos;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public int source;
    public List<Edge> edges;

    public Graph(int source) {
        this.source = source;
        this.edges = new ArrayList<>();
    }
}
