package Model.ConnectionToController;

import Model.Objects.Edge;
import Model.Objects.Node;
import Model.Objects.Storage;
import Model.XmlReader;
import java.util.ArrayList;

public class ModelToController implements ModelToControllerInterface {

  private XmlReader xmlReader = new XmlReader();

  @Override
  public ArrayList getAllNodes() {
    return xmlReader.getStorage().getNodes();
  }

  @Override
  public ArrayList getAllEdges() {
    return xmlReader.getStorage().getEdges();
  }

  @Override
  public Storage getStorage() { return xmlReader.getStorage(); }

  @Override
  public Node getNodeByName(String name) {
    return xmlReader.getStorage().getNodeByName(name);
  }

  @Override
  public Edge getEdgeByName(String name) {
    return xmlReader.getStorage().getEdgeByName(name);
  }
}
