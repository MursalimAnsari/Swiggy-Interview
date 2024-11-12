package org.swiggy.arena;

public class Player {
     private final String name;
     private int health;
     private final int strength;
     private final int attack;

     public Player(String name, int health, int strength, int attack) {
          this.name = name;
          this.health = health;
          this.strength = strength;
          this.attack = attack;
     }

     public String getName() {
          return name;
     }

     public int getHealth() {
          return health;
     }

     public int getStrength() {
          return strength;
     }

     public int getAttack() {
          return attack;
     }

     public void reduceHealth(int damage) {
          health = Math.max(0, health - damage);
     }

     public boolean isAlive() {
          return health > 0;
     }
}
