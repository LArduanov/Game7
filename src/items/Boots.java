package items;

public class Boots extends Armor {

    public Boots(String name, int power, int strength, int wear, int weight) {
        this.name = name;
        this.power = power;
        this.strength = strength;
        this.wear = wear;
        this.weight = weight;
    }

    public void repair() {
        strength = 100;
        System.out.println("Броня " + name + " востановлена!");
    }
}


