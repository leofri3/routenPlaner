package Controller;

import Model.ModelToController;
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
}
