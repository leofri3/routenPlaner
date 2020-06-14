package View;

import Model.Objects.Node;
import View.Objects.Point;
import View.Objects.ReferencePoint;

public class LatLonToPixelTranslator {

  private ReferencePoint referencePoint1;
  private ReferencePoint referencePoint2;

  private double lonPerPixel;
  private double latPerPixel;

  public LatLonToPixelTranslator() {
    this.referencePoint1 = new ReferencePoint(178.0, 552.0, 47.811412, 9.036479);
    this.referencePoint2 = new ReferencePoint(131.0, 125.0, 53.442288, 8.113387);

    lonPerPixel = getLonPerPixel();
    latPerPixel = getLatPerPixel();
  }

  private double getLonPerPixel() {
    lonPerPixel = Math.abs((referencePoint2.getPixelX() - referencePoint1.getPixelX()) / (referencePoint2.getLon() - referencePoint1.getLon()));
    return lonPerPixel;
  }

  private double getLatPerPixel() {
    latPerPixel = Math.abs((referencePoint2.getPixelY() - referencePoint1.getPixelY()) / (referencePoint2.getLat() - referencePoint1.getLat()));
    return latPerPixel;
  }

  public Point translateNode(Node node) {
    double lonDifference = referencePoint1.getLon() - node.getLon();
    double latDifference = referencePoint1.getLat() - node.getLat();

    Point point = new Point(referencePoint1.getPixelX() + (-lonDifference * lonPerPixel), referencePoint1.getPixelY() + (latDifference * latPerPixel));
    return point;
  }
}
