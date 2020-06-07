package View.Objects;

public class ReferencePoint {

  private double pixelX;
  private double pixelY;
  private double lat;
  private double lon;

  public ReferencePoint(Double pixelX, double pixelY, double lat, double lon) {
    this.pixelX = pixelX;
    this.pixelY = pixelY;
    this.lat = lat;
    this.lon = lon;
  }

  public double getPixelX() {
    return pixelX;
  }

  public double getPixelY() {
    return pixelY;
  }

  public double getLat() {
    return lat;
  }

  public double getLon() {
    return lon;
  }
}
