package Controller;

import Controller.ConnectionToView.ControllerToView;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.ConnectionToModel.ViewToModel;
import java.util.ArrayList;

public class Controller {
  private AlgorithmStarter algorithmStarter = new AlgorithmStarter();
  private ControllerToView controllerToView = new ControllerToView();
  private ViewToModel viewToModel = new ViewToModel();

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
