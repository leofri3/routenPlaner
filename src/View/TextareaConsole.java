package View;

import Controller.ConnectionToView.ControllerToView;
import Model.Objects.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class TextareaConsole {

    ControllerToView controllerToView;

    public TextareaConsole(ControllerToView controllerToView) {
        this.controllerToView = controllerToView;
    }

    public void setRouteText(TextArea textArea) {

        textArea.clear();

        ArrayList<Node> nodes = controllerToView.getRouteNodes();

        for (int i = nodes.size() - 1; i >= 0; i--) {
            Node node = nodes.get(i);
            if (i == 0) {
                textArea.appendText(node.getId());
            }
            else  {
                textArea.appendText(node.getId() + " -->" + "\n");
            }
        }
    }
}
