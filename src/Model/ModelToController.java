package Model;

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
}
