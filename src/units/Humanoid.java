package units;

import items.*;



import static items.Weapon.weaponAttack;


public abstract class Humanoid implements Unit {
    public String name;
    public int hp;
    public int attack;
    public int armor;
    public int stamina;
    public int money;
    public Inventory weapons;
    public Inventory armors;

    public abstract void attack (Flying target);
    public abstract void attack (Humanoid target);

    //Считаем сумму силы всего оружия в сумке
    @Override
    public int weaponSum() {
        int s = 0;
        for (int i = 0; i < weapons.inventory.length; i++) {
            if (weapons.inventory[i] != null) {
                s += weaponAttack((Weapon)weapons.inventory[i]);
            }
        }
        return s;
    }

    //Считаем сумму силы всей брони в сумке
    @Override
    public int armorSum() {
        int s = 0;
        for (int i = 0; i < armors.inventory.length; i++) {
            if (armors.inventory[i] != null) {
                s += Armor.armorAttack((Armor) armors.inventory[i]);
            }
        }
        return s;
    }
    //Вес оружия
    @Override
    public int weightWeapon() {
        int s = 0;
        for (int i = 0; i < weapons.inventory.length; i++) {
            if (weapons.inventory[i] != null) {
                Weapon j = (Weapon) weapons.inventory[i];
                s += Weapon.weightSum(j);
            }
        }
        return s;
    }

    //Вес брони
    @Override
    public int weightArmor() {
        int s = 0;
        for (int i = 0; i < armors.inventory.length; i++) {
            if (armors.inventory[i] != null) {
                Armor j = (Armor) armors.inventory[i];
                s += Armor.weightSum((Armor) armors.inventory[i]);
            }
        }
        return s;
    }
//Износ оружия
    @Override
    public void weaponStrength() {
        Weapon s;
        for (int i = 0; i < weapons.inventory.length; i++) {
            if (weapons.inventory[i] != null) {
                s = (Weapon) weapons.inventory[i];
                Weapon.itemStrength(s);
            }
        }

    }
    //Износ брони
    @Override
    public void armorStrength() {
        Armor s;
        for (int i = 0; i < armors.inventory.length; i++) {
            if (armors.inventory[i] != null) {
                s = (Armor) armors.inventory[i];
                Armor.itemStrength(s);
            }
        }

    }
}