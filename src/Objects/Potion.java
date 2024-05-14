package Objects;

import Classes.Coordinate;
import Codes.PotionCode;
import Codes.ShapeCode;
import Game.PotionPeril;
import acm.graphics.GCompound;

public class Potion extends GCompound {
    public PotionCode type;
    public static PotionPeril game;

    public static ShapeCode shapeCode;

    public Tile tile;
    public Potion(PotionCode type, Coordinate c){
        this.type = type;
        add(type.getShape(),shapeCode.getOffset().subtract(type.getOffset()).toPoint());
        game.add(this, Coordinate.toCoordinate(Tile.shapeCode.getPositionOf(c)).add(Tile.offset).toPoint());
    }

    public void moveDownwards(){
        tile = tile.under;
        tile.potion = this;
        for (int i = 0; i < 50; i++) {
            move(0,1);
            pause(5);
        }

    }
}
