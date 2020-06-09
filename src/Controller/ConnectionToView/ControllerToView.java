package Controller.ConnectionToView;

import Controller.Controller;
import Model.ConnectionToController.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import java.util.ArrayList;

public class ControllerToView {

  ModelToController modelToController = new ModelToController();
  private Controller controller = new Controller(modelToController);

  public ArrayList getAllNodes() {
    return modelToController.getAllNodes();
  }

  public ArrayList getAllEdges() {
    return modelToController.getAllEdges();
  }

  public ArrayList getRouteNodes() {
    controller.calculateRoute();
    return controller.getRouteNodes();
  }

  public ArrayList getRouteEdges() {
    controller.calculateRoute();
    return controller.getRouteEdges();
  }

  public ArrayList getRoute() {
    controller.calculateRoute();
    return controller.getRoute();
  }

  public Node getNodeByName(String name) { return modelToController.getNodeByName(name); }

  public Edge getEdgeByName(String name) {
    return modelToController.getEdgeByName(name);
  }

  public void startAlgorithm() {

  }
}
