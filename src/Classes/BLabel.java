package Classes;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;

import java.awt.*;

public class BLabel extends GCompound {

    String s;
    public BLabel(String s, int length) {
        this.s=s;
        String v = new String(s);
        while (v.length() >= length){
            add(new GLabel(v.substring(0,length)),0,getHeight());
            v = v.substring(length);
        }
        add (new GLabel(v),0,getHeight());
    }

}
