package Codes;

import Classes.Coordinate;
import acm.graphics.GPoint;
import acm.graphics.GPolygon;

public interface ShapeCode {
    public GPoint getPositionOf(Coordinate c);
    public GPolygon getShape();
    public boolean isNextTo(Coordinate c1, Coordinate c2);

    public Coordinate getOffset();

    public Coordinate getDimensions();
}
