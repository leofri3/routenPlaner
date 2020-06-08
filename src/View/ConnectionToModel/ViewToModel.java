package View.ConnectionToModel;

public class ViewToModel implements ViewToModelInterface {

  @Override
  public String getAlgorithm() {
    return "dijkstra";    //change to function (just testing)
  }

  @Override
  public String getStartNodeID() {
    return "BREMER KREUZ";    //change to function (just testing)
  }

  @Override
  public String getDestinationID() {
    return "THOLEY - HASBORN (A 1)";    //change to function (just testing)
  }
}
