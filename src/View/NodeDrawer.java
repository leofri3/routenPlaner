package View;

import Model.ModelToController;
import Model.Objects.Edge;
import Model.Objects.Node;
import View.Objects.Point;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class NodeDrawer {
  private ModelToController modelToController = new ModelToController();
  private LatLonToPixelTranslator translator = new LatLonToPixelTranslator();
  private ArrayList<Node> nodes;
  private ArrayList<Edge> edges;

  public NodeDrawer() {
    nodes = modelToController.getAllNodes();
    edges = modelToController.getAllEdges();
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
