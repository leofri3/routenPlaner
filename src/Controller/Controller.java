package Controller;

import Model.Objects.Edge;
import Model.Objects.Node;
import View.ConnectionToModel.ViewToModel;
import java.util.ArrayList;

public class Controller {

  private ViewToModel viewToModel = new ViewToModel();
  private AlgorithmStarter algorithmStarter = new AlgorithmStarter(viewToModel);

  public void calculateRoute() {
    algorithmStarter.setAlgorithm(viewToModel.getAlgorithm());
    algorithmStarter.setStartNodeID(viewToModel.getStartNodeID());
    algorithmStarter.setDestinationNodeID(viewToModel.getDestinationID());
    algorithmStarter.startAlgorithm();
  }

  public ArrayList<Node> getRouteNodes() {
    return algorithmStarter.getRouteNodes();
  }

  public ArrayList<Edge> getRouteEdges() {
    return algorithmStarter.getRouteEdges();
  }

  public ArrayList<Object> getRoute() {
    return algorithmStarter.getRoute();
  }

}
