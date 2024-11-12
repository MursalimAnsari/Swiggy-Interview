package org.swiggy.arena;


public class Arena {
    private final Dice attackDice;
    private final Dice defenseDice;

    public Arena() {
        this.attackDice = new Dice();
        this.defenseDice = new Dice();
    }

    public void fight(Player player1, Player player2) {
        Player attacker = (player1.getHealth() <= player2.getHealth()) ? player1 : player2;
        Player defender = (attacker == player1) ? player2 : player1;

        while (attacker.isAlive() && defender.isAlive()) {
            performAttack(attacker, defender);

            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }

        System.out.println("Winner: " + (attacker.isAlive() ? attacker.getName() : defender.getName()));
    }

    private void performAttack(Player attacker, Player defender) {
        int attackRoll = attackDice.roll();
        int defenseRoll = defenseDice.roll();

        int attackDamage = attacker.getAttack() * attackRoll;
        int defensePower = defender.getStrength() * defenseRoll;

        int damageDealt = Math.max(0, attackDamage - defensePower);
        defender.reduceHealth(damageDealt);

        System.out.println(attacker.getName() + " attacks with damage " + attackDamage + " vs " + defender.getName() + " defense " + defensePower);
        System.out.println(defender.getName() + " health reduced by " + damageDealt + " to " + defender.getHealth());
    }
}
