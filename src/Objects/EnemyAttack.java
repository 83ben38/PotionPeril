package Objects;

import Codes.EnemyAttackCode;
import Classes.BLabel;
import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

public class EnemyAttack extends GCompound {
    EnemyAttackCode code;
    public EnemyAttack(EnemyAttackCode code){
        this.code = code;
        GRect card = new GRect(180,225);
        card.setFillColor(Color.BLACK);
        card.setFilled(true);
        card.setColor(Color.white);
        add(card);
        BLabel label = new BLabel(code.description(),26);
        label.setColor(Color.white);
        add(label,5,55);
        BLabel title = new BLabel("Next enemy attack",26);
        title.setColor(Color.white);
        add(title,5,15);
    }
}
