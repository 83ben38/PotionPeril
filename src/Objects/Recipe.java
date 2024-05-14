package Objects;

import Classes.BLabel;
import Classes.Coordinate;
import Codes.PotionCode;
import Codes.RecipeCode;
import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;
import java.util.HashMap;

public class Recipe extends GCompound {
    public RecipeCode code;
    public static HashMap<String, PotionCode> codes = new HashMap<>();
    public Recipe(RecipeCode recipeCode){
        code = recipeCode;
        GRect card = new GRect(180,225);
        card.setFillColor(Color.BLACK);
        card.setFilled(true);
        card.setColor(Color.white);
        add(card);
        int j = -1;
        int k = 0;
        for (String key: code.requirements().keySet()) {
            for (int i = 0; i < code.requirements().get(key); i++) {
                j++;
                if(j == 5){
                    j = 0;
                    k++;
                }
                add(codes.get(key).getShape(),new Coordinate((j*30),(k*30)).subtract(codes.get(key).getOffset()).toPoint());
            }
        }
        BLabel label = new BLabel(code.description(),26);
        label.setColor(Color.white);
        add(label,5,55 + (k*30));
    }
}
