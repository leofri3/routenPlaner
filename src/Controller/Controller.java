package Controller;

import Model.ConnectionToController.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.ConnectionToModel.ViewToController;
import java.util.ArrayList;

public class Controller {

  private ViewToController viewToController;
  private AlgorithmStarter algorithmStarter;
  private ModelToController modelToController;

  public Controller(ModelToController modelToController, ViewToController viewToController) {
    this.modelToController = modelToController;
    this.viewToController = viewToController;
    algorithmStarter = new AlgorithmStarter(this.modelToController);
  }

  public void calculateRoute() {
    algorithmStarter.setAlgorithm(viewToController.getAlgorithm());
    algorithmStarter.setStartNodeID(viewToController.getStartNodeID());
    algorithmStarter.setDestinationNodeID(viewToController.getDestinationID());
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
