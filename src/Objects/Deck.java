package Objects;

import Classes.BLabel;
import Classes.Coordinate;
import Codes.PotionCode;
import acm.graphics.GCompound;
import acm.graphics.GRect;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Deck {
    public ArrayList<PotionCode> deck;
    public ArrayList<PotionCode> discard;
    public ArrayList<PotionCode> permanentDeck;

    public Deck(ArrayList<PotionCode> baseDeck){
        permanentDeck = baseDeck;
        deck=new ArrayList<>();
        deck.addAll(baseDeck);
        discard = new ArrayList<>();
    }
    public void addTemporary(ArrayList<PotionCode> temporary){
        deck.addAll(temporary);
    }
    public void resetAll(){
        deck = new ArrayList<>(permanentDeck);
    }
    public void addPermanent(ArrayList<PotionCode> permanent){
        for (PotionCode p: permanent) {
            deck.add(p);
            permanentDeck.add(p);
        }
    }
    public void removePermanent(ArrayList<PotionCode> permanent){
        for (PotionCode p: permanent) {
            deck.remove(p);
            permanentDeck.remove(p);
        }
    }
    public PotionCode draw(){
        if (deck.isEmpty()){
            deck = discard;
            discard = new ArrayList<>();
        }
        PotionCode p = deck.remove((int) (deck.size()*Math.random()));
        discard.add(p);
        return p;
    }

    public void removeTemporary(ArrayList<PotionCode> temporary){
        deck.removeAll(temporary);
    }

    public GCompound display(){
        GCompound display = new GCompound();
        GRect card = new GRect(180,225);
        card.setFillColor(Color.BLACK);
        card.setFilled(true);
        card.setColor(Color.white);
        display.add(card);
        HashMap<PotionCode,Integer> nums = new HashMap<>();
        for (PotionCode p: permanentDeck) {
            if (nums.containsKey(p)){
                nums.put(p,nums.get(p)+1);
            }
            else{
                nums.put(p,1);
            }
        }
        BLabel title= new BLabel("Deck",4);
        title.setColor(Color.white);
        display.add(title,5,15);
        int z = 0;
        int y = 0;
        for (PotionCode d: nums.keySet()) {
            display.add(d.getShape(),new Coordinate((y*50)-5,(z*32)+5).subtract(d.getOffset()).toPoint());
            BLabel b = new BLabel("x" + nums.get(d),20);
            b.setColor(d.textColor());
            z++;
            display.add(b,(y*50)+35,(z*32)+5);
            if (z > 5){
                z = 0;
                y++;
            }
        }
        return display;
    }
    public int countPotions(String s){
        int num = 0;
        boolean half = s.endsWith("/2");
        if (half){
            s = s.substring(0,s.length()-2);
        }
        for (PotionCode p: permanentDeck) {
            if (p.text().equals(s) && (p.amount()==0.5)==half){
                num++;
            }
        }
        return num;
    }
}
