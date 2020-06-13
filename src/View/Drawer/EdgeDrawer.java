package View.Drawer;

import Controller.ConnectionToView.ControllerToView;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.ImageLoader;
import View.LatLonToPixelTranslator;
import View.Objects.Point;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class EdgeDrawer {

  private ControllerToView controllerToView;
  private LatLonToPixelTranslator translator = new LatLonToPixelTranslator();
  private ImageLoader imageLoader = new ImageLoader();

  public EdgeDrawer(ControllerToView controllerToView) {
    this.controllerToView = controllerToView;
  }

  private Group draw(Group group, ArrayList<Edge> routeEdges, Boolean Route) {
    group.getChildren().clear();
    group.getChildren().add(imageLoader.getImage());
    for (Edge edge : routeEdges) {
      Node sourceNode = controllerToView.getNodeByName(edge.getSource());
      Node targetNode = controllerToView.getNodeByName(edge.getTarget());
      Point sourcePoint = translator.translateNode(sourceNode);
      Point targetPoint = translator.translateNode(targetNode);

      Line line = new Line(sourcePoint.getX(), sourcePoint.getY(), targetPoint.getX(), targetPoint.getY());
      if (Route == true) {
        line.setStroke(Color.RED);
      }
      else  {
        line.setStroke(Color.BLACK);
      }

      group.getChildren().add(line);
    }
    return group;
  }

  public Group drawAllEdges(Group group) {
    ArrayList<Edge> allEdges = controllerToView.getAllEdges();
    return draw(group, allEdges, false);
  }

  public Group drawRouteEdges(Group group) {
    ArrayList<Edge> routeEdges = controllerToView.getRouteEdges();
    return draw(group, routeEdges, true);
  }
}
