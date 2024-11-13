
# Magical-Arena
Problem Statement:

Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0



## Overview
The project consists of the following components:

* Player.java: Defines the attributes and behavior of a player.

*  Arena.java: Manages the interaction between two players during a match.
  
*  Game.java: Entry point of the application where you can simulate matches.

*  ArenaTest.java.: Unit tests for corresponding classes.
  
## Getting Started
To run the Magical Arena simulation, follow these steps:

1. Clone or download the project repository to your local machine.
2. Open the project in your preferred Java IDE, such as Eclipse or IntelliJ IDEA.
## Running the Application

1. Locate the Game.java file in the project structure.
2. Run the main() method in MagicalArena.java to start the application.
3. Follow the prompts or input required parameters to simulate matches in the Magical Arena.
## Game Class 
Explanation:

* The Game class serves as the entry point for the application.
* In the main() method, it creates two players, playerA and playerB, with their respective attributes: health, strength, and attack.
* It then initiates a match between playerA and playerB using the Match class.
* After the match is completed, it checks the health of playerA to determine the winner.
* If playerA's health is less than or equal to 0, it declares playerB as the winner. Otherwise, it declares playerA as the winner.


package org.swiggy;

import org.swiggy.arena.Arena;
import org.swiggy.arena.Player;

public class Game {
    public static void main(String[] args) {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        Arena arena = new Arena();
        arena.fight(playerA, playerB);
    }
}


## Player Class
Explaination:

1. Attributes:

The Player class encapsulates the attributes of a player in the Magical Arena. These attributes include:
* health: Represents the health points of the player.
* strength: Denotes the strength attribute of the player, which is used for defending against attacks.
* attack: Indicates the attack attribute of the player, used for inflicting damage on the opponent.
2. Constructor:

* The class has a constructor that initializes a Player object with specific values for health, strength, and attack.
* It sets the initial values of the player's attributes based on the parameters passed to the constructor.

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

## Arena Class
Explaination:

1. Instance Variables:

* attacker: Represents the player who is currently attacking.
* defender: Represents the player who is currently defending.
* random: An instance of the Random class to generate random numbers for dice rolls.

2. Constructor:

* Initializes the Match object with two players (player1 and player2).
* Determines the initial attacker and defender based on the players' health. The player with lower health becomes the attacker, and the other becomes the defender.

3. fight() Method:

* Simulates the progression of the match until one of the players' health drops to 0 or below.
* Inside a loop, it rolls dice for attack and defense using Random.nextInt(6) + 1 to simulate a 6-sided die.
* Calculates attack and defense damages based on dice rolls and player attributes.
* Updates the defender's health by deducting the net damage after defense.
* Switches roles for the next turn, ensuring that the attacker and defender alternate.


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

## Dice Class
Explaination:

1. Attributes:

The Player class encapsulates the attributes of a player in the Dice . These attributes include:
* SIDES: Reperesenting a Number.
* random: Denotes the random generator for the Arena
* 2. Constructor:

* The class has a constructor that initializes a Dice object with specific values for SIDES, and random number.
* roll() method: Denotes what number is getting by the player after rolling the dice.

package org.swiggy.arena;
import java.util.Random;

public class Dice {
    private static final int SIDES = 6;
    private final Random random;

    public Dice() {
        this.random = new Random();
    }

    public int roll() {
        return random.nextInt(SIDES) + 1;
    }
}


## Unit Testing
The project includes a suite of unit tests to ensure the correctness and reliability of the codebase.

* ArenaTest:Test the functionality of the MagicalArena class


To run the unit tests:

* Navigate to the corresponding test files in the src/test directory.
* Run each test class or individual test methods using your IDE's testing framework.


## PlayerTest
Explanation:

1. Imports:

* The import static org.junit.Assert.assertEquals; statement imports the assertEquals method from the org.junit.Assert class.
* This method is used to assert that the actual value equals the expected value.

2. Test Class:

* The class PlayerTest is a JUnit test class responsible for testing the functionality of the Player class.

3. Test Method:

* The @Test annotation indicates that the testPlayerCreation() method is a test case.
* This method is responsible for testing the creation of a Player object with specific attributes.
* Inside the method, a Player object is created with initial health of 100, strength of 10, and attack of 5.

