package com.pluralsight;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SuperPerson {

    // protected properties so they can possibly be accessed by our children, grand children, etc...
    protected String name;
    protected int health;
    protected int experiencePoints;

    protected HashMap<String, Integer> powerUps= new HashMap<>();

    // Tracks how many times the characters has hit each opponent
    private final Map<String, Integer> battleLog = new HashMap<>();

    public SuperPerson(String name, int health) {
        //take in the values for name and health
        this.name = name;
        this.health = health;

        //default the experience points to 0
        this.experiencePoints = 0;
    }

    //method to return if our SuperPerson is alive
    public boolean isAlive(){

        //if they have health they are alive, return true, otherwise false
        return this.health > 0;
    }

    public int fight(SuperPerson opponent){
        //print out who we are fighting.

        int damageAmount = new Random().nextInt(21);
        System.out.println(this.name + " is fighting " + opponent.name);
        opponent.takeDamage(damageAmount);
        return damageAmount;

    }

    public void takeDamage(int damageAmount){
        //subtract the damage amount from the health
        // ,but we don't want ever set our health below 0
        this.health -= damageAmount;
        if(this.health < 0){
            this.health = 0;
        }
    }

    // a way to ask the super person how they are doing.
    public String getStatus(){

        // build and return a string that tells us how they are doing
        return this.name + " has " + this.health + " health left! ";
    }

    //update the log entry for our SuperPerson
    public void logHit(SuperPerson opponent) {
        String name = opponent.name;
        int count = battleLog.getOrDefault(name, 0);
        battleLog.put(name, count + 1);
    }

    //print the battle log for a SuperPerson
    public void printBattleLog() {
        System.out.println("\n Battle log for " + name + ":");
        for (Map.Entry<String, Integer> entry : battleLog.entrySet()) {
            System.out.println("\n - Hit " + entry.getKey() + ": " + entry.getValue() + " times");
        }
    }

    // add power up method
    public void addPowerUp(String item, int value){
        powerUps.put(item,value);
    }

    // add get power bonus method
    public int getPowerBonus(String item){
        return powerUps.getOrDefault(item,0);
    }
}
