package View.ConnectionToModel;

import Controller.Exporter;
import Model.Objects.Node;
import View.UI;
import java.util.ArrayList;

public class ViewToController {

  private String algorithm;
  private String startNOdeID;
  private String destinationID;
  Exporter exporter = new Exporter();

  public String getAlgorithm() {
    return algorithm;
  }

  public String getStartNodeID() {
    return startNOdeID;
  }

  public String getDestinationID() {
    return destinationID;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public void setStartNOdeID(String startNOdeID) {
    this.startNOdeID = startNOdeID;
  }

  public void setDestinationID(String destinationID) {
    this.destinationID = destinationID;
  }

  public void exportToTxt(ArrayList<Node> nodes) {
      exporter.exportToTxt(nodes);
  }
}
