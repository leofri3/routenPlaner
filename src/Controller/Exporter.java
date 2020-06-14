package Controller;

import Model.Objects.Node;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exporter {

  public void exportToTxt(ArrayList<Node> nodes) {
    try {
      String dictionary = "src/Files/";
      String filename = nodes.get(nodes.size() - 1).getId() + "to" + nodes.get(0).getId() + ".txt";
      BufferedWriter writer = new BufferedWriter(new FileWriter(dictionary + filename));
      writer.write(nodes.get(nodes.size() - 1).getId() + " to " + nodes.get(0).getId());
      for (int i = nodes.size() - 1; i >= 0; i--) {
        Node node = nodes.get(i);
        writer.newLine();
        if (i == 0) {
          writer.write(node.getId());
        } else {
          writer.write(node.getId() + " -->");
        }
        writer.flush();
      }
      writer.close();
      System.out.println(filename + " exported");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
