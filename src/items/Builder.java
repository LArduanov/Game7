package items;

public class Builder {
    private String name;
    private int power;
    private int strength;
    private int wear = 10;
    private int weight = 30;

    public Item buildSword() {
        System.out.println("Создан "+ name + ". Мощностью " + power + ", прочность " + strength);
        return new Sword (name, power, strength, wear, weight);
    }
    public Item buildBoots() {
        System.out.println("Создан "+ name + ". Мощностью " + power + ", прочность " + strength);
        return new Boots(name, power, strength, wear, weight);
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }
    public Builder setPower(int power) {
        this.power = power;
        return this;
    }
    public Builder setStrength(int strength) {
        this.strength = strength;
        return this;
    }
}
