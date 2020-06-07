package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class UI extends Application {

  private NodeDrawer nodeDrawer = new NodeDrawer();
  private Group group = new Group();


  @Override
  public void start(Stage primaryStage) {

    Circle referencePoint1 = new Circle(178, 552, 1);
    Circle referencePoint2 = new Circle(131, 125, 1);

    BorderPane root = new BorderPane();

    group.getChildren().add(getImage());
    addNodes();
    root.setLeft(group);
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }

  private ImageView getImage() {
    Image img = null;
    FileInputStream imgFile = null;
    try {
      imgFile = new FileInputStream("src/Files/map.png");
      img = new Image(imgFile);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ImageView imgView = new ImageView(img);
    return imgView;
  }

  private Group addNodes() {
    return nodeDrawer.drawAllNodes(group);
  }
}
