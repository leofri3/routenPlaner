package View.Drawer;

import Controller.ConnectionToView.ControllerToView;
import Model.Objects.Node;
import View.ImageLoader;
import View.LatLonToPixelTranslator;
import View.Objects.Point;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NodeDrawer {

  private ControllerToView controllerToView;
  private LatLonToPixelTranslator translator = new LatLonToPixelTranslator();
  private ImageLoader imageLoader = new ImageLoader();

  public NodeDrawer(ControllerToView controllerToView) {
    this.controllerToView = controllerToView;
  }

  private Group draw(Group group, ArrayList<Node> routeNodes, Boolean Route) {
    for (Node node : routeNodes) {
      Point point = translator.translateNode(node);
      Circle circle = new Circle(point.getX(), point.getY(), 0.5);
      if (Route == true) {
        circle.setStroke(Color.RED);
      } else {
        circle.setStroke(Color.BLACK);
      }
      group.getChildren().add(circle);
    }
    return group;
  }

  public Group drawAllNodes(Group group) {
    ArrayList<Node> allNodes = controllerToView.getAllNodes();
    return draw(group, allNodes, false);
  }

  public Group drawRouteNodes(Group group) {
    ArrayList<Node> routeNodes = controllerToView.getRouteNodes();
    return draw(group, routeNodes, true);
  }
}
