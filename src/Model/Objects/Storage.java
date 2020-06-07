package Model.Objects;

import Model.Objects.Edge;
import Model.Objects.Node;
import java.util.ArrayList;

public class Storage {

  private ArrayList<Node> nodes = new ArrayList<>();
  private ArrayList<Edge> edges = new ArrayList<>();

  public ArrayList<Node> getNodes() {
    return nodes;
  }

  public ArrayList<Edge> getEdges() {
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
