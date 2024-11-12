# Magical-Arena


Problem Statement:

Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0

Overview
The project consists of the following components:

Player.java: Defines the attributes and behavior of a player.

Match.java: Manages the interaction between two players during a match.

MagicalArena.java: Orchestrates matches within the arena.

MagicalArena.java: Entry point of the application where you can simulate matches.

PlayerTest.java, MatchTest.java,MagicalArenaTest.java.: Unit tests for corresponding classes.

Getting Started
To run the Magical Arena simulation, follow these steps:

Clone or download the project repository to your local machine.
Open the project in your preferred Java IDE, such as Eclipse or IntelliJ IDEA.
Running the Application
Locate the MagicalArena.java file in the project structure.
Run the main() method in MagicalArena.java to start the application.
Follow the prompts or input required parameters to simulate matches in the Magical Arena.
MagicalArena Class
Explanation:

The MagicalArena class serves as the entry point for the application.

In the main() method, it creates two players, playerA and playerB, with their respective attributes: health, strength, and attack.

It then initiates a match between playerA and playerB using the Match class.

After the match is completed, it checks the health of playerA to determine the winner.

If playerA's health is less than or equal to 0, it declares playerB as the winner. Otherwise, it declares playerA as the winner.

  public class MagicalArena {
  public static void main(String[] args) {
  
  **for static data we can use the below code**
  Player playerA = new Player(50, 5, 10);
  Player playerB = new Player(100, 10, 5);
  
  //calling th Match class by creating the instance of that class
  Match match = new Match(playerA, playerB);
  match.fight();

  //printing the output
  if (playerA.getHealth() <= 0) {
          System.out.println("Player B wins!");
      } else {
          System.out.println("Player A wins!");
      }

  }
  }
Player Class
Explaination:

Attributes:
The Player class encapsulates the attributes of a player in the Magical Arena. These attributes include:

health: Represents the health points of the player.
strength: Denotes the strength attribute of the player, which is used for defending against attacks.
attack: Indicates the attack attribute of the player, used for inflicting damage on the opponent.
Constructor:
The class has a constructor that initializes a Player object with specific values for health, strength, and attack.

It sets the initial values of the player's attributes based on the parameters passed to the constructor.

  package com.arena;

  public class Player {

  //Defined the mentioned attribute given in the game
  private int health;
  private int strength;
  private int attack;

  //Creating getter and setter
  public int getHealth() {
      return health;
  }
  public void setHealth(int health) {
      this.health = health;
  }
  public int getStrength() {
      return strength;
  }
  public void setStrength(int strength) {
      this.strength = strength;
  }
  public int getAttack() {
      return attack;
  }
  public void setAttack(int attack) {
      this.attack = attack;
  }
  
  //Parameterized constructor
  public Player(int health, int strength, int attack) {
      super();
      this.health = health;
      this.strength = strength;
      this.attack = attack;
  } 
  }
Match Class
Explaination:

Instance Variables:
attacker: Represents the player who is currently attacking.
defender: Represents the player who is currently defending.
random: An instance of the Random class to generate random numbers for dice rolls.
Constructor:
Initializes the Match object with two players (player1 and player2).
Determines the initial attacker and defender based on the players' health. The player with lower health becomes the attacker, and the other becomes the defender.
fight() Method:
Simulates the progression of the match until one of the players' health drops to 0 or below.

Inside a loop, it rolls dice for attack and defense using Random.nextInt(6) + 1 to simulate a 6-sided die.

Calculates attack and defense damages based on dice rolls and player attributes.

Updates the defender's health by deducting the net damage after defense.

Switches roles for the next turn, ensuring that the attacker and defender alternate.
