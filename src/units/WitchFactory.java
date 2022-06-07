package units;

import items.Inventory;

public class WitchFactory {
    public static Witch create_soldier(String names){
        System.out.println("Создан " + names);
        return new Witch ("Колдун солдат",30, 10, 40, 40, 0,new Inventory(1),new Inventory(1));
    }
    public Witch create_commander (String names){
        System.out.println("Создан " + names);
        return new Witch ("Колдун командир",50, 30, 50, 60, 50,new Inventory(2),new Inventory(2));
    }
    public static Witch create_general(String names){
        System.out.println("Создан " + names);
        return new Witch ("Колдун генерал",70, 50, 70, 100, 500,new Inventory(4),new Inventory(4));
    }
}

