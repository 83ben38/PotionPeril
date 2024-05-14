package Objects;

import Classes.BLabel;
import Codes.ArtifactCode;
import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;

public class Artifact extends GCompound {
    public ArtifactCode code;
    public Artifact(ArtifactCode code){
        this.code = code;
        GRect card = new GRect(180,225);
        card.setFillColor(Color.BLACK);
        card.setFilled(true);
        card.setColor(Color.white);
        add(card);
        BLabel label = new BLabel(code.description(),26);
        label.setColor(Color.white);
        add(label,5,55);
        BLabel title = new BLabel("Artifact:",26);
        title.setColor(Color.white);
        add(title,5,15);
    }
}
