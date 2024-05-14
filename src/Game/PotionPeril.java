package Game;

import Classes.BLabel;
import Classes.Coordinate;
import Codes.*;
import Objects.*;
import acm.graphics.*;
import acm.program.GraphicsProgram;
import svu.csc213.Dialog;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

public class PotionPeril extends GraphicsProgram {

    public static int ratioIncrease = 0;

    public static boolean repeatAttacks = false;
    public static double halfAmount = 0.5;
    public static boolean multiplyColors = false;
    public static boolean playable = true;
    public static ArrayList<String> wild = new ArrayList<>();

    public static ArtifactCode removal = new ArtifactCode() {
        @Override
        public void doStuff() {
            artifactPageNum = 0;
            canDisable = false;
            displayRecipePage(true);
        }

        @Override
        public String description() {
            return "Remove a recipe from your deck.";
        }
    };

    public static ArrayList<Tile> tiles = new ArrayList<>();

    public static int tier = 0;

    public static boolean canDisable = true;

    public static boolean switchTier = true;

    public static ArrayList<Tile> tops = new ArrayList<>();
    public static ShapeCode hexagon = new ShapeCode() {
        @Override
        public GPoint getPositionOf(Coordinate c) {
            GPoint p = new GPoint();
            p.setLocation(c.x*38,(c.y+((double)c.x%2/2))*50);
            return p;
        }

        @Override
        public GPolygon getShape() {
            GPolygon g = new GPolygon();
            g.addVertex(12.5,0);
            g.addVertex(37.5,0);
            g.addVertex(50,25);
            g.addVertex(37.5,50);
            g.addVertex(12.5,50);
            g.addVertex(0,25);
            return g;
        }

        @Override
        public boolean isNextTo(Coordinate c1, Coordinate c2) {
            if (c2.x%2==1){
                if (c2.y == c1.y-1){
                    return Math.abs(c1.x - c2.x) < 2;
                }
                else if (c2.y == c1.y){
                    return Math.abs(c1.x - c2.x) == 1;
                }
                else if (c2.y-1 == c1.y){
                    return c1.x == c2.x;
                }
                else{
                    return false;
                }
            }
            else{
                if (c2.y-1 == c1.y){
                    return Math.abs(c1.x - c2.x) < 2;
                }
                else if (c2.y == c1.y){
                    return Math.abs(c1.x - c2.x) == 1;
                }
                else if (c2.y == c1.y-1){
                    return c1.x == c2.x;
                }
                else{
                    return false;
                }
            }
        }

        @Override
        public Coordinate getOffset() {
            return new Coordinate(25,25);
        }

        @Override
        public Coordinate getDimensions() {
            return new Coordinate(9,6);
        }
    };
    public static ShapeCode square = new ShapeCode() {
        @Override
        public GPoint getPositionOf(Coordinate c) {
            GPoint p = new GPoint();
            p.setLocation(c.x*50,c.y*50);
            return p;
        }

        @Override
        public GPolygon getShape() {
            GPolygon g = new GPolygon();
            g.addVertex(0,0);
            g.addVertex(50,0);
            g.addVertex(50,50);
            g.addVertex(0,50);
            return g;
        }

        @Override
        public boolean isNextTo(Coordinate c1, Coordinate c2) {
            if (c1.x == c2.x){
                if (c1.y == c2.y){
                    return false;
                }
                return Math.abs(c1.y - c2.y) < 2;
            }
            else if (c1.y == c2.y){
                return Math.abs(c1.x - c2.x) < 2;
            }
            return false;
        }

        @Override
        public Coordinate getOffset() {
            return new Coordinate(25,25);
        }

        @Override
        public Coordinate getDimensions() {
            return new Coordinate(7,6);
        }
    };

    public static PotionPeril game;

    public static HashMap<String, PotionCode> codes = new HashMap<>();

