package Codes;

import Classes.Coordinate;
import acm.graphics.GObject;

import java.awt.*;

public interface PotionCode {
    public Coordinate getOffset();
    public GObject getShape();

    public String text();

    default double amount(){
        return 1;
    }

    public Color textColor();
}
