package game;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class BlueWater implements Artefact, PassiveSkill {
    @Override
    public int useInAttack() {
        return 5;
    }

    @Override
    public int useInDamage() {
        return 5;
    }

    @Override
    public int getBonus() {
        return 0;
    }
}
