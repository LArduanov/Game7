
import items.*;
import units.*;

import java.io.IOException;


public class Run {
    public static void main(String[] args) {
//Гуманоиды
        Human human = new Human("Человек", 50, 40, 15, 80, 30, new Inventory(2), new Inventory(4));
        Orc orc = new Orc("Орк", 60, 20, 50, 80, 50, new Inventory(2), new Inventory(4));
//Летающие
        Dragon dragon = new Dragon("Дракон", 250, 50, 30, 80, 400, new Inventory(2), new Inventory(4));
        Witch witch = new Witch("Колдун", 40, 60, 40, 80, 20, new Inventory(2), new Inventory(4));
//Оружие
        Axe axe = new Axe("Топор", 50, 100, 10, 30);
        Bow bow = new Bow("Лук", 30, 100, 10, 30);
        Sword sword = new Sword("Меч", 40, 100, 10, 30);
        FireBreath fireBreath = new FireBreath("Пламя", 60, 100, 10, 30);
//Броня
        Helmet helmet = new Helmet("Шлем", 60, 100, 10, 30);
        Shield shield = new Shield("Щит", 40, 100, 10, 30);
        Boots boots = new Boots("Сапоги", 30, 100, 10, 30);
        Gloves gloves = new Gloves("Перчатки", 50, 100, 10, 30);

//Снаряжение оружия
        human.equipWeapons(bow);
        human.equipWeapons(axe);
        human.equipWeapons(sword);
        dragon.equipWeapons(fireBreath);
        dragon.equipWeapons(sword);

//Снаряжение брони
        witch.equipArmors(shield);
        witch.equipArmors(helmet);
        witch.equipArmors(gloves);


//Атака
        orc.attack(witch);
        witch.attack(dragon);
        dragon.attack(orc);
        human.attack(witch);
        human.attack(witch);
        human.attack(orc);
        human.attack(dragon);
        human.attack(dragon);
        human.attack(dragon);
        human.attack(dragon);


//Запись героя Человек
        String way = "./src/units/human.txt";
        try {
            Human.output(way, human);
        } catch (IOException e) {
            e.printStackTrace();
        }

// Builder
        Item sword1 = new Builder()
                .setName("Огненный меч")
                .setPower(100)
                .setStrength(200)
                .buildSword();

        Item boots1 = new Builder()
                .setName("Шипованные ботинки")
                .setPower(100)
                .setStrength(200)
                .buildBoots();

        orc.equipWeapons(sword1);
        orc.equipArmors(boots1);


//Фабрика
        OrcFactory.create_soldier("Хищник").equipWeapons(bow);
        HumanFactory.create_commander("Амбал").equipWeapons(axe);
        WitchFactory.create_general("Маг").equipWeapons(sword1);

    }
}