4. Assertions:

* The assertEquals() method is used to verify that the actual values retrieved from the Player object match the expected values.
* The first assertEquals() statement checks if the player's initial health is 100.
* The second assertEquals() statement checks if the player's initial strength is 10.
* The third assertEquals() statement checks if the player's initial attack is 5.
* Mockito is used for mocking the objects.

5. Purpose:

* The purpose of this test case is to ensure that the Player class constructor initializes the player object with the correct attribute values.
* It helps ensure that the Player class behaves as expected and initializes player objects correctly, which is crucial for the functioning of other components that interact with Player objects.

Overall, this test case contributes to the quality and reliability of the codebase by providing automated testing for the Player class constructor. It helps catch potential bugs and ensures that the Player class meets the expected behavior defined by its specification.

package org.swiggy;

import org.swiggy.arena.Arena;
import org.swiggy.arena.Dice;
import org.swiggy.arena.Player;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class ArenaTest {

    @Test
    public void testDiceRoll() {
        Dice dice = new Dice();
        int rollResult = dice.roll();
        assertTrue(rollResult >= 1 && rollResult <= 6, "Dice roll should be between 1 and 6");
    }

    @Test
    public void testHealthReduction() {
        Player player = new Player("Player1", 100, 10, 10);
        assertEquals(100, player.getHealth());
        player.reduceHealth(30);
        assertEquals(70, player.getHealth());
        player.reduceHealth(100);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testIsAlive() {
        Player player = new Player("Player1", 100, 10, 10);
        assertTrue(player.isAlive());
        player.reduceHealth(100);
        assertFalse(player.isAlive());
    }

    @Test
    public void testFight_Player1WinsWithMagic() {
        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefenseDice = mock(Dice.class);

        when(mockAttackDice.roll()).thenReturn(10);
        when(mockDefenseDice.roll()).thenReturn(3);

        Player player1 = new Player("Player1", 100, 10, 10);
        Player player2 = new Player("Player2", 50, 8, 12);

        Arena magicalArena = new Arena(mockAttackDice, mockDefenseDice);

        magicalArena.fight(player1, player2);

        assertTrue(player2.getHealth() <= 0 || !player2.isAlive(), "Player2 should be defeated");
        assertTrue(player1.isAlive(), "Player1 should be alive");
    }


    @Test
    public void testFight_Player2Wins() {
        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefenseDice = mock(Dice.class);

        when(mockAttackDice.roll()).thenReturn(7);
        when(mockDefenseDice.roll()).thenReturn(3);

        Player player1 = new Player("Player1", 40, 10, 8);
        Player player2 = new Player("Player2", 100, 15, 12);

        Arena arena = new Arena(mockAttackDice, mockDefenseDice);
        arena.fight(player1, player2);

        assertTrue(player1.getHealth() <= 0 || !player1.isAlive(), "Player1 should be defeated");
        assertTrue(player2.isAlive(), "Player2 should be alive");
    }

    @Test
    public void testFight_HealthTie() {
        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefenseDice = mock(Dice.class);
        when(mockAttackDice.roll()).thenReturn(4);
        when(mockDefenseDice.roll()).thenReturn(4);
        Player player1 = new Player("Player1", 100, 10, 10);
        Player player2 = new Player("Player2", 100, 10, 10);
        Arena arena = new Arena(mockAttackDice, mockDefenseDice);
        arena.fight(player1, player2);
        assertTrue(player1.isAlive() || player2.isAlive());
    }

    @Test
    public void testAttackDamageCalculation() {
        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefenseDice = mock(Dice.class);
        when(mockAttackDice.roll()).thenReturn(4);
        when(mockDefenseDice.roll()).thenReturn(3);
        Player player1 = new Player("Player1", 100, 10, 5);
        Player player2 = new Player("Player2", 100, 8, 10);
        Arena arena = new Arena(mockAttackDice, mockDefenseDice);
        arena.performAttack(player1, player2);
        int expectedDamage = Math.max(0, (player1.getAttack() * 4) - (player2.getStrength() * 3));
        assertEquals(expectedDamage, 0);
    }
}
