package Controller;

import Model.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import java.util.ArrayList;

public class ControllerToView implements ControllerToViewInterface {

  ModelToController modelToController = new ModelToController();

  @Override
  public ArrayList getAllNodes() {
    return modelToController.getAllNodes();
  }

  @Override
  public ArrayList getAllEdges() {
    return modelToController.getAllEdges();
  }

  @Override
  public Node getNodeByName(String name) {
    return modelToController.getNodeByName(name);
  }

  @Override
  public Edge getEdgeByName(String name) {
    return modelToController.getEdgeByName(name);
  }
}
