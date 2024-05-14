package Objects;

import Classes.BLabel;
import Codes.EnemyCode;
import acm.graphics.GCompound;
import acm.graphics.GPolygon;
import acm.graphics.GRect;

import java.awt.*;

public class Enemy extends GCompound {
    public EnemyCode code;
    public Enemy(EnemyCode code){
        this.code = code;
        GRect card = new GRect(180,225);
        card.setFillColor(Color.BLACK);
        card.setFilled(true);
        card.setColor(Color.white);
        add(card);
        BLabel title = new BLabel("Enemy:",26);
        title.setColor(Color.white);
        add(title,5,15);
        BLabel map = new BLabel("Shape:",26);
        map.setColor(Color.white);
        add(map,5,30+map.getHeight()/2);
        GPolygon p = code.shape().getShape();
        p.scale(0.8);
        p.setFillColor(new Color(30, 131, 166));
        p.setFilled(true);
        add(p,60,30-p.getHeight()/2);
        BLabel hp = new BLabel("Max HP: " + code.maxHealth(),26);
        hp.setColor(Color.white);
        add(hp,5,60);
        BLabel desc = new BLabel("Description:",26);
        desc.setColor(Color.white);
        add(desc,5,75);
        BLabel description = new BLabel(code.description(),26);
        description.setColor(Color.white);
        add(description,5,90);
    }
}
