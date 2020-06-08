package Controller;

import Controller.Algorithms.Dijkstra.Dijkstra;
import Model.ConnectionToController.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.ConnectionToModel.ViewToModel;
import java.util.ArrayList;

public class AlgorithmStarter {
  private ModelToController modelToController = new ModelToController();
  private ViewToModel viewToModel = new ViewToModel();
  private ArrayList<Node> routeNodes;
  private ArrayList<Edge> routeEdges;
  private ArrayList<Object> route;
  private String algorithm;
  private String startNodeID;
  private String destinationNodeID;

  public ArrayList<Node> getRouteNodes() {
    return routeNodes;
  }

  public ArrayList<Edge> getRouteEdges() {
    return routeEdges;
  }

  public ArrayList getRoute() {
    return route;
  }

  public void setStartNodeID(String startNodeID) {
    this.startNodeID = startNodeID;
  }

  public void setDestinationNodeID(String destinationNodeID) {
    this.destinationNodeID = destinationNodeID;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  private void dijkstraAlgorithm() {
    Dijkstra dijkstra = new Dijkstra(modelToController);
    dijkstra.setStartNode(modelToController.getNodeByName(startNodeID));
    dijkstra.setDestinationNode(modelToController.getNodeByName(destinationNodeID));
    dijkstra.dijkstra();
    routeNodes = dijkstra.getRouteNodes();
    routeEdges = dijkstra.getRouteEdges();
    route = dijkstra.getRoute();
  }

  public void startAlgorithm() {
    if (algorithm.equalsIgnoreCase("dijkstra")) {
      dijkstraAlgorithm();
    }
  }


}
