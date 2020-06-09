package Controller.Algorithms;

import Model.Objects.Edge;
import Model.Objects.Node;
import java.util.ArrayList;

public interface Algorithm {

  public void setStartNode(Node startNode);

  public void setDestinationNode(Node destinationNode);

  public ArrayList<Node> getRouteNodes();

  public ArrayList<Edge> getRouteEdges();

  public ArrayList<Object> getRoute();

  public void startAlgorithm();
}
