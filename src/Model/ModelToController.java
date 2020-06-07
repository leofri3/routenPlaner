package Model;

import Model.Objects.Edge;
import Model.Objects.Node;
import java.util.ArrayList;

public class ModelToController implements ModelToControllerInterface {

  private XmlReader xmlReader = new XmlReader();

  @Override
  public void parseXmlFile() {
    xmlReader.storeXMLFile();
  }

  @Override
  public ArrayList getAllNodes() {
    return xmlReader.getStorage().getNodes();
  }

  @Override
  public ArrayList getAllEdges() {
    return xmlReader.getStorage().getNodes();
  }

  @Override
  public Node getNodeByName(String name) {
    return xmlReader.getStorage().getNodeByName(name);
  }

  @Override
  public Edge getEdgeByName(String name) {
    return xmlReader.getStorage().getEdgeByName(name);
  }
}
