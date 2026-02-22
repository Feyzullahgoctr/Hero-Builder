import java.util.ArrayList;

public class Item {

    private String name;
    private double weight;
    private int value;
    private double damage;
    private double defense;
    private int durability;
    private String type;
    private static int totalItemCount = 0;

    public Item(String name, double weight, int value, double damage, int durability, double defense, String type) {
        this.name = name;
        this.weight = weight;
        this.value = value;

        if (type.equals("D")) {
            this.defense = defense;
        } else if (type.equals("A")) {
            this.damage = damage;
        }

        this.type = type;
        this.durability = durability;
        totalItemCount += 1;
    }
    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }
    public int getValue() {
        return value;
    }
    public double getDamage() {
        return damage;
    }
    public double getDefense() {
        return defense;
    }
    public static int getTotalItemCount() {
        return totalItemCount;
    }
    public String toString() {
        return name + " ( Weight :" + weight + ", Value :" + value +
                (type.equals("D") ? ", Defence " : ", Damage ") + (type.equals("D") ? defense : damage)
                + ", Durability :" + durability
                + ")";
    }








}
