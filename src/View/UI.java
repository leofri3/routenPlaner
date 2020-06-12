package View;

import Controller.ConnectionToView.ControllerToView;
import View.Drawer.EdgeDrawer;
import View.Drawer.NodeDrawer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {

  private ControllerToView controllerToView = new ControllerToView();
  private NodeDrawer nodeDrawer = new NodeDrawer(controllerToView);
  private EdgeDrawer edgeDrawer = new EdgeDrawer(controllerToView);
  private ImageLoader imageLoader = new ImageLoader();
  private MenuBarBuilder menuBarBuilder = new MenuBarBuilder();
  private NodeLists nodeLists = new NodeLists();
  private Group group = new Group();


  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Route finder");


    HBox root = new HBox();
    VBox leftPartVBox = new VBox();
    VBox startend = new VBox();
    HBox startDropdownHBox = new HBox();
    HBox endDropdownHBox = new HBox();
    HBox buttonsHBox = new HBox();

    Text startText = new Text("Start:");
    Text endText = new Text("Ziel:");
    ComboBox startDropdown = new ComboBox(nodeLists.getStartNodes());
    ComboBox endDropdown = new ComboBox(nodeLists.getEndNodes());
    Button calculateButton = new Button("Route berechnen");
    TextArea routeText = new TextArea();

    Region endRegion = new Region();
    Region startRegion = new Region();

    endDropdownHBox.getChildren().addAll(endText, endRegion, endDropdown);
    startDropdownHBox.getChildren().addAll(startText, startRegion, startDropdown);
    buttonsHBox.getChildren().addAll(menuBarBuilder.build(), calculateButton);
    startend.getChildren().addAll(startDropdownHBox, endDropdownHBox);
    leftPartVBox.getChildren().addAll(startend, buttonsHBox, routeText);

    startDropdown.setMinWidth(425);
    endDropdown.setMinWidth(425);

    endDropdownHBox.setHgrow(endRegion, Priority.ALWAYS);
    startDropdownHBox.setHgrow(startRegion, Priority.ALWAYS);
    endDropdownHBox.setPadding(new Insets(0, 0, 0, 10));
    startDropdownHBox.setPadding(new Insets(0, 0, 0, 10));

    buttonsHBox.setAlignment(Pos.CENTER);

    routeText.setMinHeight(400);
    routeText.setDisable(true);

    leftPartVBox.setSpacing(25);



    group.getChildren().add(imageLoader.getImage());
    nodeDrawer.drawAllNodes(group);
    edgeDrawer.drawAllEdges(group);

    root.getChildren().addAll(leftPartVBox, group);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }
}
