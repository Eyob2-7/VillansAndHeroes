package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SuperHero extends SuperPerson {

    public SuperHero(String name, int health, int powerlevel) throws InterruptedException {
        super(name, health);

        //in the parent we default power level (XP) to 0
        // for our superhero we want to have them pass in power level
        //but just use that as xp
        this.experiencePoints = powerlevel;

        // let the world know the hero now exists
        Thread.sleep(1000);
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("🦇" + this.name + " has arrived with a power level of " + powerlevel + "XP");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Override
    public int fight(SuperPerson opponent) {
        System.out.println("\nYou are going down!!!!!!!!!!!");
        //make the hero do a random amount of damage to the opponent
        //the damage should be a random number plus the experiencePoints (power level)
        //if the base damage (without the xp was 0, don't do any damage and just say you missed
        //otherwise deal the damage and say sth about you kicking but against your opponent
        int baseDamage = new Random().nextInt(21);
        int damage = baseDamage + this.experiencePoints;

        if (this.health < 40 && !powerUps.isEmpty()) {
            //create a new list of just the keys from the HashMap (glove, hammer, etc....)
            List<String> items = new ArrayList<String>(powerUps.keySet());

            //get a random item name from the above list we just made and store it in random Item
            String randomItem = items.get(new Random().nextInt(items.size()));

            //get the point value for that item from the inventory HashMap
            //bonus  would be the int that represents the damage the item will do.
            int bonus = powerUps.get(randomItem);
            System.out.println("🦇 " + this.name + " activates " + randomItem + " for +" + bonus + " bonus damage!");
            damage += bonus;
        }


        if (baseDamage == 0) {
            System.out.println(this.name + " missed");
        } else {

            System.out.println(this.name + " lands a heroic punch on " + opponent.name + " for " + damage);
            opponent.takeDamage(damage);
            logHit(opponent);

        }
        return damage;
    }

}
