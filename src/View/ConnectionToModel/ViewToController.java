package View.ConnectionToModel;

import View.UI;

public class ViewToController {

  private String algorithm;
  private String startNOdeID;
  private String destinationID;

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
}
