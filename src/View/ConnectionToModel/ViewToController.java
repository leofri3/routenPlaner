package View.ConnectionToModel;

import Controller.Exporter;
import Model.Objects.Node;
import java.util.ArrayList;

public class ViewToController {

  Exporter exporter = new Exporter();
  private String algorithm;
  private String startNOdeID;
  private String destinationID;

  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public String getStartNodeID() {
    return startNOdeID;
  }

  public String getDestinationID() {
    return destinationID;
  }

  public void setDestinationID(String destinationID) {
    this.destinationID = destinationID;
  }

  public void setStartNOdeID(String startNOdeID) {
    this.startNOdeID = startNOdeID;
  }

  public void exportToTxt(ArrayList<Node> nodes) {
    exporter.exportToTxt(nodes);
  }
}
