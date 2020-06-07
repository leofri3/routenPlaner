package View;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class MenuBarBuilder {

  public MenuBar build() {
    MenuBar menubar = new MenuBar();

    Menu settings = new Menu("settings");
    Menu algorithmSetting = new Menu("algorithm");
    MenuItem dijkstra = new MenuItem("dijkstra");
    MenuItem greedy = new MenuItem("greedy");

    settings.getItems().add(algorithmSetting);
    algorithmSetting.getItems().addAll(dijkstra, greedy);
    menubar.getMenus().add(settings);

    return menubar;
  }
}
