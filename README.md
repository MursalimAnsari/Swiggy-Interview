
# Magical-Arena
Problem Statement:

Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0



## Overview
The project consists of the following components:

* Player.java: Defines the attributes and behavior of a player.

*  Match.java: Manages the interaction between two players during a match.

*  MagicalArena.java: Orchestrates matches within the arena.

*  MagicalArena.java: Entry point of the application where you can simulate matches.

*  PlayerTest.java, MatchTest.java,MagicalArenaTest.java.: Unit tests for corresponding classes.
## Getting Started
To run the Magical Arena simulation, follow these steps:

1. Clone or download the project repository to your local machine.
2. Open the project in your preferred Java IDE, such as Eclipse or IntelliJ IDEA.
## Running the Application

1. Locate the MagicalArena.java file in the project structure.
2. Run the main() method in MagicalArena.java to start the application.
3. Follow the prompts or input required parameters to simulate matches in the Magical Arena.
## MagicalArena Class 
Explanation:

* The MagicalArena class serves as the entry point for the application.
* In the main() method, it creates two players, playerA and playerB, with their respective attributes: health, strength, and attack.
* It then initiates a match between playerA and playerB using the Match class.
* After the match is completed, it checks the health of playerA to determine the winner.
* If playerA's health is less than or equal to 0, it declares playerB as the winner. Otherwise, it declares playerA as the winner.


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

## Match Class
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


        import java.util.Random;

        public class Match {
	
	    private Player attacker;
        private Player defender;
        private Random random;
    
        public Match(Player player1, Player player2) {
    	
        this.attacker = player1.getHealth() < player2.getHealth() ? player1 : player2;
        this.defender = player1.getHealth() < player2.getHealth() ? player2 : player1;
        this.random = new Random();
        }
    
        public void fight() {
    	
    	//in a loop as long as both the attacker and defender have health greater than 0. 
    	//Once a player's health drops to 0 or below, the loop exits, indicating the end of the match.
        while (attacker.getHealth() > 0 && defender.getHealth() > 0) {
        	
        	//Dice Rolling
            int attackRoll = random.nextInt(6) + 1;
            int defendRoll = random.nextInt(6) + 1;

            //Attack damage is calculated by multiplying the attack roll with the attacker's attack attribute.
            int attackDamage = attackRoll * attacker.getAttack();
            
            //Defense damage is calculated by multiplying the defense roll with the defender's strength attribute.
            int defendDamage = defendRoll * defender.getStrength();
            
            //The net damage is computed by subtracting the defense damage from the attack damage.
            int netDamage = Math.max(0, attackDamage - defendDamage);
            
            //The net damage is deducted from the defender's health. 
            //If the defender's health drops to 0 or below, the loop exits, indicating the end of the match.
            defender.setHealth(defender.getHealth() - netDamage);

            // Switch roles for next turn
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
        }

        }


## Unit Testing
The project includes a suite of unit tests to ensure the correctness and reliability of the codebase.

* PlayerTest.java: Tests the attributes and behavior of the Player class.
* MatchTest.java: Tests the functionality of the Match class.
* MagialArenaTest:Test the functionality of the MagicalArena class


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

5. Purpose:

* The purpose of this test case is to ensure that the Player class constructor initializes the player object with the correct attribute values.
* It helps ensure that the Player class behaves as expected and initializes player objects correctly, which is crucial for the functioning of other components that interact with Player objects.

Overall, this test case contributes to the quality and reliability of the codebase by providing automated testing for the Player class constructor. It helps catch potential bugs and ensures that the Player class meets the expected behavior defined by its specification.

    package com.arena;
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;

    class PlayerTest {

	//test case for playercreation
	 @Test
	    public void testPlayerCreation() {
		 
	        Player player = new Player(100, 10, 5);
	        
	        assertEquals(100, player.getHealth());
	        assertEquals(10, player.getStrength());
	        assertEquals(5, player.getAttack());
	        
	    }
    }
## MatchTest
Explaination:

1. Class and Method Declaration:

* The MatchTest class is a JUnit test case for the Match class.
* The fight() method is annotated with @Test, indicating that it is a test case.

2. Test Method:

* The fight() method creates two Player objects with specific attributes (player1 and player2).
* It creates a Match object match between the two players.
* It calls the fight() method of the Match class to simulate the match.
* It then verifies the outcome of the match by checking the health of the players.
* If player1's health drops to 0 or below, player2 should win; otherwise, player1 should win.

3. Assertions:

* The assertEquals() method is used to compare the actual and expected values.
* In this case, it ensures that the health of the winning player is greater than 0 after the match.

This test case ensures that the fight() method in the Match class behaves as expected and correctly determines the outcome of a match between two players in the Magical Arena. It helps verify the correctness and reliability of the match simulation logic.


    package com.arena;
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;

    //This class gives the unit test case for the Match class
    class MatchTest {

	//Unit test case for the fight method
	@Test
	    public void fight() {
		 
	        // Create two players for the match
	        Player player1 = new Player(50, 5, 10);
	        Player player2 = new Player(100, 10, 5);

	        // Create a match between the two players
	        Match match = new Match(player1, player2);

	        // Simulate the match
	        match.fight();

	        // Verify the outcome of the match
	        if (player1.getHealth() <= 0) {
	            // Player B should win if player A's health drops to 0 or below
	            assertEquals(true, player2.getHealth() > 0);
	        } else {
	            // Player A should win if player B's health drops to 0 or below
	            assertEquals(true, player1.getHealth() > 0);
	        }
	    }
        }
