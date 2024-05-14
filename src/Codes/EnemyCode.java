package Codes;

import Codes.EnemyAttackCode;
import Objects.Deck;

import java.util.ArrayList;

public interface EnemyCode {
    public ArrayList<EnemyAttackCode> attacks();
    public ShapeCode shape();

    public void dealWithDeck(Deck opponentDeck);
    public int difficulty();
    public int maxHealth();

    public String description();
}
