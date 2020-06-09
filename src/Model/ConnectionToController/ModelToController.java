package Model.ConnectionToController;

import Model.Objects.Edge;
import Model.Objects.Node;
import Model.Objects.Storage;
import Model.XmlReader;
import java.util.ArrayList;

public class ModelToController {

  private XmlReader xmlReader = new XmlReader();

  public ArrayList getAllNodes() {
    return xmlReader.getStorage().getNodes();
  }

  public ArrayList getAllEdges() {
    return xmlReader.getStorage().getEdges();
  }

  public Storage getStorage() {
    return xmlReader.getStorage();
  }

  public Node getNodeByName(String name) {
    return xmlReader.getStorage().getNodeByName(name);
  }

  public Edge getEdgeByName(String name) {
    return xmlReader.getStorage().getEdgeByName(name);
  }
}
