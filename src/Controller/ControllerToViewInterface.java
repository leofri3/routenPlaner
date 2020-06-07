package Controller;

import Model.Objects.Edge;
import Model.Objects.Node;
import java.util.ArrayList;

public interface ControllerToViewInterface {

  public ArrayList getAllNodes();

  public ArrayList getAllEdges();

  public Node getNodeByName(String name);

  public Edge getEdgeByName(String name);
}