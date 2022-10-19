package game;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Wizard extends Player {

    private static final int DEFAULT_SCORE = 100;
    private static final int DEFAULT_HEALTH = 50;
    private static final int DEFAULT_MANA = 100;
    private static final int ATTACK_MANA = -5;
    private static final int ATTACK_SCORE = 10;
    private static final int DAMAGE_VALUE = 3;
    private static final int HEALTH_AFTER_DAMAGE_VALUE = -2;

    private int mana;

    public Wizard() {
        super(DEFAULT_SCORE, DEFAULT_HEALTH);
        this.mana = DEFAULT_MANA;
    }

    @Override
    public void attack(Player enemy) {
        if (this.skill != null) {
            this.health += skill.getBonus();
            this.mana += skill.getBonus();
        }

        if (this.mana <= 0) {
            System.err.println("Атака невозможна!");
            return;
        }

        this.mana += ATTACK_MANA;
        this.score += ATTACK_SCORE;

        int damageValue = DAMAGE_VALUE;
        if (artefact != null) {
            damageValue += artefact.useInAttack();
        }

        enemy.damage(damageValue);
    }

    @Override
    public void damage(int value) {
        this.health += HEALTH_AFTER_DAMAGE_VALUE * value + artefact.useInDamage();

        if (health < 0) {
            this.mana = 0;
            System.err.println("Волшебник проиграл!");
        }
    }

    public int getMana() {
        return mana;
    }
}
