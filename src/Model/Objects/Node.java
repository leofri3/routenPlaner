package Model.Objects;

import java.util.HashSet;

public class Node {

  private String id;

  private float lat;
  private float lon;

  private HashSet<Edge> edges = new HashSet<>(); //all edges from this node

  public Node(String id, float lat, float lon) {
    this.id = id;
    this.lat = lat;
    this.lon = lon;
  }

  @Override
  public String toString() {
    return "Node{" +
        "id='" + id + '\'' +
        ", lat=" + lat +
        ", lon=" + lon +
        ", edges=" + edges +
        '}';
  }

  public String getId() {
    return id;
  }

  public float getLat() {
    return lat;
  }

  public float getLon() {
    return lon;
  }

  public HashSet<Edge> getEdges() {
    return edges;
  }
}
