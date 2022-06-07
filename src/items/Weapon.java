package items;



public abstract class Weapon implements Item {
    public String name;
    public int power;
    public int strength;
    public int wear;
    public static int weight;

    public static int weaponAttack(Weapon target) {
        return target.power;
    }

    public static int weightSum(Weapon target) {
        return target.weight;
    }

    public static int itemStrength(Weapon target){
        target.strength -= target.wear;
        if (target.strength > 0) {
            System.out.println("Прочность оружия " + target.name + " равна: " + target.strength);
        } else {
            target.power = 0;
            target.strength = 0;
            System.out.println(target.name + " развалился!");
        }
        return target.strength;
    }

    }


