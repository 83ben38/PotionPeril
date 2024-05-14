package Objects;

import Classes.Coordinate;
import Codes.ShapeCode;
import Game.PotionPeril;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Tile extends GCompound {

    public static ShapeCode shapeCode;
    public static PotionPeril game;

    public Potion potion;

    public Tile under;

    public static Coordinate offset;

    public static boolean mouseClicked = false;

    public Coordinate coord;

    public static ArrayList<Coordinate> selected = new ArrayList<>();

    public GPolygon base;
    public GOval select;
    public GLine connect;
    public Tile(Coordinate coord){
        this.coord = coord;
        base = shapeCode.getShape();
        base.setFillColor(new Color(30, 131, 166));
        base.setFilled(true);
        add(base);
        Coordinate offset = shapeCode.getOffset();
        game.add(this, Coordinate.toPoint(Coordinate.toCoordinate(shapeCode.getPositionOf(coord)).add(Tile.offset.add(offset))));
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (PotionPeril.playable) {
                    mouseClicked = true;
                    if (!selected.isEmpty() && selected.getLast() == coord) {
                        selected.removeLast();
                    } else if (selected.contains(coord)) {
                        while (selected.removeLast() != coord) {
                        }
                        selected.add(coord);
                    } else if (selected.isEmpty() || coord.isNextTo(selected.getLast())) {
                        selected.add(coord);
                    } else {
                        selected = new ArrayList<>();
                        selected.add(coord);
                    }
                    PotionPeril.updateSelected();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                mouseClicked = false;
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (mouseClicked && PotionPeril.playable){
                    if (selected.size() > 1 && selected.get(selected.size()-2) == coord){
                        selected.removeLast();
                    }
                    else if ((selected.isEmpty() || coord.isNextTo(selected.getLast()))&& !selected.contains(coord)){
                        selected.add(coord);
                    }
                    PotionPeril.updateSelected();
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        select = new GOval(40,40);
        add(select,offset.x-select.getWidth()/2,offset.y-select.getHeight()/2);
        select.setVisible(false);
        select.setColor(new Color(255, 98, 0));
        connect = new GLine(offset.x,offset.y,0,0);
        add(connect);
        connect.setVisible(false);
        connect.setColor(new Color(255, 98, 0));
        connect.sendToFront();
        select.sendToFront();
        base.setColor(new Color(255,255,255));
    }

    public void configureSelected(){
        select.setVisible(false);
        connect.setVisible(false);
        base.setFilled(true);
        if (selected.contains(coord)){
            base.setFilled(false);
            if (selected.getLast() == coord){
                select.setVisible(true);
            }
            else if (selected.size() > 1){
                connect.setVisible(true);
                Coordinate focus = Coordinate.toCoordinate(shapeCode.getPositionOf(selected.get(selected.indexOf(coord)+1))).subtract(Coordinate.toCoordinate(shapeCode.getPositionOf(coord)));
                Coordinate offset = shapeCode.getOffset();
                connect.setEndPoint(focus.x+offset.x,focus.y+offset.y);
            }
        }
    }

    public void fall(){
        if (under != null) {
            under.fall();
            if (potion == null) {
                return;
            }
            if (under.potion == null) {
                new Thread(potion::moveDownwards).start();
                potion = null;
            }
        }
    }
}
