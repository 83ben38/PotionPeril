package Classes;

import Codes.ShapeCode;
import acm.graphics.GPoint;

public class Coordinate {
    public static ShapeCode shapeCode;
    public int x;
    public int y;

    public Coordinate(int x, int y){
        this.x=x;
        this.y=y;
    }

    public boolean isNextTo(Coordinate c){
        return shapeCode.isNextTo(this,c);
    }

    public static Coordinate toCoordinate(GPoint p){
        return new Coordinate((int)p.getX(),(int)p.getY());
    }

    public GPoint toPoint(){
        return toPoint(this);
    }

    public Coordinate add(Coordinate c){
        return new Coordinate(x+c.x,y+c.y);
    }
    public Coordinate subtract(Coordinate c){
        return new Coordinate(x-c.x,y-c.y);
    }

    public static GPoint toPoint(Coordinate c){
        return new GPoint(c.x,c.y);
    }
}
