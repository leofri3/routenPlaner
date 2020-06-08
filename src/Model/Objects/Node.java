package Model.Objects;

import java.util.ArrayList;

public class Node {

  private String id;

  private float lat;
  private float lon;

  private ArrayList<Edge> outgoingEdges = new ArrayList<>(); //all outgoing edges from this node
  private ArrayList<Edge> incomingEdges = new ArrayList<>(); //all incoming edges from this node

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
        ", outgoingEdges=" + outgoingEdges +
        ", incomingEdges=" + incomingEdges +
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

  public ArrayList<Edge> getOutgoingEdges() {
    return outgoingEdges;
  }

  public ArrayList<Edge> getIncomingEdges() {
    return incomingEdges;
  }

}
