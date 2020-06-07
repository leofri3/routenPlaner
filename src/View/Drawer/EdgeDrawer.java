package View.Drawer;

import Controller.ControllerToView;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.LatLonToPixelTranslator;
import View.Objects.Point;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.shape.Line;

public class EdgeDrawer {
  private ControllerToView controllerToView = new ControllerToView();
  private LatLonToPixelTranslator translator = new LatLonToPixelTranslator();
  private ArrayList<Edge> edges;

  public EdgeDrawer() {
    edges = controllerToView.getAllEdges();
  }

  public Group drawAllEdges(Group group) {
    for (Edge edge : edges) {
      Node sourceNode = controllerToView.getNodeByName(edge.getSource());
      Node targetNode = controllerToView.getNodeByName(edge.getTarget());
      Point sourcePoint = translator.translateNode(sourceNode);
      Point targetPoint = translator.translateNode(targetNode);

      Line line = new Line(sourcePoint.getX(), sourcePoint.getY(), targetPoint.getX(), targetPoint.getY());
      group.getChildren().add(line);
    }
    return group;
  }

}
