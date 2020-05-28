package Model;

import Model.Objects.Edge;
import Model.Objects.Node;

import java.util.HashSet;

public class Storage {
    private HashSet<Node> nodes = new HashSet<>();
    private HashSet<Edge> edges = new HashSet<>();

    public HashSet<Node> getNodes() {
        return nodes;
    }

    public HashSet<Edge> getEdges() {
        return edges;
    }

    public Node getNodeByName(String name) {
        for (Node node : nodes) {
            if (node.getId().equalsIgnoreCase(name)) {
                return node;
            }
        }
        return null;
    }

    public Edge getEdgeByName(String name) {
        for (Edge edge : edges) {
            if (edge.getName().equalsIgnoreCase(name)) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "nodes=" + nodes.toString() +
                ", edges=" + edges.toString() +
                '}';
    }
}
