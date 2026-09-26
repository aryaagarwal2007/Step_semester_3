package encapsulation.assigment_problems;

/**
 * Problem 1: The Health Bar
 *
 * health is private and can only change through takeDamage()/heal(), both of
 * which clamp the result into [0, maxHealth]. maxHealth is final, fixed at
 * construction. There is a read-only getter for health but no setter.
 */
public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;
        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("After 30 damage: " + c.getHealth());

        c.heal(50);
        System.out.println("After healing 50 (capped): " + c.getHealth());

        c.takeDamage(150);
        System.out.println("After 150 damage (floored): " + c.getHealth());
    }
}
