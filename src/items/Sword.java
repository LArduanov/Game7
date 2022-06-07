package items;

public class Sword extends Weapon {

    public Sword(String name, int power, int strength, int wear, int weight) {
        this.name = name;
        this.power = power;
        this.strength = strength;
        this.wear = wear;
        this.weight = weight;
    }

    @Override
    public void repair() {
        strength = 100;
        System.out.println("Оружие " + name + " востановлено!");
    }

    }


