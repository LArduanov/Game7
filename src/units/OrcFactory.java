package units;

import items.Builder;
import items.Inventory;
import items.Item;

public class OrcFactory {
    public String names;

    public static Orc create_soldier(String names){
        System.out.println("Создан " + names);
        return new Orc ("Орк солдат",30, 10, 40, 40, 0,new Inventory(1),new Inventory(1));
    }
    public Orc create_commander (String names){
        System.out.println("Создан " + names);
        return new Orc ("Орк командир",50, 30, 50, 60, 50,new Inventory(2),new Inventory(2));
    }
    public Orc create_general (String names){
        System.out.println("Создан " + names);
        return new Orc ("Орк генерал",70, 50, 70, 100, 500,new Inventory(4),new Inventory(4));
    }
}