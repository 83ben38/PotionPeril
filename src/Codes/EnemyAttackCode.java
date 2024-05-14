package Codes;

import Objects.Tile;

import java.util.ArrayList;

public interface EnemyAttackCode {
    public String description();
    public void doStuff(ArrayList<Tile> tiles);
}
