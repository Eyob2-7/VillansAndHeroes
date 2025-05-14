package com.pluralsight;

public class SuperApp {
    public static void main(String[] args) throws InterruptedException {


        // Create a hero object with a name, health, and powerLevel
        SuperHero hero = new SuperHero("Batman", 100, 22);

        // Create a villain object with a name, health, and evilness
        SuperVillain villain = new SuperVillain("joker", 100, 50);


        // add hero power-ups
        hero.addPowerUp("Batarang", 6);
        hero.addPowerUp("Smoke Bomb", 4);

        // add Joker's power-ups
        villain.addPowerUp("Laughing Gas", 5);
        villain.addPowerUp("Exploding Card", 7);

        // Display an introduction message
        System.out.println("\n                  🦇 Batman vs 🤡 Joker — Let the battle begin!");
        Thread.sleep(1000);


        // Show the starting status of both characters
        System.out.println("\n 🦇" + hero.getStatus());
        Thread.sleep(1000);

        System.out.println("\n 🤡" + villain.getStatus());
        Thread.sleep(1000);

        // Loop while both the hero and villain are still alive
        while (hero.isAlive() && villain.isAlive()) {

            // Indicate the hero's turn
            System.out.println("\n🦇Bat Man's's Turn:");
            Thread.sleep(1000);

            // Have the hero fight the villain
            hero.fight(villain);

            // Show the villain's updated status
            System.out.println("\n 🤡" + villain.getStatus());
            Thread.sleep(1000);

            // If the villain is no longer alive, break the loop
            if (!villain.isAlive()) {
                break;
            }
            // Indicate the villain's turn
            System.out.println("\n🤡 Joker's Turn:");
            Thread.sleep(1000);

            // Have the villain fight the hero
            villain.fight(hero);

            // Show the hero's updated status
            System.out.println("\n 🦇" + hero.getStatus());
            Thread.sleep(1000);
        }

        // Display a message that the battle is over
        System.out.println("\n    >>>>>>>>>>     🦇Game over🤡     >>>>>>>>>    ");
        // If the hero is still alive
        if (hero.isAlive()) {
            System.out.println("              \n🦇 " + hero.name + " wins the battle!");
        } else {
            System.out.println("               \n🤡 " + villain.name + " wins the battle!");
        }

        hero.printBattleLog();
        System.out.println("\n");
        villain.printBattleLog();
    }
}



