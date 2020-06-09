package Controller;

import Model.ConnectionToController.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.ConnectionToModel.ViewToController;
import java.util.ArrayList;

public class Controller {

  private ViewToController viewToController = new ViewToController();
  private AlgorithmStarter algorithmStarter;
  private ModelToController modelToController = new ModelToController();

  public Controller(ModelToController modelToController) {
    this.modelToController = new ModelToController();
    algorithmStarter = new AlgorithmStarter(viewToController, this.modelToController);
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
