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
    public void testFight_Player1Wins() {
        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefenseDice = mock(Dice.class);
        when(mockAttackDice.roll()).thenReturn(5);
        when(mockDefenseDice.roll()).thenReturn(2);
        Player player1 = new Player("Player1", 100, 10, 10);
        Player player2 = new Player("Player2", 50, 8, 12);
        Arena arena = new Arena(mockAttackDice, mockDefenseDice);
        arena.fight(player1, player2);
        assertEquals(0, player2.getHealth());
        assertTrue(player1.isAlive());
    }

    @Test
    public void testFight_Player2Wins() {
        Dice mockAttackDice = mock(Dice.class);
        Dice mockDefenseDice = mock(Dice.class);
        when(mockAttackDice.roll()).thenReturn(3);
        when(mockDefenseDice.roll()).thenReturn(5);
        Player player1 = new Player("Player1", 40, 12, 10);
        Player player2 = new Player("Player2", 100, 8, 8);
        Arena arena = new Arena(mockAttackDice, mockDefenseDice);
        arena.fight(player1, player2);
        assertEquals(0, player1.getHealth());
        assertTrue(player2.isAlive());
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
