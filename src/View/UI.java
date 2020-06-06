package View;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class UI extends Application {


    @Override
    public void start(Stage primaryStage){
        Image img = null;
        FileInputStream imgFile = null;
        try {
            imgFile = new FileInputStream("src/Files/map.png");
            img = new Image(imgFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ImageView imgView = new ImageView(img);
        BorderPane root = new BorderPane();
        root.setLeft(imgView);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
