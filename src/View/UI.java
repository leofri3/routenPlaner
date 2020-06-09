package View;

import Controller.ConnectionToView.ControllerToView;
import View.Drawer.EdgeDrawer;
import View.Drawer.NodeDrawer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class UI extends Application {

  private ControllerToView controllerToView = new ControllerToView();
  private NodeDrawer nodeDrawer = new NodeDrawer(controllerToView);
  private EdgeDrawer edgeDrawer = new EdgeDrawer(controllerToView);
  private ImageLoader imageLoader = new ImageLoader();
  private MenuBarBuilder menuBarBuilder = new MenuBarBuilder();
  private Group group = new Group();


  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Route finder");

    BorderPane root = new BorderPane();

    root.setTop(menuBarBuilder.build());

    group.getChildren().add(imageLoader.getImage());

    nodeDrawer.drawAllNodes(group);
    edgeDrawer.drawAllEdges(group);
    root.setLeft(group);

    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }


}
