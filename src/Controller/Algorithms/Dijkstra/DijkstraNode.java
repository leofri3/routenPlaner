package Controller.Algorithms.Dijkstra;

import Model.Objects.Node;

public class DijkstraNode {
  private Node node;
  private float cost;
  private boolean visited;
  private DijkstraNode predecessor;

  public DijkstraNode(Node node, float cost) {
    this.node = node;
    this.cost = cost;
    this.visited = false;
  }

  public Node getNode() {
    return node;
  }

  public float getCost() {
    return cost;
  }

  public boolean isVisited() {
    return visited;
  }

  public DijkstraNode getPredecessor() {
    return predecessor;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public void setVisited(boolean visited) {
    this.visited = visited;
  }

  public void setPredecessor(DijkstraNode predecessor) {
    this.predecessor = predecessor;
  }
}
