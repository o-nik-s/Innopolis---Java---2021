package game;

/**
 * 31.10.2021
 * 10. Abstract Classes And Interfaces
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class RedStone implements Artefact {
    @Override
    public int useInAttack() {
        return 10;
    }

    @Override
    public int useInDamage() {
        return 10;
    }
}
