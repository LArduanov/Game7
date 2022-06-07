package units;

import items.Item;

public interface Unit {

    public int weaponSum();
    public int armorSum();
    public void equipArmors(Item target);
    public void equipWeapons(Item target);
    public int weightWeapon();
    public int weightArmor();
    public void weaponStrength();
    public void armorStrength();

    public int drop(int x, int y);
}
