package Codes;

import Objects.Deck;

import java.util.ArrayList;

public interface DeckModifierCode {
    public ArrayList<PotionCode> addToDeck();
    public ArrayList<PotionCode> removeFromDeck();
    public boolean available(Deck deck);

    public int getTier();
}
