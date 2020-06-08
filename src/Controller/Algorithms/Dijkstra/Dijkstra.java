package Controller.Algorithms.Dijkstra;

import Model.ConnectionToController.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import Model.Objects.Storage;
import java.util.ArrayList;

public class Dijkstra {

  ArrayList<DijkstraNode> stack;
  ArrayList<DijkstraNode> queue = new ArrayList<>();
  ArrayList<Edge> routeEdges = new ArrayList<>();
  ArrayList<Node> routeNodes = new ArrayList<>();
  ArrayList<Object> route = new ArrayList<>();
  private ModelToController modelToController;
  private ArrayList<DijkstraNode> dijkstraNodes;
  private Storage storage;
  private DijkstraNode startNode;
  private DijkstraNode destinationNode;

  public Dijkstra(ModelToController modelToController) {
    this.modelToController = modelToController;
    storage = modelToController.getStorage();
    queue.add(startNode);
  }

  public void setStartNode(Node startNode) {
    this.startNode = new DijkstraNode(startNode, 0);
  }

  public void setDestinationNode(Node destinationNode) {
    this.destinationNode =  new DijkstraNode(destinationNode, 0);
  }

  public ArrayList<Edge> getRouteEdges() {
    return routeEdges;
  }

  public ArrayList<Node> getRouteNodes() {
    return routeNodes;
  }

  public ArrayList<Object> getRoute() {
    return route;
  }

  private void setDijkstraNodes() {
    ArrayList<Node> nodes = modelToController.getAllNodes();
    for (Node node : nodes) {
      dijkstraNodes.add(new DijkstraNode(node, 0));
    }
  }

  public void dijkstra() {
    setDijkstraNodes();   //converts Node to DijkstraNode
    boolean finished = false;
    DijkstraNode consideringNode = queue.get(0);  //set considering node to start point
    ArrayList<DijkstraNode> connectedTo = new ArrayList<>();

    while (!finished) {
      connectedTo.clear();    //clear the connected list
      consideringNode = getNodeWithLowestCost(queue);   //get node with the lowest cost to consider
      getConnectedNodes(connectedTo, consideringNode);  //add all connected nodes to a list and to queue
      consideringNode.setVisited(true);   //set node to visited
      finished = checkFinished(queue);
    }
    setBestRoute();
  }

  private void getConnectedNodes(ArrayList<DijkstraNode> connectedTo, DijkstraNode consideringNode) {
    for (Edge edge : consideringNode.getNode().getOutgoingEdges()) {
      DijkstraNode dNode = getDijkstraNodeByName(edge.getTarget());   //connected node
      connectedTo.add(dNode);
      dNode.setCost(edge.getLength());    //add a cost (because its maybe 0)
      checkCostUpdate(dNode, consideringNode, edge);    //check if its the fastest way
      queue.add(dNode);   //add to queue
    }
  }

  private void checkCostUpdate(DijkstraNode dNode, DijkstraNode consideringNode, Edge edge) {
    if (dNode.getCost() == 0) {   //if node is unvisited and dont have a cost
      dNode.setCost(consideringNode.getCost() + edge.getLength());
    }
    if (dNode.getCost() > consideringNode.getCost() + edge.getLength()) {   //if the new connection is faster
      dNode.setCost(consideringNode.getCost() + edge.getLength());    //updates cost
      dNode.setPredecessor(consideringNode);    //updates predecessor
    }
  }


  private DijkstraNode getDijkstraNodeByName(String name) {
    for (DijkstraNode dijkstraNode : dijkstraNodes) {
      if (dijkstraNode.getNode().getId().equalsIgnoreCase(name)) {
        return dijkstraNode;
      }
    }
    return null;
  }

  private DijkstraNode getNodeWithLowestCost(ArrayList<DijkstraNode> queue) {
    DijkstraNode lowestCostNode = queue.get(0);   //set first node as lowest
    for (DijkstraNode dNode : queue) {    //iterate through all nodes in queue
      if (dNode.getCost() < lowestCostNode.getCost() && !dNode.isVisited()) {   //if node is lower and not visited
        lowestCostNode = dNode;
      }
    }
    return lowestCostNode;
  }

  private boolean checkFinished(ArrayList<DijkstraNode> queue) {
    for (Edge edge : destinationNode.getNode().getIncomingEdges()) {  //all connections to the destination
      if (!getDijkstraNodeByName(edge.getSource()).isVisited()) {   //if one connection in front is not visited
        return false;
      }
    }
    return true;
/*    for (DijkstraNode dNode : queue) {
      if (!dNode.isVisited()) {
        return false;
      }
    }
    return true;*/
  }

  private void setBestRoute() {
    DijkstraNode dNode = destinationNode;
    while (destinationNode != startNode) {
      routeNodes.add(dNode.getNode());
      route.add(dNode.getNode());
      for (Edge edge : dNode.getNode().getIncomingEdges()) {  //get all incoming edges
        if (edge.getSource() == dNode.getPredecessor().getNode().getId()) {    //select the edge which connects the two nodes
          routeEdges.add(edge);
          route.add(edge);
        }
      }
      dNode = dNode.getPredecessor();
    }
  }
}
