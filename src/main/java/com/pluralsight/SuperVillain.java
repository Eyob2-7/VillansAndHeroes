package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperVillain extends SuperPerson{

    public SuperVillain(String name, int health,int evilLevel) throws InterruptedException {
        super(name, health);
        this.experiencePoints = evilLevel;

        // let the world know the hero now exists
        Thread.sleep(1000);
        System.out.println("🤡"+this.name + " has arrived with a power level of " + evilLevel +"XP");
        System.out.println("<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }
    @Override
    public int fight(SuperPerson opponent){
        System.out.println("\nYou can't spell slaughter without laughter!");

        int baseDamage =  new Random().nextInt(21);
        int evilBoost = this.experiencePoints / 2;
        int damage = baseDamage + evilBoost;

        if (this.health < 60 && !powerUps.isEmpty()) {

            //create a new list of just the keys from the HashMap (glove, hammer, etc....)
            List<String> items = new ArrayList<String>(powerUps.keySet());

            //get a random item name from the above list we just made and store it in random Item
            String randomItem = items.get(new Random().nextInt(items.size()));

            //get the point value for that item from the inventory HashMap
            //bonus would be the int that represents the damage the item will do.
            int bonus = powerUps.get(randomItem);
            System.out.println("🤡 " + this.name + " uses evil " + randomItem + " for +" + bonus + " damage!");
            damage += bonus;
        }

        if (baseDamage == 0){
            System.out.println(this.name + " missed");
        }else{
            System.out.println(this.name + " attacks " + opponent.name+ " with evil energy for " + damage + " damage");
            opponent.takeDamage(damage);
            logHit(opponent);

        }
        return damage;
    }
}
