package Objects;

import Classes.BLabel;
import Classes.Coordinate;
import Codes.DeckModifierCode;
import Codes.PotionCode;
import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;
import java.util.HashMap;

public class DeckModifier extends GCompound {
    public DeckModifierCode code;
    public DeckModifier(DeckModifierCode recipeCode){
        code = recipeCode;
        GRect card = new GRect(180,225);
        card.setFillColor(Color.BLACK);
        card.setFilled(true);
        card.setColor(Color.white);
        add(card);
        HashMap<PotionCode,Integer> nums = new HashMap<>();
        for (PotionCode add: code.addToDeck()) {
            if (nums.containsKey(add)){
                nums.put(add, nums.get(add)+1);
            }
            else{
                nums.put(add, 1);
            }
        }
        for (PotionCode remove: code.removeFromDeck()) {
            if (nums.containsKey(remove)){
                nums.put(remove, nums.get(remove)-1);
            }
            else{
                nums.put(remove, -1);
            }
        }
        BLabel title= new BLabel("Add to Deck:",20);
        title.setColor(Color.white);
        add(title,5,15);
        int z = 0;
        int y = 0;
        for (PotionCode d: nums.keySet()) {
            add(d.getShape(),new Coordinate((y*50)-5,(z*32)+5).subtract(d.getOffset()).toPoint());
            BLabel b = new BLabel("x" + nums.get(d),20);
            b.setColor(d.textColor());
            z++;
            add(b,(y*50)+35,(z*32)+5);
            if (z > 5){
                z = 0;
                y++;
            }
        }
    }
}