    static{
        //original
        {
            codes.put("Red", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-10, -10);
                }

                @Override
                public GObject getShape() {
                    GOval object = new GOval(30, 30);
                    object.setFillColor(new Color(255, 0, 0));
                    object.setFilled(true);
                    return object;
                }

                @Override
                public String text() {
                    return "Red";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 0, 0);
                }
            });
            codes.put("Blue", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon p = new GPolygon();
                    p.addVertex(-15, 15);
                    p.addVertex(15, 15);
                    p.addVertex(0, -15);
                    p.setFillColor(new Color(0, 0, 255));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "Blue";
                }

                @Override
                public Color textColor() {
                    return new Color(0, 0, 255);
                }
            });
            codes.put("Green", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-12, -12);
                }

                @Override
                public GObject getShape() {
                    GRect p = new GRect(26, 26);
                    p.setFillColor(new Color(0, 255, 0));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "Green";
                }

                @Override
                public Color textColor() {
                    return new Color(0, 255, 0);
                }
            });
            codes.put("Yellow", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon p = new GPolygon();
                    p.addVertex(0, -15);
                    p.addVertex(14.25, -4.5);
                    p.addVertex(8.75, 12);
                    p.addVertex(-8.75, 12);
                    p.addVertex(-14.25, -4.5);
                    p.setFillColor(new Color(255, 255, 0));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "Yellow";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 255, 0);
                }
            });
            codes.put("Cyan", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-10, -10);
                }

                @Override
                public GObject getShape() {
                    GPolygon g = new GPolygon();
                    g.addVertex(7.5, 0);
                    g.addVertex(22.5, 0);
                    g.addVertex(30, 15);
                    g.addVertex(22.5, 30);
                    g.addVertex(7.5, 30);
                    g.addVertex(0, 15);
                    g.setFilled(true);
                    g.setFillColor(new Color(0, 255, 255));
                    return g;
                }

                @Override
                public String text() {
                    return "Cyan";
                }

                @Override
                public Color textColor() {
                    return new Color(0, 255, 255);
                }
            });
            codes.put("Magenta", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon g = new GPolygon();
                    g.addVertex(5, 15);
                    g.addVertex(-5, 15);
                    g.addVertex(-15, 5);
                    g.addVertex(-15, -5);
                    g.addVertex(-5, -15);
                    g.addVertex(5, -15);
                    g.addVertex(15, -5);
                    g.addVertex(15, 5);
                    g.setFilled(true);
                    g.setFillColor(new Color(255, 0, 255));
                    return g;
                }

                @Override
                public String text() {
                    return "Magenta";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 0, 255);
                }
            });
            codes.put("White", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon p = new GPolygon();
                    p.addVertex(0, -15);
                    p.addVertex(3.5625, -4.875);
                    p.addVertex(14.25, -4.5);
                    p.addVertex(5.75, 1.875);
                    p.addVertex(8.75, 12);
                    p.addVertex(0, 6);
                    p.addVertex(-8.75, 12);
                    p.addVertex(-5.25, 1.875);
                    p.addVertex(-14.25, -4.5);
                    p.addVertex(-3.5625, -4.875);
                    p.setFillColor(new Color(255, 255, 255));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "White";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 255, 255);
                }
            });
            codes.put("Black", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon g = new GPolygon();
                    g.setColor(Color.white);
                    g.addVertex(-7.5, -15);
                    g.addVertex(-3.75, -7.5);
                    g.addVertex(7.5, -15);
                    g.addVertex(3.75, -7.5);
                    g.addVertex(15, 0);
                    g.addVertex(7.5, 0);
                    g.addVertex(7.5, 15);
                    g.addVertex(3.75, 7.5);
                    g.addVertex(-7.5, 15);
                    g.addVertex(-3.75, 7.5);
                    g.addVertex(-15, 0);
                    g.addVertex(-7.5, 0);
                    g.setFilled(true);
                    g.setFillColor(new Color(0, 0, 0));
                    return g;
                }

                @Override
                public String text() {
                    return "Black";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 255, 255);
                }
            });
        }
        //1/2 original
        {
            codes.put("Red/2", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-10, -10);
                }

                @Override
                public GObject getShape() {
                    GArc object = new GArc(30, 30, 180, 180);
                    object.setFillColor(new Color(255, 0, 0));
                    object.setFilled(true);
                    return object;
                }

                @Override
                public String text() {
                    return "Red";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 0, 0);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
            codes.put("Blue/2", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon p = new GPolygon();
                    p.addVertex(-15, 15);
                    p.addVertex(15, 15);
                    p.addVertex(7.5, 0);
                    p.addVertex(-7.5, 0);
                    p.setFillColor(new Color(0, 0, 255));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "Blue";
                }

                @Override
                public Color textColor() {
                    return new Color(0, 0, 255);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
            codes.put("Green/2", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-12, -25);
                }

                @Override
                public GObject getShape() {
                    GRect p = new GRect(26, 13);
                    p.setFillColor(new Color(0, 255, 0));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "Green";
                }

                @Override
                public Color textColor() {
                    return new Color(0, 255, 0);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
            codes.put("Yellow/2", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon p = new GPolygon();
                    p.addVertex(14.25, -4.5);
                    p.addVertex(9.5, 9.75);
                    p.addVertex(-9.5, 9.75);
                    p.addVertex(-14.25, -4.5);
                    p.setFillColor(new Color(255, 255, 0));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "Yellow";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 255, 0);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
            codes.put("Cyan/2", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-10, -10);
                }

                @Override
                public GObject getShape() {
                    GPolygon g = new GPolygon();
                    g.addVertex(30, 15);
                    g.addVertex(22.5, 30);
                    g.addVertex(7.5, 30);
                    g.addVertex(0, 15);
                    g.setFilled(true);
                    g.setFillColor(new Color(0, 255, 255));
                    return g;
                }

                @Override
                public String text() {
                    return "Cyan";
                }

                @Override
                public Color textColor() {
                    return new Color(0, 255, 255);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
            codes.put("Magenta/2", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon g = new GPolygon();
                    g.addVertex(5, 15);
                    g.addVertex(-5, 15);
                    g.addVertex(-15, 5);
                    g.addVertex(-15, 0);
                    g.addVertex(15, 0);
                    g.addVertex(15, 5);
                    g.setFilled(true);
                    g.setFillColor(new Color(255, 0, 255));
                    return g;
                }

                @Override
                public String text() {
                    return "Magenta";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 0, 255);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
            codes.put("White/2", new PotionCode() {

                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon p = new GPolygon();
                    p.addVertex(10.5, -1.5);
                    p.addVertex(5.75, 1.875);
                    p.addVertex(8.75, 12);
                    p.addVertex(0, 6);
                    p.addVertex(-8.75, 12);
                    p.addVertex(-5.25, 1.875);
                    p.addVertex(-10.5, -1.5);
                    p.setFillColor(new Color(255, 255, 255));
                    p.setFilled(true);
                    return p;
                }

                @Override
                public String text() {
                    return "White";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 255, 255);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
            codes.put("Black/2", new PotionCode() {
                @Override
                public Coordinate getOffset() {
                    return new Coordinate(-25, -25);
                }

                @Override
                public GObject getShape() {
                    GPolygon g = new GPolygon();
                    g.setColor(Color.white);
                    g.addVertex(15, 0);
                    g.addVertex(7.5, 0);
                    g.addVertex(7.5, 15);
                    g.addVertex(3.75, 7.5);
                    g.addVertex(-7.5, 15);
                    g.addVertex(-3.75, 7.5);
                    g.addVertex(-15, 0);
                    g.addVertex(-7.5, 0);
                    g.setFilled(true);
                    g.setFillColor(new Color(0, 0, 0));
                    return g;
                }

                @Override
                public String text() {
                    return "Black";
                }

                @Override
                public Color textColor() {
                    return new Color(255, 255, 255);
                }

                @Override
                public double amount() {
                    return halfAmount;
                }
            });
        }
    }
    public static Deck deck;

    public static ArrayList<RecipeCode> recipeBook = new ArrayList<>();
    public static ArrayList<ArtifactCode> artifacts = new ArrayList<>();

    static{
        recipeBook.add(new RecipeCode() {
            @Override
            public HashMap<String, Integer> requirements() {
                HashMap<String,Integer> hashMap = new HashMap<>();
                hashMap.put("Red",1);
                hashMap.put("Blue",2);
                return hashMap;
            }

            @Override
            public String description() {
                return "Increases shield by x";
            }

            @Override
            public void doStuff(int ratio) {
                yourHealth.shield(ratio);
            }
        });
        recipeBook.add(new RecipeCode() {
            @Override
            public HashMap<String, Integer> requirements() {
                HashMap<String,Integer> hashMap = new HashMap<>();
                hashMap.put("Green",2);
                hashMap.put("Red",1);
                return hashMap;
            }

            @Override
            public String description() {
                return "Heals you for 2x";
            }

            @Override
            public void doStuff(int ratio) {
                yourHealth.heal(ratio*2);
            }
        });
        recipeBook.add(new RecipeCode() {
            @Override
            public HashMap<String, Integer> requirements() {
                HashMap<String,Integer> hashMap = new HashMap<>();
                hashMap.put("Red",2);
                hashMap.put("Green",1);
                return hashMap;
            }

            @Override
            public String description() {
                return "Deals x damage";
            }

            @Override
            public void doStuff(int ratio) {
                enemyHealth.damage(ratio);
            }
        });
        recipeBook.add(new RecipeCode() {
            @Override
            public HashMap<String, Integer> requirements() {
                HashMap<String,Integer> hashMap = new HashMap<>();
                hashMap.put("Red",2);
                hashMap.put("Blue",1);
                return hashMap;
            }

            @Override
            public String description() {
                return "Deals x damage";
            }

            @Override
            public void doStuff(int ratio) {
                enemyHealth.damage(ratio);
            }
        });
        recipeBook.add(new RecipeCode() {
            @Override
            public HashMap<String, Integer> requirements() {
                HashMap<String,Integer> hashMap = new HashMap<>();
                hashMap.put("Red",1);
                hashMap.put("Green",1);
                hashMap.put("Blue",1);
                return hashMap;
            }

            @Override
            public String description() {
                return "Deals x damage and heals x for each 5 points of shield (minimum 1)";
            }

            @Override
            public void doStuff(int ratio) {
                enemyHealth.damage(ratio*((yourHealth.shield/5)+1));
                yourHealth.heal(ratio*((yourHealth.shield/5)+1));
            }
        });
    }
    public static ArrayList<Potion> selected = new ArrayList<>();

    public static ArrayList<GObject> side = new ArrayList<>();

    public static boolean isEnabled = false;
    public static GCompound goButton = new GCompound();
    public static GCompound deckButton = new GCompound();
    public static GCompound recipesButton = new GCompound();
    public static GCompound artifactsButton = new GCompound();
    public static GCompound deckDisplay;
    public static GCompound recipesDisplay;
    public static GCompound artifactDisplay;
    public static int recipePageNum = 0;
    public static int artifactPageNum = 0;
    public static GCompound refreshButton = new GCompound();
    public static GCompound refreshBoardButton = new GCompound();
    public static int refreshes = 1;
    public static int defaultRefreshes = 1;
    public static int refreshBoardCharges = 0;
    public static int chargesNeeded = 5;

    public static Recipe currentRecipe;
    public static RecipeCode currentRecipeCode;
    public static EnemyAttackCode currentAttackCode;
    public static EnemyAttack currentAttack;

    public static HealthBar yourHealth;
    public static HealthBar enemyHealth;

    public static EnemyCode enemyCode;
    public static EnemyCode baseEnemy = new EnemyCode() {
        @Override
        public ArrayList<EnemyAttackCode> attacks() {
            ArrayList<EnemyAttackCode> attacks = new ArrayList<>();
            attacks.add(new EnemyAttackCode() {
                @Override
                public String description() {
                    return "Deal 1 damage per five red potions left on the board.";
                }

                @Override
                public void doStuff(ArrayList<Tile> tiles) {
                    int reds = 0;
                    for (Tile t: tiles) {
                        if (t.potion.type.text().equals("Red")){
                            reds++;
                        }
                    }
                    yourHealth.damage(reds/5);
                }
            });
            attacks.add(new EnemyAttackCode() {
                @Override
                public String description() {
                    return "Deal 1 damage per five blue potions left on the board.";
                }

                @Override
                public void doStuff(ArrayList<Tile> tiles) {
                    int blues = 0;
                    for (Tile t: tiles) {
                        if (t.potion.type.text().equals("Blue")){
                            blues++;
                        }
                    }
                    yourHealth.damage(blues /5);
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
            return attacks;
        }

        @Override
        public ShapeCode shape() {
            return hexagon;
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
            return "Basic enemy with 10 health";
        }
    };

    public static int ratio;

    public static void main(String[] args) {
        new PotionPeril().start();
    }

    public void initialize(){
        initializeStatics();
        setBackground(new Color(56, 56, 56));
        //goButton
        {
            GRect r = new GRect(30, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(255, 0, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Go");
            l.setColor(r.getColor());
            goButton.add(r);
            goButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            add(goButton, 475, 425);
            goButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (isEnabled) {
                        isEnabled = false;
                        go();
                    }
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
        //refreshButton
        {
            GRect r = new GRect(50, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Refresh");
            l.setColor(r.getColor());
            refreshButton.add(r);
            refreshButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            add(refreshButton, 200-refreshButton.getWidth()/2, 350);
            refreshButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (refreshes>0) {
                        configCurrentRecipe();
                        refreshes--;
                        r.setFillColor(refreshes > 0 ? new Color(0,255,0):new Color(255,0,0));
                    }
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
        //refreshBoardButton
        {
            GRect r = new GRect(100, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(255, 0, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Refresh Board");
            l.setColor(r.getColor());
            refreshBoardButton.add(r);
            refreshBoardButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            add(refreshBoardButton, 200-refreshBoardButton.getWidth()/2, 375);
            refreshBoardButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (refreshBoardCharges >= chargesNeeded) {
                        refreshBoardCharges -= chargesNeeded;
                        for (Tile t : tiles) {
                            if (t.potion != null) {
                                game.remove(t.potion);
                            }
                            t.potion = null;
                        }
                        fillInPotions();
                        r.setFillColor(refreshBoardCharges >= chargesNeeded ? new Color(0,255,0) : new Color(255,0,0));
                    }
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
        //deckButton
        {
            GRect r = new GRect(30, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Deck");
            l.setColor(r.getColor());
            deckButton.add(r);
            deckButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            add(deckButton, 475, 25);
            deckButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (deckDisplay == null){
                        deckDisplay = deck.display();
                        add(deckDisplay,485-deckDisplay.getWidth()/2,100);
                        r.setFillColor(Color.red);
                    }
                    else{
                        remove(deckDisplay);
                        deckDisplay = null;
                        r.setFillColor(Color.green);
                    }
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
        //recipeButton
        {
            GRect r = new GRect(80, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Recipe Book");
            l.setColor(r.getColor());
            recipesButton.add(r);
            recipesButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            add(recipesButton, 375, 25);
            recipesButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (recipesDisplay == null){
                        recipePageNum = 0;
                        displayRecipePage(false);
                        r.setFillColor(Color.red);
                    }
                    else if (canDisable){
                        remove(recipesDisplay);
                        recipesDisplay = null;
                        r.setFillColor(Color.green);
                    }
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
        //artifactButton
        {
            GRect r = new GRect(60, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Artifacts");
            l.setColor(r.getColor());
            artifactsButton.add(r);
            artifactsButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            add(artifactsButton, 525, 25);
            artifactsButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (artifactDisplay == null){
                        artifactPageNum = 0;
                        displayArtifactPage();
                        r.setFillColor(Color.red);
                    }
                    else{
                        remove(artifactDisplay);
                        artifactDisplay = null;
                        r.setFillColor(Color.green);
                    }
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
        ArrayList<PotionCode> newDeck = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            newDeck.add(codes.get("Blue"));
        }
        for (int i = 0; i < 5; i++) {
            newDeck.add(codes.get("Green"));
        }
        for (int i = 0; i < 10; i++) {
            newDeck.add(codes.get("Red"));
        }
        deck = new Deck(newDeck);
        //healthBars
        {
            yourHealth = new HealthBar(100);
            add(yourHealth,110,25);
            BLabel health = new BLabel("Your  Health",6);
            health.setColor(Color.green);
            add(health,110,10);
            BLabel otherHealth = new BLabel("Opponent's Health",11);
            otherHealth.setColor(Color.red);
            add(otherHealth,710,10);
        }
    }
    public static void go(){
        new Thread(()->{
            currentRecipeCode.doStuff((ratio+ratioIncrease)*(multiplyColors ? currentRecipeCode.requirements().size() : 1));
            if (repeatAttacks){
                currentRecipeCode.doStuff((1+ratioIncrease)*(multiplyColors ? currentRecipeCode.requirements().size() : 1));
            }
        }).start();
        new Thread(()->{
            game.pause(2000);
            enemyHealth.nextTurn();
            refreshBoardCharges++;
            if (refreshBoardCharges>=chargesNeeded){
                ((GRect)refreshBoardButton.getElement(0)).setFillColor(Color.green);
            }
            if (enemyHealth.health < 1) {
                moveOn();
                return;
            }
            if (yourHealth.health < 1) {
                Dialog.showMessage("You lose!");
                game.exit();
            }
            currentAttackCode.doStuff(tiles);
            refreshes = defaultRefreshes;
            configCurrentRecipe();
        }).start();
        new Thread(()->{
            game.pause(1000);
            for (Potion p : selected) {
                p.tile.potion = null;
                Tile.selected.remove(p.tile.coord);
                game.remove(p);
            }
            selected = new ArrayList<>();
            updateSelected();
            new Thread(game::fillInPotions).start();
            yourHealth.nextTurn();
        }).start();
    }

    public void run(){
        game = this;
        TitleScreen.run();
    }
    public void startLevel() {
        enemyCode.dealWithDeck(deck);
        refreshes = defaultRefreshes;
        configCurrentRecipe();
        createMap(enemyCode.shape());
        fillInPotions();
        if (enemyHealth!=null){
            remove(enemyHealth);
        }
        enemyHealth = new HealthBar(enemyCode.maxHealth());
        enemyHealth.enemy = true;
        add(enemyHealth,710,25);
        playable = true;
    }

    public void initializeStatics(){
        Tile.game = this;
        Potion.game = this;
        Tile.offset = new Coordinate(300,50);
        Recipe.codes = codes;
        enemyCode = baseEnemy;
        GameStuff.codes =codes;
    }


    public void createMap(ShapeCode code){
        while (!tiles.isEmpty()){
            remove(tiles.get(0));
            tiles.remove(0);
        }
        while (!tops.isEmpty()){
            tops.remove(0);
        }
        Coordinate.shapeCode = code;
        Tile.shapeCode = code;
        Potion.shapeCode = code;
        Coordinate size = code.getDimensions();
        for (int i = 0; i < size.x; i++) {
            Tile prevTile =null;
            for (int j = 0; j < size.y; j++) {
                tiles.add(new Tile(new Coordinate(i,j)));
                if (prevTile == null){
                    tops.add(tiles.getLast());
                }
                else {
                    prevTile.under = tiles.getLast();
                }
                prevTile = tiles.getLast();
            }
        }
    }

    public static void updateSelected(){
        selected = new ArrayList<>();
        for (Tile t: tiles) {
            t.configureSelected();
            if (Tile.selected.contains(t.coord)){
                selected.add(t.potion);
            }
        }
        HashMap<String,Double> potionNums = new HashMap<>();
        for (Potion p: selected) {
            if (potionNums.containsKey(p.type.text())){
                potionNums.put(p.type.text(),potionNums.get(p.type.text())+p.type.amount());
            }
            else{
                potionNums.put(p.type.text(),p.type.amount());
            }
        }
        for (GObject g: side) {
            game.remove(g);
        }
        side = new ArrayList<>();
        int i = 0;
        for (String t: potionNums.keySet()) {
            GObject j = codes.get(t).getShape();
            side.add(j);
            game.add(j,new Coordinate(675,(i*50)+100).subtract(codes.get(t).getOffset()).toPoint());
            GLabel l = new GLabel(t + ": " + potionNums.get(t));
            l.setColor(codes.get(t).textColor());
            game.add(l,725,(i*50)+125);
            side.add(l);
            i++;
        }


        ((GRect)goButton.getElement(0)).setFillColor(new Color(255,0,0));
        isEnabled = false;
        double ratio =0;
        double wilds= 0;
        double totalRecipeSize = 0;
        for (String key: potionNums.keySet()) {
            if (wild.contains(key)){
                wilds+=potionNums.get(key);
            }
            else if (currentRecipeCode.requirements().containsKey(key)) {
                double newRatio = potionNums.get(key) / currentRecipeCode.requirements().get(key);
                if (ratio < newRatio) {
                    ratio = newRatio;
                }
            }
            else{
                ratio = 0.1;
                break;
            }
        }
        for (String key: currentRecipeCode.requirements().keySet()) {
            totalRecipeSize += currentRecipeCode.requirements().get(key);
            double needed = currentRecipeCode.requirements().get(key) * ratio;
            if (!wild.contains(key) && potionNums.containsKey(key)) {
                wilds -= needed - potionNums.get(key);
            }
            else{
                wilds -= needed;
            }
        }
        if ((ratio%1==0 || ratio == 0) && (wilds % totalRecipeSize == 0 || wilds == 0) && wilds >= 0){
            isEnabled = true;
            ((GRect)goButton.getElement(0)).setFillColor(new Color(0,255,0));
            PotionPeril.ratio= (int) (ratio + (wilds/totalRecipeSize));
        }



    }
    public void fillInPotions(){
        boolean isFull = false;
        while (!isFull) {
            isFull = true;
            for (Tile t : tops) {
                t.fall();
                pause(1);
                if (t.potion == null) {
                    PotionCode p = deck.draw();
                    t.potion = new Potion(p, t.coord);
                    t.potion.tile = t;
                    isFull = false;
                }
            }
            pause(100);
        }
    }

    public static void configCurrentRecipe(){
        RecipeCode pastRecipeCode = currentRecipeCode;
        while (currentRecipeCode == pastRecipeCode) {
            currentRecipeCode = recipeBook.get((int) (recipeBook.size() * Math.random()));
        }
        if (currentRecipe != null) {
            game.remove(currentRecipe);
        }
        currentRecipe = new Recipe(currentRecipeCode);
        game.add(currentRecipe,290-currentRecipe.getWidth(),currentRecipe.getHeight()/2);
        ((GRect)refreshButton.getElement(0)).setFillColor(new Color(0,255,0));
        currentAttackCode = enemyCode.attacks().get((int)(enemyCode.attacks().size()*Math.random()));
        if (currentAttack != null) {
            game.remove(currentAttack);
        }
        currentAttack = new EnemyAttack(currentAttackCode);
        game.add(currentAttack,900-currentAttack.getWidth()/2,currentAttack.getHeight()/2);
    }

    public static void moveOn(){
        refreshBoardCharges = 0;
        ((GRect)refreshBoardButton.getElement(0)).setFillColor(Color.red);
        int tier = enemyCode.difficulty();
        deck.resetAll();
        for (Tile t : tiles) {
            if (t.potion != null) {
                game.remove(t.potion);
            }
            t.potion = null;
        }
        playable = false;
        GRect cover = new GRect(600,300);
        cover.setFillColor(Color.white);
        cover.setFilled(true);
        game.add(cover,490-cover.getWidth()/2,250-cover.getHeight()/2);
        cover.sendToFront();
        GCompound r;
        if (recipeBook.size() > 1 && Math.random() < 0.3){
            r = new Artifact(removal);
        }
        else {
            r = new Recipe(GameStuff.getRecipe(tier));
        }
        DeckModifier d = new DeckModifier(GameStuff.getDeckModifier(tier));
        Artifact a = new Artifact(GameStuff.getArtifact());
        game.add(r,490-cover.getWidth()/3-r.getWidth()/2,112.5);
        game.add(d,490-d.getWidth()/2,112.5);
        game.add(a,490+cover.getWidth()/3-a.getWidth()/2,112.5);
        GCompound skipButton = new GCompound();
        r.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (r instanceof Recipe) {
                    recipeBook.add(((Recipe) r).code);
                }
                else{
                    ((Artifact)r).code.doStuff();
                }
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                moveOn2(1);
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
        d.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deck.addPermanent(d.code.addToDeck());
                deck.removePermanent(d.code.removeFromDeck());
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                moveOn2(2);
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
        a.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a.code.doStuff();
                artifacts.add(a.code);
                GameStuff.availableArtifacts.remove(a.code);
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                moveOn2(3);
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
        GRect z = new GRect(30, 20);
        z.setColor(new Color(0,0,0));
        z.setFillColor(new Color(255,0,0));
        z.setFilled(true);
        GLabel l = new GLabel("Skip");
        l.setColor(z.getColor());
        skipButton.add(z);
        z.sendToFront();
        l.sendToFront();
        skipButton.add(l, z.getWidth() / 2 - l.getWidth() / 2, z.getHeight());
        game.add(skipButton, 490-skipButton.getWidth()/2, 137.5+r.getHeight()-z.getHeight()/2);
        skipButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                moveOn2(0);
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
    public static void moveOn2(int chosen){
        if (!canDisable){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new Thread(() -> moveOn2(chosen)).start();
            return;
        }
        int tier = enemyCode.difficulty();
        deck.resetAll();
        for (Tile t : tiles) {
            if (t.potion != null) {
                game.remove(t.potion);
            }
            t.potion = null;
        }
        playable = false;
        GRect cover = new GRect(600,300);
        cover.setFillColor(Color.white);
        cover.setFilled(true);
        game.add(cover,490-cover.getWidth()/2,250-cover.getHeight()/2);
        cover.sendToFront();
        GCompound r;
        if (recipeBook.size() > 1 && Math.random() < 0.3){
            r = new Artifact(removal);
        }
        else {
            r = new Recipe(GameStuff.getRecipe(tier));
        }
        DeckModifier d = new DeckModifier(GameStuff.getDeckModifier(tier));
        Artifact a = new Artifact(GameStuff.getArtifact());
        game.add(r,490-cover.getWidth()/3-r.getWidth()/2,112.5);
        game.add(d,490-d.getWidth()/2,112.5);
        game.add(a,490+cover.getWidth()/3-a.getWidth()/2,112.5);
        GCompound skipButton = new GCompound();
        r.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (r instanceof Recipe) {
                    recipeBook.add(((Recipe) r).code);
                }
                else{
                    ((Artifact)r).code.doStuff();
                }
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                chooseEnemy();
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
        d.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                deck.addPermanent(d.code.addToDeck());
                deck.removePermanent(d.code.removeFromDeck());
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                chooseEnemy();
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
        a.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                a.code.doStuff();
                artifacts.add(a.code);
                GameStuff.availableArtifacts.remove(a.code);
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                chooseEnemy();
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
        GRect z = new GRect(30, 20);
        z.setColor(new Color(0,0,0));
        z.setFillColor(new Color(255,0,0));
        z.setFilled(true);
        GLabel l = new GLabel("Skip");
        l.setColor(z.getColor());
        skipButton.add(z);
        z.sendToFront();
        l.sendToFront();
        skipButton.add(l, z.getWidth() / 2 - l.getWidth() / 2, z.getHeight());
        game.add(skipButton, 490-skipButton.getWidth()/2, 137.5+r.getHeight()-z.getHeight()/2);
        skipButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                game.remove(r);
                game.remove(d);
                game.remove(a);
                game.remove(cover);
                game.remove(skipButton);
                chooseEnemy();
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
        switch (chosen){
            case 1 -> {
                cover.setSize(400,300);
                game.remove(r);
                cover.setLocation(490-cover.getWidth()/2,250-cover.getHeight()/2);
                d.setLocation(490-cover.getWidth()/4-d.getWidth()/2,112.5);
                a.setLocation(490+cover.getWidth()/4-a.getWidth()/2,112.5);
            }
            case 2 -> {
                cover.setSize(400,300);
                game.remove(d);
                cover.setLocation(490-cover.getWidth()/2,250-cover.getHeight()/2);
                r.setLocation(490-cover.getWidth()/4-r.getWidth()/2,112.5);
                a.setLocation(490+cover.getWidth()/4-a.getWidth()/2,112.5);
            }
            case 3 -> {
                cover.setSize(400,300);
                game.remove(a);
                cover.setLocation(490-cover.getWidth()/2,250-cover.getHeight()/2);
                r.setLocation(490-cover.getWidth()/4-r.getWidth()/2,112.5);
                d.setLocation(490+cover.getWidth()/4-d.getWidth()/2,112.5);
            }
        }
    }
    public static void chooseEnemy(){
        if (!canDisable){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new Thread(PotionPeril::chooseEnemy).start();
            return;
        }
        if (switchTier){
            tier++;
        }
        switchTier = !switchTier;
        GRect cover = new GRect(400,250);
        cover.setFillColor(Color.white);
        cover.setFilled(true);
        game.add(cover,490-cover.getWidth()/2,225-cover.getHeight()/2);
        Enemy enemy1 = new Enemy(GameStuff.getEnemy(tier));
        Enemy enemy2 = new Enemy(GameStuff.getEnemy(tier));
        game.add(enemy1,315,112.5);
        game.add(enemy2,510,112.5);
        enemy1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enemyCode = enemy1.code;
                GameStuff.enemyOptions.remove(enemyCode);
                game.remove(cover);
                game.remove(enemy1);
                game.remove(enemy2);
                game.startLevel();
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
        enemy2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                enemyCode = enemy2.code;
                GameStuff.enemyOptions.remove(enemyCode);
                game.remove(cover);
                game.remove(enemy1);
                game.remove(enemy2);
                game.startLevel();
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
    public static void displayRecipePage(boolean remove){
        if (recipesDisplay != null) {
            game.remove(recipesDisplay);
        }
        recipesDisplay = new GCompound();
        GRect cover = new GRect(800,300);
        cover.setFillColor(Color.white);
        cover.setFilled(true);
        recipesDisplay.add(cover,490-cover.getWidth()/2,250-cover.getHeight()/2);
        cover.sendToFront();
        double height = 0;
        for (int i = 0; i < 4; i++) {
            if (recipeBook.size() > (recipePageNum*4)+i){
                RecipeCode rc = recipeBook.get((recipePageNum*4)+i);
                Recipe r = new Recipe(rc);
                height = r.getHeight();
                if (remove){
                    r.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            recipeBook.remove(rc);
                            game.remove(recipesDisplay);
                            recipesDisplay = null;
                            canDisable = true;
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
                recipesDisplay.add(r,500-((i-1)*cover.getWidth()/4),112.5);
                r.sendToFront();
            }
        }
        if (recipePageNum != 0) {
            GCompound previousButton = new GCompound();
            GRect r = new GRect(80, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Previous Page");
            l.setColor(r.getColor());
            previousButton.add(r);
            previousButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            recipesDisplay.add(previousButton, 490-previousButton.getWidth()*3/2, 137.5+height-r.getHeight()/2);
            previousButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    recipePageNum--;
                    displayRecipePage(remove);
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
        if (recipePageNum != ((recipeBook.size()+3)/4)-1) {
            GCompound nextButton = new GCompound();
            GRect r = new GRect(80, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Next Page");
            l.setColor(r.getColor());
            nextButton.add(r);
            nextButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            recipesDisplay.add(nextButton, 490+nextButton.getWidth()*3/2, 137.5+height-r.getHeight()/2);
            nextButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    recipePageNum++;
                    displayRecipePage(remove);
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
        game.add(recipesDisplay);
    }
    public static void displayArtifactPage(){
        if (artifactDisplay != null) {
            game.remove(artifactDisplay);
        }
        artifactDisplay = new GCompound();
        GRect cover = new GRect(800,300);
        cover.setFillColor(Color.white);
        cover.setFilled(true);
        artifactDisplay.add(cover,490-cover.getWidth()/2,250-cover.getHeight()/2);
        cover.sendToFront();
        double height = 0;
        for (int i = 0; i < 4; i++) {
            if (artifacts.size() > (artifactPageNum*4)+i){
                ArtifactCode rc = artifacts.get((artifactPageNum*4)+i);
                Artifact r = new Artifact(rc);
                height = r.getHeight();
                artifactDisplay.add(r,500-((i-1)*cover.getWidth()/4),112.5);
                r.sendToFront();
            }
        }
        if (artifactPageNum != 0) {
            GCompound previousButton = new GCompound();
            GRect r = new GRect(80, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Previous Page");
            l.setColor(r.getColor());
            previousButton.add(r);
            previousButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            artifactDisplay.add(previousButton, 490-previousButton.getWidth()*3/2, 137.5+height-r.getHeight()/2);
            previousButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    artifactPageNum--;
                    displayArtifactPage();
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
        if (artifactPageNum < ((artifacts.size()+3)/4)-1) {
            GCompound nextButton = new GCompound();
            GRect r = new GRect(80, 20);
            r.setColor(new Color(255, 255, 255));
            r.setFillColor(new Color(0, 255, 0));
            r.setFilled(true);
            GLabel l = new GLabel("Next Page");
            l.setColor(r.getColor());
            nextButton.add(r);
            nextButton.add(l, r.getWidth() / 2 - l.getWidth() / 2, r.getHeight());
            artifactDisplay.add(nextButton, 490+nextButton.getWidth()*3/2, 137.5+height-r.getHeight()/2);
            nextButton.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    artifactPageNum++;
                    displayArtifactPage();
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
        game.add(artifactDisplay);
    }
}