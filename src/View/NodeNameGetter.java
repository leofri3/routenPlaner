package View;

import Controller.ConnectionToView.ControllerToView;
import Model.Objects.Node;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NodeNameGetter {

  ControllerToView controllerToView;

  public NodeNameGetter(ControllerToView controllerToView) {
    this.controllerToView = controllerToView;
  }

  public ObservableList<String> getNodeIds() {

    ObservableList<String> startNodes =
        FXCollections.observableArrayList();

    ArrayList<Node> allNodes = controllerToView.getAllNodes();
    for (Node node : allNodes) {
      startNodes.add(node.getId());
    }

    return startNodes;
  }
}
