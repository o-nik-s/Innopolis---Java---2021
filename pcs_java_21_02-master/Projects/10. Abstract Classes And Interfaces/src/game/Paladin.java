package game;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Paladin extends Player {

    private static final int DEFAULT_SCORE = 50;
    private static final int DEFAULT_HEALTH = 100;
    private static final int ATTACK_SCORE = 20;
    private static final int DAMAGE_VALUE = 5;
    private static final int HEALTH_AFTER_DAMAGE_VALUE = -10;

    public Paladin() {
        super(DEFAULT_SCORE, DEFAULT_HEALTH);
    }

    @Override
    public void attack(Player enemy) {
        this.score += ATTACK_SCORE;
        enemy.damage(DAMAGE_VALUE);
    }

    @Override
    public void damage(int value) {
        this.health += HEALTH_AFTER_DAMAGE_VALUE * value;

        if (health < 0) {
            System.err.println("Паладин проиграл!");
        }
    }
}
