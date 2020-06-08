package Model.ConnectionToController;

import Model.Objects.Edge;
import Model.Objects.Node;
import Model.Objects.Storage;
import java.util.ArrayList;

public interface ModelToControllerInterface {

  public ArrayList getAllNodes();

  public ArrayList getAllEdges();

  public Storage getStorage();

  public Node getNodeByName(String name);

  public Edge getEdgeByName(String name);

}
