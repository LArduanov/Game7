package units;

import items.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;


public class Human extends Humanoid implements Serializable {

    public Human(String name, int hp, int attack, int armor, int stamina, int money, Inventory weapons, Inventory armors) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.armor = armor;
        this.stamina = stamina;
        this.money = money;
        this.weapons = weapons;
        this.armors = armors;
    }

    //Экипируем оружие
    @Override
    public void equipWeapons(Item target) {
        int s = weightWeapon() + weightArmor()+ Weapon.weight;
        if (stamina >= s) {
            for (int i = 0; i < weapons.inventory.length; i++) {
                if (weapons.inventory[i] == null) {
                    weapons.inventory[i] = target;
                    int attackSum = weaponSum() + attack;
                    System.out.println(name + " взял оружие! Сила атаки "+ attackSum);
                    System.out.println("");
                    return;
                }
            }
            for (int i = 0; i < weapons.inventory.length; i++) {
                if (weapons.inventory[i] != null) {
                    System.out.println("Нет места!");
                    return;
                }
            }
        }else{
            System.out.println("Оружие слишком тяжелое.");
        }System.out.println("");
    }

    @Override
    public int drop(int x, int y) {
        x += y;
        y = 0;
        return x;
    }

    //Экипируем броню
    @Override
    public void equipArmors(Item target) {
        int s = weightWeapon() + weightArmor()+ Armor.weight;
        if (stamina >= s) {
            for (int i = 0; i < armors.inventory.length; i++) {
                if (armors.inventory[i] == null) {
                    armors.inventory[i] = target;
                    int armorSum = armorSum() + armor;
                    System.out.println(name + " одел броню! Сила защиты "+ armorSum);
                    System.out.println("");
                    return;
                }
            }
            for (int i = 0; i < armors.inventory.length; i++) {
                if (armors.inventory[i] != null) {
                    System.out.println("Нет места!");
                    return;
                }
            }
        }else {
            System.out.println("Броня слишком тяжелая.");
        }System.out.println("");
    }

    //Атака на летающих
    @Override
    public void attack (Flying target){
        int hit = attack + weaponSum() - target.armor - armorSum();
        if (hit > 0) {
            if (target.hp > 0) {
                target.hp -= hit;
                System.out.println(name + " кидает оружие в " + target.name + "а мощностью " + hit);
                weaponStrength();
                if (target.hp > 0) {
                    System.out.println("Здоровье " + target.name + ": " + target.hp);
                    target.armorStrength();
                } else {
                    money = drop (money,target.money);
                    target.money = 0;
                    target.attack = 0;
                    System.out.println(target.name + " погиб. " + name + " забрал деньги у " + target.name + "а. Всего денег: " + money);
                }
            } else {
                System.out.println(target.name + " уже мертв. " + name + " бьет труп!");
            }
        }else {
            System.out.println(name + " кидает оружие в " + target.name + "а. Но " + target.name + " улетел.");
        }System.out.println("");
    }

    //Атака на гуманоидов
    @Override
    public void attack (Humanoid target) {
        int hit = attack + weaponSum() - target.armor - armorSum();
        if (hit > 0) {
            if (target.hp > 0) {
                target.hp -= hit;
                System.out.println(name + " атакует " + target.name + "а мощностью " + hit);
                weaponStrength();
                if (target.hp > 0) {
                    System.out.println("Здоровье " + target.name + ": " + target.hp);
                    target.armorStrength();
                } else {
                    money = drop (money,target.money);
                    target.money = 0;
                    target.attack = 0;

                    System.out.println(target.name + " погиб. " + name + " забрал деньги у " + target.name + "а. Всего денег: " + money);
                }
            } else {
                System.out.println(target.name + " уже мертв. " + name + " бьет труп!");
            }
        }else {
            System.out.println(name + " атакует " + target.name + "а. Но " + target.name + " уклонился.");
        }System.out.println("");
    }
//Преобразование в строку
    @Override
    public String toString() {
        return "human{" +
                "name=" + name +
                ", hp=" + hp +
                ", attack=" + attack +
                ", armor=" + armor +
                ", stamina=" + stamina +
                ", money=" + money +
                ", weapons=" + weapons +
                ", armors=" + armors +
                '}';
    }
    public static void output(String way, Human unit) throws IOException {

        File file = new File(way);

        ObjectOutputStream unitOutput = new ObjectOutputStream(new FileOutputStream(file));
        unitOutput.writeObject(unit);
        unitOutput.close();
        System.out.println("Сохранен объект: " + unit);
    }
}


