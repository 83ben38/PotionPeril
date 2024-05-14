package Game;

import Game.PotionPeril;
import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TitleScreen {
    public static GCompound stuff;
    public static void run(){
        PotionPeril game= PotionPeril.game;
        stuff = new GCompound();
        GLabel potion = new GLabel("Potion");
        GLabel peril = new GLabel("Peril");
        GLabel go = new GLabel("Play");
        GRect button = new GRect(30,20);
        potion.setFont(new Font(potion.getFont().getFontName(),potion.getFont().getStyle(),30));
        button.setFilled(true);
        button.setFillColor(Color.white);
        peril.setFont(new Font(potion.getFont().getFontName(),potion.getFont().getStyle(),30));
        stuff.add(potion,game.getWidth()/2-potion.getWidth()/2,game.getHeight()/4);
        stuff.add(peril,game.getWidth()/2-peril.getWidth()/2,game.getHeight()/2);
        stuff.add(button,game.getWidth()/2-button.getWidth()/2,game.getHeight()*3/4-button.getHeight()/2);
        stuff.add(go,game.getWidth()/2-go.getWidth()/2,game.getHeight()*3/4);
        game.add(stuff);
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PotionPeril.game.remove(stuff);
                PotionPeril.game.initialize();
                PotionPeril.game.startLevel();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }
}
