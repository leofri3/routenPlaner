package Model;

import Model.Objects.Edge;
import Model.Objects.Storage;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlReader {

  private Storage storage;

  public XmlReader() {
    System.out.println("store");
    storeXMLFile();
  }

  //Converts the XML File to a document (entire XML document)
  private Document readXMLFile() {

    DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
    DocumentBuilder builder = null;
    Document document = null;
    try {
      builder = factory.newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    File file = new File("src/Files/data.xml");
    try {
      document = builder.parse(file);
      document.getDocumentElement().normalize();
    } catch (SAXException | IOException e) {
      e.printStackTrace();
    }
    return document;
  }

  //get node data and parse it
  private Model.Objects.Node parseNode(Element specificNode, Storage storage) {

    String id = specificNode.getAttribute("id");
    NodeList dataList = specificNode.getElementsByTagName("data");
    float lat = Float.parseFloat(dataList.item(0).getTextContent());
    float lon = Float.parseFloat(dataList.item(1).getTextContent());

    Model.Objects.Node node = new Model.Objects.Node(id, lat, lon);
    return node;
  }

  //stores all nodes
  private void storeNode(Storage storage, NodeList nodeList) {
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node iNode = nodeList.item(i);  //org.w3c.dom.Node Element
      Element elementNode = (Element) iNode;

      Model.Objects.Node node = parseNode(elementNode, storage);
      storage.getNodes().add(node);
      if (i % 100 == 0) {
        System.out.println(i + " nodes stored ...");
      }
    }
    System.out.println(storage.getNodes().size() + " totally nodes stored");
  }

  //get edge data and parse it
  private Edge parseEdge(Element specificEdge, Storage storage) {

    String source = specificEdge.getAttribute("source");
    String target = specificEdge.getAttribute("target");
    NodeList dataList = specificEdge.getElementsByTagName("data");
    String name = dataList.item(0).getTextContent();
    Float length = Float.parseFloat(dataList.item(1).getTextContent());

    Edge edge = new Edge(name, length);

    Model.Objects.Node sourceNode = storage.getNodeByName(source);
    Model.Objects.Node targetNode = storage.getNodeByName(target);

    edge.setSource(sourceNode.getId());
    edge.setTarget(targetNode.getId());

    sourceNode.getOutgoingEdges().add(edge);
    targetNode.getIncomingEdges().add(edge);

    return edge;
  }

  //stores all edges
  private void storeEdge(Storage storage, NodeList edgeList) {
    for (int i = 0; i < edgeList.getLength(); i++) {
      Node iEdge = edgeList.item(i);  //org.w3c.dom.Node Element
      Element elementEdge = (Element) iEdge;

      Edge edge = parseEdge(elementEdge, storage);
      storage.getEdges().add(edge);
      if (i % 100 == 0) {
        System.out.println(i + " edges stored ...");
      }
    }
    System.out.println(storage.getEdges().size() + " totally edges stored");
  }

  //starts the storing of nodes and edges
  private void storeXMLFile() {
    Document document = readXMLFile();
    Storage storage = new Storage();
    NodeList nodeList = document.getElementsByTagName("node");
    NodeList edgeList = document.getElementsByTagName("edge");

    storeNode(storage, nodeList);
    storeEdge(storage, edgeList);
    this.storage = storage;
  }

  public Storage getStorage() {
    return storage;
  }
}
