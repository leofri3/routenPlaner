package View.Drawer;

import Controller.ConnectionToView.ControllerToView;
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

  private Group draw(Group group, ArrayList<Node> routeNodes) {
    for (Node node : routeNodes) {
      Point point = translator.translateNode(node);
      Circle circle = new Circle(point.getX(), point.getY(), 1);
      group.getChildren().add(circle);
    }
    return group;
  }

  public Group drawAllNodes(Group group) {
    ArrayList<Node> allNodes = controllerToView.getAllNodes();
    return draw(group, allNodes);
  }

  public Group drawRouteNodes(Group group) {
    ArrayList<Node> routeNodes = controllerToView.getRouteNodes();
    return draw(group, routeNodes);
  }
}
