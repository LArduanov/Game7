package units;

import items.Inventory;

public class HumanFactory {
    public static Human create_soldier(String names){
        System.out.println("Создан " + names);
        return new Human ("Человек солдат",30, 10, 40, 40, 0,new Inventory(1),new Inventory(1));
    }
    public static Human create_commander(String names){
        System.out.println("Создан " + names);
        return new Human ("Человек командир",50, 30, 50, 60, 50,new Inventory(2),new Inventory(2));
    }
    public Human create_general (String names){
        System.out.println("Создан " + names);
        return new Human ("Человек генерал",70, 50, 70, 100, 500,new Inventory(4),new Inventory(4));
    }
}

