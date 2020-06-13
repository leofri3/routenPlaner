package View;

import Controller.ConnectionToView.ControllerToView;
import View.ConnectionToModel.ViewToController;
import View.Drawer.EdgeDrawer;
import View.Drawer.NodeDrawer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UI extends Application {

  private ViewToController viewToController = new ViewToController();
  private ControllerToView controllerToView = new ControllerToView(viewToController);
  private NodeDrawer nodeDrawer = new NodeDrawer(controllerToView);
  private EdgeDrawer edgeDrawer = new EdgeDrawer(controllerToView);
  private NodeNameGetter nodeNameGetter = new NodeNameGetter(controllerToView);
  private Group group = new Group();
  private String startNodeID;
  private String endNodeID;
  private String algorithm;


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
    ComboBox startDropdown = new ComboBox(nodeNameGetter.getNodeIds());
    ComboBox endDropdown = new ComboBox(nodeNameGetter.getNodeIds());
    ComboBox algorithm = new ComboBox(FXCollections.observableArrayList("Dijkstra"));
    Button calculateButton = new Button("Route berechnen");
    TextArea routeText = new TextArea();

    Region endRegion = new Region();
    Region startRegion = new Region();

    algorithm.setPromptText("Algorithmus");

    endDropdownHBox.getChildren().addAll(endText, endRegion, endDropdown);
    startDropdownHBox.getChildren().addAll(startText, startRegion, startDropdown);
    buttonsHBox.getChildren().addAll(algorithm, calculateButton);
    startend.getChildren().addAll(startDropdownHBox, endDropdownHBox);
    leftPartVBox.getChildren().addAll(startend, buttonsHBox, routeText);

    calculateButton.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent actionEvent) {
        viewToController.setStartNOdeID(startDropdown.getValue().toString());
        viewToController.setDestinationID(endDropdown.getValue().toString());
        viewToController.setAlgorithm(algorithm.getValue().toString());

        nodeDrawer.drawRouteNodes(group);
        edgeDrawer.drawRouteEdges(group);
      }
    });

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

    nodeDrawer.drawAllNodes(group);
    edgeDrawer.drawAllEdges(group);

    root.getChildren().addAll(leftPartVBox, group);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.setResizable(false);
    primaryStage.show();
  }

  public String getStartNodeID() {
    return startNodeID;
  }

  public String getEndNodeID() {
    return endNodeID;
  }

  public String getAlgorithm() {
    return algorithm;
  }
}
