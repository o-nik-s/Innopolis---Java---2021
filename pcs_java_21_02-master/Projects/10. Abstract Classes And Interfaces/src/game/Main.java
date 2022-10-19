package game;

public class Main {

    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Paladin paladin = new Paladin();
        BlueWater blueWater = new BlueWater();
        RedStone redStone = new RedStone();

        wizard.attack(paladin);
        wizard.setArtefact(blueWater);
        wizard.setSkill(blueWater);
        paladin.attack(wizard);
        paladin.setArtefact(redStone);

        System.out.println(wizard.getMana() + " " + wizard.getHealth() + " " + wizard.getScore());
        System.out.println(paladin.getHealth() + " " + paladin.getScore());
    }
}
