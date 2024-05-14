package Objects;

import Game.PotionPeril;
import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GRect;

import java.awt.*;

public class HealthBar extends GCompound {

    public int maxHealth;
    public static boolean overHealDamage = false;
    public static int enemyPoison = 0;
    public int health;
    public int shield;
    public int poison;
    public boolean enemy = false;

    GRect healthBar;
    GRect shieldBar;
    GRect damageBar;
    GLabel healthLabel;
    public HealthBar(int maxHealth){
        this.maxHealth = maxHealth;
        health = maxHealth;
        shield = 0;
        healthBar = new GRect(150,30);
        shieldBar = new GRect(0,30);
        damageBar = new GRect(150,30);
        add(healthBar);
        add(shieldBar,0,30);
        add(damageBar);
        healthBar.setFillColor(Color.green);
        shieldBar.setFillColor(Color.blue);
        damageBar.setFillColor(Color.red);
        healthBar.setFilled(true);
        damageBar.setFilled(true);
        shieldBar.setFilled(true);
        healthLabel = new GLabel((health+shield) + "/" + maxHealth);
        add(healthLabel,0,healthLabel.getHeight()+10);
        damageBar.sendToBack();
    }
    public void damage(int damage){
        if (enemy){
            poison(enemyPoison);
        }
        if (shield-damage > 0){
            double shieldWidth = shieldBar.getWidth()*(double)(shield-damage)/shield;
            double shieldChange = shieldBar.getWidth()*(double)damage/shield;
            shield -= damage;
            for (int i = 0; i <= 50; i++) {
                shieldBar.setSize((shieldChange*(50-i)/50)+shieldWidth,30);
                pause(10);
            }
        }
        else {
            damage = damage-shield;
            double shieldChange = shieldBar.getWidth();
            double healthWidth = healthBar.getWidth()*(double)(health-damage)/health;
            double healthChange = healthBar.getWidth()*(double)damage/health;
            health -= damage;
            shield = 0;
            for (int i = 0; i <= 50; i++) {
                shieldBar.setSize((shieldChange*(50-i))/50,30);
                healthBar.setSize((healthChange*(50-i)/50)+healthWidth,30);
                pause(10);
            }
        }
        healthLabel.setLabel((health+shield) + "/" + maxHealth);
    }
    public void poison(int poison){
        this.poison += poison;
    }
    public void heal(int heal){
        if (!enemy &&overHealDamage){
            if ((maxHealth-health)-heal > 0){
                PotionPeril.enemyHealth.damage(((maxHealth-health)-heal)/3);
            }
        }
        heal = Integer.min(heal,maxHealth-health);
        double healthWidth = ((double) (150 * (heal+health)) /maxHealth);
        double healthChange = ((double) (150*health)/maxHealth)-((double) (150 * (heal+health)) /maxHealth);
        health += heal;
        for (int i = 0; i <= 50; i++) {
            healthBar.setSize((healthChange*(50-i)/50)+healthWidth,30);
            pause(10);
        }
        healthLabel.setLabel((health+shield) + "/" + maxHealth);
    }
    public void shield(int shield){
        double shieldWidth = ((double) (150 * (this.shield+shield)) /maxHealth);
        double shieldChange = -((double) (150 * (this.shield+shield)) /maxHealth)+((double) (150 * (this.shield)) /maxHealth);
        this.shield += shield;
        for (int i = 0; i <= 50; i++) {
            shieldBar.setSize((shieldChange*(50-i)/50)+shieldWidth,30);
            pause(10);
        }
        healthLabel.setLabel((health+shield) + "/" + maxHealth);
    }
    public void nextTurn(){
        damage(poison);
        poison -= 3;
        if (poison < 0){
            poison = 0;
        }
    }
}
