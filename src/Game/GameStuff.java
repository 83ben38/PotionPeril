package Game;

import Codes.*;
import Objects.*;

import java.util.ArrayList;
import java.util.HashMap;

import static Game.PotionPeril.*;

public class GameStuff {

    public static HashMap<String, PotionCode> codes;
    public static ArrayList<RecipeCode> availableRecipes = new ArrayList<>();
    static{
        //1
        {
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(ratio);
                }

                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Blue",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Gives x shield";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio);
                }
                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Green",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.heal(ratio);
                }
                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",2);
                    hm.put("Blue",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals x damage and gains x shield";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(ratio);
                    yourHealth.shield(ratio);
                }
                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Blue",1);
                    hm.put("Green",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Gains x shield, and then heals you 1 for each shield you have.";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio);
                    yourHealth.heal(yourHealth.shield);
                }
                @Override
                public int getTier() {
                    return 1;
                }
            });
        }
        //2
        {
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",1);
                    hm.put("Magenta",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals 3x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(3*ratio);
                }

                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Blue",1);
                    hm.put("Cyan",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Gives 3x shield";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio*3);
                }
                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Green",1);
                    hm.put("Yellow",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 3x, deal x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.heal(ratio*3);
                    enemyHealth.damage(ratio);
                }
                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",2);
                    hm.put("Blue",2);
                    hm.put("Green",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 3x, with overheal. Deals the amount of shield as damage.";
                }

                @Override
                public void doStuff(int ratio) {
                    int n = yourHealth.maxHealth- yourHealth.health;
                    n -= ratio * 3;
                    if (n < 0){
                        yourHealth.heal(yourHealth.maxHealth- yourHealth.health);
                        yourHealth.shield(-n);
                    }
                    else{
                        yourHealth.heal(ratio*3);
                    }
                    enemyHealth.damage(yourHealth.shield);
                }
                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",3);
                    hm.put("Green",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Inflicts the enemy with x poison.";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.poison(ratio);
                }
                @Override
                public int getTier() {
                    return 2;
                }
            });
        }
        //3
        {
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",5);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals 4x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(4*ratio);
                }

                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Magenta",1);
                    hm.put("Blue",1);
                    hm.put("Red",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Gives x shield, deals x damage per 3 shield";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio);
                    enemyHealth.damage(ratio*((yourHealth.shield/3)+1));
                }
                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Green",5);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 7x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.heal(ratio*7);
                }
                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Magenta",1);
                    hm.put("Cyan",1);
                    hm.put("Yellow",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 3x, with overheal. Deals x damage per 5 shield";
                }

                @Override
                public void doStuff(int ratio) {
                    int n = yourHealth.maxHealth- yourHealth.health;
                    n -= ratio * 3;
                    if (n < 0){
                        yourHealth.heal(yourHealth.maxHealth- yourHealth.health);
                        yourHealth.shield(-n);
                    }
                    else{
                        yourHealth.heal(ratio*3);
                    }
                    enemyHealth.damage(((yourHealth.shield/5)+1)*ratio);
                }
                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Blue",5);
                    return hm;
                }

                @Override
                public String description() {
                    return "Increases shield by 4x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio*4);
                }
                @Override
                public int getTier() {
                    return 3;
                }
            });
        }
        //4
        {
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(ratio);
                }

                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Magenta",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Gives x shield, deals damage equal to shield";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio);
                    enemyHealth.damage(yourHealth.shield);
                }
                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Green",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 2x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.heal(ratio*2);
                }
                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Cyan",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for x, with overheal.";
                }

                @Override
                public void doStuff(int ratio) {
                    int n = yourHealth.maxHealth- yourHealth.health;
                    n -= ratio;
                    if (n < 0){
                        yourHealth.heal(yourHealth.maxHealth- yourHealth.health);
                        yourHealth.shield(-n);
                    }
                    else {
                        yourHealth.heal(ratio);
                    }
                }
                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Blue",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Increases shield by x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio);
                }
                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",3);
                    hm.put("Blue",2);
                    hm.put("Green",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 3x with overheal. Deals x poison per 5 shield";
                }

                @Override
                public void doStuff(int ratio) {
                    int n = yourHealth.maxHealth- yourHealth.health;
                    n -= ratio*3;
                    if (n < 0){
                        yourHealth.heal(yourHealth.maxHealth- yourHealth.health);
                        yourHealth.shield(-n);
                    }
                    else {
                        yourHealth.heal(ratio*3);
                    }
                    enemyHealth.poison(((yourHealth.shield/5)+1)*ratio);
                }
                @Override
                public int getTier() {
                    return 4;
                }
            });
        }
        //5
        {
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",1);
                    hm.put("Black",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals 3x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(ratio*3);
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Green",1);
                    hm.put("White",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 5x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.heal(ratio*5);
                }
                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Blue",1);
                    hm.put("White",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Increases shield by 3x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio*3);
                }
                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Cyan",2);
                    hm.put("Magenta",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Gains 8x shield";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio*8);
                }
                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Yellow",2);
                    hm.put("Magenta",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals 8x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(ratio*8);
                }
                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Yellow",2);
                    hm.put("Cyan",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 16x";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.heal(ratio*16);
                }
                @Override
                public int getTier() {
                    return 5;
                }
            });
        }
        //6
        {
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Red",3);
                    hm.put("Magenta",2);
                    hm.put("White",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals 10x damage";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.damage(10*ratio);
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Blue",3);
                    hm.put("Cyan",2);
                    hm.put("Black",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Gives 10x shield";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio*10);
                }
                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Green",3);
                    hm.put("Yellow",2);
                    hm.put("Red",2);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals 10x poison";
                }

                @Override
                public void doStuff(int ratio) {
                    enemyHealth.poison(ratio*10);
                }
                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Magenta",1);
                    hm.put("Cyan",1);
                    hm.put("Yellow",1);
                    hm.put("Red",1);
                    hm.put("Blue",1);
                    hm.put("Green",1);
                    hm.put("Black",1);
                    hm.put("White",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Deals 1000 damage if ratio is at least 4";
                }

                @Override
                public void doStuff(int ratio) {
                    if (ratio > 3){
                        enemyHealth.damage(1000);
                    }
                }
                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableRecipes.add(new RecipeCode() {
                @Override
                public HashMap<String, Integer> requirements() {
                    HashMap<String,Integer> hm = new HashMap<>();
                    hm.put("Black",1);
                    hm.put("White",1);
                    return hm;
                }

                @Override
                public String description() {
                    return "Heals for 6x, deals 3x damage, gains 3x shield.";
                }

                @Override
                public void doStuff(int ratio) {
                    yourHealth.shield(ratio*3);
                    yourHealth.heal(ratio*6);
                    enemyHealth.damage(ratio*3);
                }
                @Override
                public int getTier() {
                    return 6;
                }
            });
        }

    }
    public static ArrayList<DeckModifierCode> availableModifiers = new ArrayList<>();
    static{
        //1
        {
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Red"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Blue"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Green"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 2; i++) {
                        potions.add(codes.get("Yellow"));
                        potions.add(codes.get("Cyan"));
                        potions.add(codes.get("Magenta"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 2; i++) {
                        potions.add(codes.get("Red/2"));
                        potions.add(codes.get("Red/2"));
                        potions.add(codes.get("Blue/2"));
                        potions.add(codes.get("Green/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 1;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 2; i++) {
                        potions.add(codes.get("Red"));
                        potions.add(codes.get("Red"));
                        potions.add(codes.get("Blue"));
                        potions.add(codes.get("Green"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Red") > 5 && deck.countPotions("Blue") > 2 && deck.countPotions("Green") > 2;
                }

                @Override
                public int getTier() {
                    return 1;
                }
            });
        }
        //2
        {
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Red"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Red") > 4;
                }

                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Blue"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Blue") > 4;
                }

                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Green"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Green") > 4;
                }

                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Yellow"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Cyan"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 2;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Magenta"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 2;
                }
            });
        }
        //3
        {
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Red/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Red"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Red") > 4;
                }

                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Green/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Green"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Green") > 4;
                }

                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Blue/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Blue"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Blue") > 4;
                }

                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 2; i++) {
                        potions.add(codes.get("White"));
                        potions.add(codes.get("Black"));
                    }

                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
            @Override
            public ArrayList<PotionCode> addToDeck() {
                ArrayList<PotionCode> potions = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    potions.add(codes.get("Cyan/2"));
                }
                return potions;
            }

            @Override
            public ArrayList<PotionCode> removeFromDeck() {
                return new ArrayList<>();
            }

            @Override
            public boolean available(Deck deck) {
                return true;
            }

            @Override
            public int getTier() {
                return 3;
            }
        });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Yellow/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 3;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Magenta/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 3;
                }
            });
        }
        //4
        {
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Cyan"));
                        potions.add(codes.get("Blue"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Cyan"));
                        potions.add(codes.get("Green"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Magenta"));
                        potions.add(codes.get("Blue"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Magenta"));
                        potions.add(codes.get("Red"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Yellow"));
                        potions.add(codes.get("Green"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 4;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Yellow"));
                        potions.add(codes.get("Red"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 4;
                }
            });
        }
        //5
        {
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Yellow"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Yellow") > 4;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Cyan"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Cyan") > 4;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Magenta"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Magenta") > 4;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("White"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Black"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Red"));
                        potions.add(codes.get("Green"));
                        potions.add(codes.get("Blue"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Red") > 4 && deck.countPotions("Green") > 4 && deck.countPotions("Blue") > 4;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Yellow"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Yellow") > 4;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Cyan"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Cyan") > 4;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    return new ArrayList<>();
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Magenta"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Magenta") > 4;
                }

                @Override
                public int getTier() {
                    return 5;
                }
            });
        }
        //6
        {
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Red"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Blue"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Green"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Cyan"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Yellow"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Magenta"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("White"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 10; i++) {
                        potions.add(codes.get("Black"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    return new ArrayList<>();
                }

                @Override
                public boolean available(Deck deck) {
                    return true;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("White/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("White"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("White") > 4;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
            availableModifiers.add(new DeckModifierCode() {
                @Override
                public ArrayList<PotionCode> addToDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Black/2"));
                    }
                    return potions;
                }

                @Override
                public ArrayList<PotionCode> removeFromDeck() {
                    ArrayList<PotionCode> potions = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        potions.add(codes.get("Black"));
                    }
                    return potions;
                }

                @Override
                public boolean available(Deck deck) {
                    return deck.countPotions("Black") > 4;
                }

                @Override
                public int getTier() {
                    return 6;
                }
            });
        }


    }

    public static ArrayList<ArtifactCode> availableArtifacts = new ArrayList<>();
    static{
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                defaultRefreshes++;
            }

            @Override
            public String description() {
                return "+1 Refresh";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                chargesNeeded-=2;
            }

            @Override
            public String description() {
                return "Refresh the board every 3 turns instead of 5.";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                wild.add("White");
            }

            @Override
            public String description() {
                return "White potions count for all types.";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                wild.add("Black");
            }

            @Override
            public String description() {
                return "Black potions count for all types.";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                halfAmount+=1;
            }

            @Override
            public String description() {
                return "Half potions are worth 1 1/2 potions.";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                HealthBar.enemyPoison+=2;
            }

            @Override
            public String description() {
                return "Attacks apply 2 poison";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                repeatAttacks = true;
            }

            @Override
            public String description() {
                return "Repeat attacks with a 1 ratio.";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                ratioIncrease+=2;
            }

            @Override
            public String description() {
                return "Add 2 to the ratio of every attack.";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                HealthBar.overHealDamage = true;
            }

            @Override
            public String description() {
                return "Overheal is converted to damage at 1/3 rate";
            }
        });
        availableArtifacts.add(new ArtifactCode() {
            @Override
            public void doStuff() {
                multiplyColors = true;
            }

            @Override
            public String description() {
                return "Multiply the ratio by the number of different colors used.";
            }
        });
    }

    public static ArrayList<EnemyCode> enemyOptions = new ArrayList<>();
    static{
        //1
        {
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds / 3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per two blue potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Blue")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds / 2);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per two green potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds / 2);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 1;
                }

                @Override
                public int maxHealth() {
                    return 10;
                }

                @Override
                public String description() {
                    return "Glass cannon, deals lots of damage.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per five blue potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int blues = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Blue")) {
                                    blues++;
                                }
                            }
                            yourHealth.damage(blues / 5);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three green potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int greens = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Green")) {
                                    greens++;
                                }
                            }
                            PotionPeril.enemyHealth.heal(greens / 3);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 1;
                }

                @Override
                public int maxHealth() {
                    return 25;
                }

                @Override
                public String description() {
                    return "Tankier enemy that deals less damage.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal shield * red potions / 25 damage.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int blues = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    blues++;
                                }
                            }
                            yourHealth.damage((blues*enemyHealth.shield) / 25);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Gain 1 shield per three blue potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int greens = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Blue")) {
                                    greens++;
                                }
                            }
                            enemyHealth.shield(greens / 3);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 1;
                }

                @Override
                public int maxHealth() {
                    return 15;
                }

                @Override
                public String description() {
                    return "Shield generating enemy.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per five of the potions that you have the most of.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            HashMap<String,Integer> amount = new HashMap<>();
                            for (Tile t : tiles) {
                                String r =t.potion.type.text();
                                amount.put(r, amount.getOrDefault(r, 0)+1);
                            }
                            int max = 0;
                            for (Integer v: amount.values()) {
                                if (v > max){
                                    max = v;
                                }
                            }
                            yourHealth.damage(max / 5);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per five of the potions that you have the most of.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            HashMap<String,Integer> amount = new HashMap<>();
                            for (Tile t : tiles) {
                                String r =t.potion.type.text();
                                amount.put(r, amount.getOrDefault(r, 0)+1);
                            }
                            int max = 0;
                            for (Integer v: amount.values()) {
                                if (v > max){
                                    max = v;
                                }
                            }
                            enemyHealth.heal(max / 5);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 1;
                }

                @Override
                public int maxHealth() {
                    return 20;
                }

                @Override
                public String description() {
                    return "Enemy that deals less damage the more balanced the board is.";
                }
            });
        }
        //2
        {
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds / 3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per four red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds / 4);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per two red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds / 2);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> add = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        add.add(PotionPeril.codes.get("Red"));
                    }
                    opponentDeck.addTemporary(add);
                }

                @Override
                public int difficulty() {
                    return 2;
                }

                @Override
                public int maxHealth() {
                    return 30;
                }

                @Override
                public String description() {
                    return "Adds reds to your deck and deals damage based on reds.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Red")){
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three blue potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int blues = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Blue")){
                                    blues++;
                                }
                            }
                            yourHealth.damage(blues /3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three green potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int greens = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Green")){
                                    greens++;
                                }
                            }
                            enemyHealth.heal(greens/3);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 2;
                }

                @Override
                public int maxHealth() {
                    return 25;
                }

                @Override
                public String description() {
                    return "Overall balanced enemy.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per four red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Red")){
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/4);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per four blue potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int blues = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Blue")){
                                    blues++;
                                }
                            }
                            yourHealth.damage(blues /4);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per four green potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int greens = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Green")){
                                    greens++;
                                }
                            }
                            enemyHealth.heal(greens/4);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    HashMap<PotionCode,Integer> nums = new HashMap<>();
                    ArrayList<PotionCode> add = new ArrayList<>();
                    ArrayList<PotionCode> remove = new ArrayList<>();
                    for (PotionCode p: opponentDeck.permanentDeck) {
                        if (nums.getOrDefault(p,0) < 2 && p.amount()==1){
                            remove.add(p);
                            nums.put(p,nums.getOrDefault(p,0)+1);
                            add.add(codes.get(p.text() + "/2"));
                        }
                    }
                    opponentDeck.addTemporary(add);
                    opponentDeck.removeTemporary(remove);
                }

                @Override
                public int difficulty() {
                    return 2;
                }

                @Override
                public int maxHealth() {
                    return 25;
                }

                @Override
                public String description() {
                    return "Replaces some of your potions with half potions.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per five blue potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Blue")){
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/5);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per five green potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int greens = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Green")){
                                    greens++;
                                }
                            }
                            enemyHealth.heal(greens/5);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Replaces up to 5 reds with blue or green randomly";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int transformed = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Red") && Math.random() <= 5.0/42.0){
                                    game.remove(t.potion);
                                    t.potion = new Potion(codes.get(Math.random() < 0.5 ? "Blue" : "Green"),t.coord);
                                    transformed++;
                                    if (transformed > 4){
                                        return;
                                    }
                                }
                            }
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 2;
                }

                @Override
                public int maxHealth() {
                    return 20;
                }

                @Override
                public String description() {
                    return "A enemy that transforms potions to their advantage";
                }
            });
        }
        //3
        {
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per cyan potion on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Gain 1 shield per two cyan potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                            }
                            enemyHealth.shield(reds / 2);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> add = new ArrayList<>();
                    add.add(PotionPeril.codes.get("Cyan"));
                    opponentDeck.addTemporary(add);
                }

                @Override
                public int difficulty() {
                    return 3;
                }

                @Override
                public int maxHealth() {
                    return 40;
                }

                @Override
                public String description() {
                    return "Adds a cyan to your deck and all attacks are based on cyans";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per four green potions on the board and deal 3 damage.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/4);
                            yourHealth.damage(3);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> add = new ArrayList<>();
                    ArrayList<PotionCode> remove = new ArrayList<>();
                    for (PotionCode p: opponentDeck.permanentDeck) {
                        if (p.text().equals("Green")){
                            remove.add(p);
                            add.add(codes.get("Green/2"));
                        }
                    }
                    opponentDeck.addTemporary(add);
                    opponentDeck.removeTemporary(remove);
                }

                @Override
                public int difficulty() {
                    return 3;
                }

                @Override
                public int maxHealth() {
                    return 35;
                }

                @Override
                public String description() {
                    return "Enemy that halves all your greens and heals of them.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per two red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Red")){
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/2);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per two green potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int greens = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Green")){
                                    greens++;
                                }
                            }
                            enemyHealth.heal(greens/2);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Halves all potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            for (Tile t: tiles) {
                                if (!t.potion.type.text().endsWith("/2")){
                                    game.remove(t.potion);
                                    t.potion = new Potion(codes.get(t.potion.type.text() + "/2"),t.coord);
                                }
                            }
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 3;
                }

                @Override
                public int maxHealth() {
                    return 45;
                }

                @Override
                public String description() {
                    return "Occasionally halves all potions left on the board at the end of turn.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three red potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Red")){
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three blue potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int blues = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Blue")){
                                    blues++;
                                }
                            }
                            yourHealth.damage(blues /3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three green potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int greens = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Green")){
                                    greens++;
                                }
                            }
                            enemyHealth.heal(greens/3);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> add = new ArrayList<>();
                    add.add(codes.get("Black"));
                    add.add(codes.get("White"));
                    add.add(codes.get("Magenta"));
                    add.add(codes.get("Cyan"));
                    add.add(codes.get("Yellow"));
                    opponentDeck.addTemporary(add);
                }

                @Override
                public int difficulty() {
                    return 3;
                }

                @Override
                public int maxHealth() {
                    return 35;
                }

                @Override
                public String description() {
                    return "Clutters your deck with stuff.";
                }
            });
        }
        //4
        {
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three cyan, magenta, or yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Magenta")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per five red, green, or blue potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Blue")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/5);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Gain 1 shield per black or white potion on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Black")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("White")) {
                                    reds++;
                                }
                            }
                            enemyHealth.shield(reds);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 4;
                }

                @Override
                public int maxHealth() {
                    return 60;
                }

                @Override
                public String description() {
                    return "Has attacks that are determined based on multiple colors";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/3);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> add = new ArrayList<>();
                    ArrayList<PotionCode> remove = new ArrayList<>();
                    for (PotionCode p: opponentDeck.permanentDeck) {
                        if (p.text().equals("Yellow")){
                            remove.add(p);
                            add.add(codes.get("Yellow/2"));
                        }
                    }
                    for (int i = 0; i < 5; i++) {
                        add.add(codes.get("Yellow"));
                    }
                    opponentDeck.addTemporary(add);
                    opponentDeck.removeTemporary(remove);
                }

                @Override
                public int difficulty() {
                    return 4;
                }

                @Override
                public int maxHealth() {
                    return 40;
                }

                @Override
                public String description() {
                    return "Halves all your yellow potions and adds more of them. Deals more damage based on yellow potions on the board.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three magenta potions left on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Magenta")){
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Gain 1 shield per two magenta potions left on the board";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t: tiles) {
                                if (t.potion.type.text().equals("Magenta")){
                                    reds++;
                                }
                            }
                            enemyHealth.shield(reds/2);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> add = new ArrayList<>();
                    ArrayList<PotionCode> remove = new ArrayList<>();
                    for (PotionCode p: opponentDeck.permanentDeck) {
                        if (p.text().equals("Magenta")){
                            remove.add(p);
                            add.add(codes.get("Magenta/2"));
                        }
                    }
                    for (int i = 0; i < 5; i++) {
                        add.add(codes.get("Magenta"));
                    }
                    opponentDeck.addTemporary(add);
                    opponentDeck.removeTemporary(remove);
                }

                @Override
                public int difficulty() {
                    return 4;
                }

                @Override
                public int maxHealth() {
                    return 55;
                }

                @Override
                public String description() {
                    return "Halves all your magenta potions and adds more of them. Deals more damage based on magenta potions on the board.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three cyan potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three cyan potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage and gain 1 shield per five cyan potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/5);
                            enemyHealth.shield(reds/5);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> add = new ArrayList<>();
                    ArrayList<PotionCode> remove = new ArrayList<>();
                    for (PotionCode p: opponentDeck.permanentDeck) {
                        if (p.text().equals("Cyan")){
                            remove.add(p);
                            add.add(codes.get("Cyan/2"));
                        }
                    }
                    for (int i = 0; i < 5; i++) {
                        add.add(codes.get("Cyan"));
                    }
                    opponentDeck.addTemporary(add);
                    opponentDeck.removeTemporary(remove);
                }

                @Override
                public int difficulty() {
                    return 4;
                }

                @Override
                public int maxHealth() {
                    return 35;
                }

                @Override
                public String description() {
                    return "Halves all your cyan potions and adds more of them. Deals more damage based on cyan potions on the board.";
                }
            });
        }
        //5
        {
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three cyan, magenta, or yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Magenta")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per five red, green, or blue potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Blue")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/5);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Inverts up to 7 potions randomly";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int transformed = 0;
                            for (Tile t: tiles) {
                                if (Math.random() <= 1/6.0) {
                                    game.remove(t.potion);
                                    t.potion = new Potion(codes.get(switch (t.potion.type.text()) {
                                        case "Red" -> "Cyan";
                                        case "Green" -> "Magenta";
                                        case "Blue" -> "Yellow";
                                        case "Cyan" -> "Red";
                                        case "Magenta" -> "Green";
                                        case "Yellow" -> "Blue";
                                        case "White" -> "Black";
                                        default -> "White";
                                    }), t.coord);
                                    transformed++;
                                    if (transformed > 6) {
                                        return;
                                    }
                                }
                            }
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 5;
                }

                @Override
                public int maxHealth() {
                    return 60;
                }

                @Override
                public String description() {
                    return "A enemy that occasionally inverts potions.";
                }
            });
            enemyOptions.add(new EnemyCode() {
            @Override
            public ArrayList<EnemyAttackCode> attacks() {
                ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                attacks.add(new EnemyAttackCode() {
                    @Override
                    public String description() {
                        return "Heal 1 per two cyan, magenta, or yellow potions on the board.";
                    }

                    @Override
                    public void doStuff(ArrayList<Tile> tiles) {
                        int reds = 0;
                        for (Tile t : tiles) {
                            if (t.potion.type.text().equals("Cyan")) {
                                reds++;
                            }
                            if (t.potion.type.text().equals("Yellow")) {
                                reds++;
                            }
                            if (t.potion.type.text().equals("Magenta")) {
                                reds++;
                            }
                        }
                        enemyHealth.heal(reds/2);
                    }
                });
                attacks.add(new EnemyAttackCode() {
                    @Override
                    public String description() {
                        return "Deal 1 damage per four red, green, or blue potions on the board.";
                    }

                    @Override
                    public void doStuff(ArrayList<Tile> tiles) {
                        int reds = 0;
                        for (Tile t : tiles) {
                            if (t.potion.type.text().equals("Red")) {
                                reds++;
                            }
                            if (t.potion.type.text().equals("Green")) {
                                reds++;
                            }
                            if (t.potion.type.text().equals("Blue")) {
                                reds++;
                            }
                        }
                        yourHealth.damage(reds/4);
                    }
                });
                attacks.add(new EnemyAttackCode() {
                    @Override
                    public String description() {
                        return "Adds a random potion to your deck";
                    }

                    @Override
                    public void doStuff(ArrayList<Tile> tiles) {
                        ArrayList<PotionCode> add = new ArrayList<>();
                        add.add(codes.get(new String[]{"Red","Blue","Green","Yellow","Magenta","White","Black","Cyan"}[(int) (Math.random()*8)]));
                        deck.addTemporary(add);
                    }
                });
                return attacks;
            }

            @Override
            public ShapeCode shape() {
                return PotionPeril.hexagon;
            }

            @Override
            public void dealWithDeck(Deck opponentDeck) {
                ArrayList<PotionCode> add = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    add.add(codes.get(new String[]{"Red","Blue","Green","Yellow","Magenta","White","Black","Cyan"}[(int) (Math.random()*8)]));
                }
                opponentDeck.addTemporary(add);
            }

            @Override
            public int difficulty() {
                return 5;
            }

            @Override
            public int maxHealth() {
                return 75;
            }

            @Override
            public String description() {
                return "A enemy that occasionally adds more stuff to your deck.";
            }
        });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per two cyan, magenta, or yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Magenta")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/2);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three red, green, or blue potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Blue")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Gain 1 shield per white, or black potion on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("White")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Black")) {
                                    reds++;
                                }
                            }
                            enemyHealth.shield(reds);
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 5;
                }

                @Override
                public int maxHealth() {
                    return 80;
                }

                @Override
                public String description() {
                    return "Very strong enemy.";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per two cyan, magenta, or yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Magenta")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/2);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per four red, green, or blue potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Blue")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/4);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Resets the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            for (Tile t: tiles) {
                                game.remove(t.potion);
                                t.potion = null;
                            }
                            game.fillInPotions();
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return PotionPeril.hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {

                }

                @Override
                public int difficulty() {
                    return 5;
                }

                @Override
                public int maxHealth() {
                    return 75;
                }

                @Override
                public String description() {
                    return "A enemy that occasionally resets the board.";
                }
            });
        }
        //6
        {
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per two cyan, magenta, or yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Magenta")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/2);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per two red, green, or blue potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Blue")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/2);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Resets the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            for (Tile t: tiles) {
                                game.remove(t.potion);
                                t.potion = null;
                            }
                            game.fillInPotions();
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Gain 1 shield per white, or black potion on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("White")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Black")) {
                                    reds++;
                                }
                            }
                            enemyHealth.shield(reds);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Adds a random potion to your deck";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            ArrayList<PotionCode> add = new ArrayList<>();
                            add.add(codes.get(new String[]{"Red","Blue","Green","Yellow","Magenta","White","Black","Cyan"}[(int) (Math.random()*8)]));
                            deck.addTemporary(add);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Inverts up to 7 potions randomly";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int transformed = 0;
                            for (Tile t: tiles) {
                                if (Math.random() <= 1/6.0) {
                                    game.remove(t.potion);
                                    t.potion = new Potion(codes.get(switch (t.potion.type.text()) {
                                        case "Red" -> "Cyan";
                                        case "Green" -> "Magenta";
                                        case "Blue" -> "Yellow";
                                        case "Cyan" -> "Red";
                                        case "Magenta" -> "Green";
                                        case "Yellow" -> "Blue";
                                        case "White" -> "Black";
                                        default -> "White";
                                    }), t.coord);
                                    transformed++;
                                    if (transformed > 6) {
                                        return;
                                    }
                                }
                            }
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return hexagon;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> stuff= new ArrayList<>();
                    stuff.add(codes.get("Black/2"));
                    stuff.add(codes.get("White/2"));
                    stuff.add(codes.get("Red/2"));
                    stuff.add(codes.get("Blue/2"));
                    stuff.add(codes.get("Green/2"));
                    stuff.add(codes.get("Yellow/2"));
                    stuff.add(codes.get("Cyan/2"));
                    stuff.add(codes.get("Magenta/2"));
                    opponentDeck.addTemporary(stuff);
                }

                @Override
                public int difficulty() {
                    return 6;
                }

                @Override
                public int maxHealth() {
                    return 125;
                }

                @Override
                public String description() {
                    return "Final boss (hexagon)";
                }
            });
            enemyOptions.add(new EnemyCode() {
                @Override
                public ArrayList<EnemyAttackCode> attacks() {
                    ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Heal 1 per three cyan, magenta, or yellow potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Cyan")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Yellow")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Magenta")) {
                                    reds++;
                                }
                            }
                            enemyHealth.heal(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Deal 1 damage per three red, green, or blue potions on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("Red")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Green")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Blue")) {
                                    reds++;
                                }
                            }
                            yourHealth.damage(reds/3);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Resets the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            for (Tile t: tiles) {
                                game.remove(t.potion);
                                t.potion = null;
                            }
                            game.fillInPotions();
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Gain 1 shield per white, or black potion on the board.";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int reds = 0;
                            for (Tile t : tiles) {
                                if (t.potion.type.text().equals("White")) {
                                    reds++;
                                }
                                if (t.potion.type.text().equals("Black")) {
                                    reds++;
                                }
                            }
                            enemyHealth.shield(reds);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Adds a random potion to your deck";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            ArrayList<PotionCode> add = new ArrayList<>();
                            add.add(codes.get(new String[]{"Red","Blue","Green","Yellow","Magenta","White","Black","Cyan"}[(int) (Math.random()*8)]));
                            deck.addTemporary(add);
                        }
                    });
                    attacks.add(new EnemyAttackCode() {
                        @Override
                        public String description() {
                            return "Inverts up to 5 potions randomly";
                        }

                        @Override
                        public void doStuff(ArrayList<Tile> tiles) {
                            int transformed = 0;
                            for (Tile t: tiles) {
                                if (Math.random() <= 1/6.0) {
                                    game.remove(t.potion);
                                    t.potion = new Potion(codes.get(switch (t.potion.type.text()) {
                                        case "Red" -> "Cyan";
                                        case "Green" -> "Magenta";
                                        case "Blue" -> "Yellow";
                                        case "Cyan" -> "Red";
                                        case "Magenta" -> "Green";
                                        case "Yellow" -> "Blue";
                                        case "White" -> "Black";
                                        default -> "White";
                                    }), t.coord);
                                    transformed++;
                                    if (transformed > 4) {
                                        return;
                                    }
                                }
                            }
                        }
                    });
                    return attacks;
                }

                @Override
                public ShapeCode shape() {
                    return square;
                }

                @Override
                public void dealWithDeck(Deck opponentDeck) {
                    ArrayList<PotionCode> stuff= new ArrayList<>();
                    stuff.add(codes.get("Black"));
                    stuff.add(codes.get("White"));
                    stuff.add(codes.get("Red"));
                    stuff.add(codes.get("Blue"));
                    stuff.add(codes.get("Green"));
                    stuff.add(codes.get("Yellow"));
                    stuff.add(codes.get("Cyan"));
                    stuff.add(codes.get("Magenta"));
                    opponentDeck.addTemporary(stuff);
                }

                @Override
                public int difficulty() {
                    return 6;
                }

                @Override
                public int maxHealth() {
                    return 100;
                }

                @Override
                public String description() {
                    return "Final boss (square)";
                }
            });
        }
    }

    public static RecipeCode getRecipe(int tier){
        int z = (int) (Math.random()*4);
        if (z==0){
            tier--;
        }
        else if (z==3){
            tier++;
        }
        if (tier < 1){
            tier = 1;
        }
        if (tier > 6){
            tier = 6;
        }
        ArrayList<RecipeCode> availableOptions = new ArrayList<>();
        for (RecipeCode r: availableRecipes) {
            if (r.getTier() == tier){
                availableOptions.add(r);
            }
        }
        return availableOptions.get((int) (Math.random()*availableOptions.size()));
    }
    public static DeckModifierCode getDeckModifier(int tier){
        int z = (int) (Math.random()*4);
        if (z==0){
            tier--;
        }
        else if (z==3){
            tier++;
        }
        if (tier < 1){
            tier = 1;
        }
        if (tier > 6){
            tier = 6;
        }
        ArrayList<DeckModifierCode> availableOptions = new ArrayList<>();
        for (DeckModifierCode r: availableModifiers) {
            if (r.getTier() == tier && r.available(PotionPeril.deck)){
                availableOptions.add(r);
            }
        }
        return availableOptions.get((int) (Math.random()*availableOptions.size()));
    }
    public static ArtifactCode getArtifact(){
        return availableArtifacts.get((int) (Math.random()*availableArtifacts.size()));
    }

    public static EnemyCode getEnemy(int tier){
        int z = (int) (Math.random()*4);
        if (tier == 5 && z == 3){
            z--;
        }
        if (z==0){
            tier--;
        }
        else if (z==3){
            tier++;
        }
        if (tier < 1){
            tier = 1;
        }
        if (tier > 6){
            tier = 6;
        }
        ArrayList<EnemyCode> availableOptions = new ArrayList<>();
        for (EnemyCode r: enemyOptions) {
            if (r.difficulty() == tier){
                availableOptions.add(r);
            }
        }
        return availableOptions.get((int) (Math.random()*availableOptions.size()));
    }
}
