package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class NodeLists {
    public ObservableList<String> getStartNodes() {

        ObservableList<String> startNodes =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3"
                );


        // hier alle Namen jeder Start Node zurückgeben

        return startNodes;
    }

    public ObservableList<String> getEndNodes() {

        ObservableList<String> endNodes =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3"
                );

        // hier alle Namen jeder Ziel Node zurückgeben

        return endNodes;
    }
}
