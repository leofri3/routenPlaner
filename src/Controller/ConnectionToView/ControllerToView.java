package Controller.ConnectionToView;

import Controller.AlgorithmStarter;
import Controller.Controller;
import Model.ConnectionToController.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import java.util.ArrayList;

public class ControllerToView implements ControllerToViewInterface {

  ModelToController modelToController = new ModelToController();
  private Controller controller = new Controller();

  @Override
  public ArrayList getAllNodes() {
    return modelToController.getAllNodes();
  }

  @Override
  public ArrayList getAllEdges() {
    return modelToController.getAllEdges();
  }

  @Override
  public ArrayList getRouteNodes() {
    controller.calculateRoute();
    return controller.getRouteNodes();
  }

  @Override
  public ArrayList getRouteEdges() {
    controller.calculateRoute();
    return controller.getRouteEdges();
  }

  @Override
  public ArrayList getRoute() {
    controller.calculateRoute();
    return controller.getRoute();
  }

  @Override
  public Node getNodeByName(String name) { return modelToController.getNodeByName(name); }

  @Override
  public Edge getEdgeByName(String name) {
    return modelToController.getEdgeByName(name);
  }

  @Override
  public void startAlgorithm() {

  }
}
