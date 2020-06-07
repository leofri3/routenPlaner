package View.Drawer;

import Controller.ControllerToView;
import Model.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.LatLonToPixelTranslator;
import View.Objects.Point;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class NodeDrawer {
  private ControllerToView controllerToView;
  private LatLonToPixelTranslator translator = new LatLonToPixelTranslator();
  private ArrayList<Node> nodes;

  public NodeDrawer(ControllerToView controllerToView) {
    this.controllerToView = controllerToView;
    nodes = controllerToView.getAllNodes();
  }

  public Group drawAllNodes(Group group) {
    for (Node node : nodes) {
      Point point = translator.translateNode(node);
      Circle circle = new Circle(point.getX(), point.getY(), 1);
      group.getChildren().add(circle);
    }
    return group;
  }
}
