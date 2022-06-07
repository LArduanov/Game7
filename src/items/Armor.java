package items;

public abstract class Armor implements Item {
    public String name;
    public int power;
    public int strength;
    public int wear;
    public static int weight;

    public static int armorAttack(Armor target) {
        return target.power;
    }

    public static int weightSum(Armor target){
        return target.weight;
    }
    public static int itemStrength(Armor target){
        target.strength -= target.wear;
        if (target.strength > 0) {
            System.out.println("Прочность брони " + target.name + " равна: " + target.strength);
        } else {
            target.power = 0;
            target.strength = 0;
            System.out.println("Броня " +target.name + " развалилась!");
        }
        return target.strength;
    }
    }



