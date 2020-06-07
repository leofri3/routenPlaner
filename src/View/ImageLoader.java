package View;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageLoader {

  public ImageView getImage() {
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
}
