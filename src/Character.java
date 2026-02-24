import java.util.ArrayList;

public class Character {

    private String name;
    private int healthPoint;
    private int level;
    private double score;
    private double gold;
    private boolean isLive;
    private char type;
    private String weapon;
    private String armor;
    private int maxHealthPoint;
    private static int totalCount = 0;
    private int id;
    ArrayList<Item> items;


    public Character(String name, char type) {
        this.name = name;
        this.healthPoint = 100;
        this.level = 1;
        this.score = 0;
        this.gold = 100;
        this.type = type;
        this.isLive = true;
        this.maxHealthPoint = 200;
        this.weapon = null;
        this.armor = null;
        this.items = new ArrayList<>();
        totalCount += 1;
        id = totalCount;
    }

    public String getName() {
        return name;
    }
    public int getHealthPoint() {
        return healthPoint;
    }
    public int getLevel() {
        return level;
    }
    public double getScore() {
        return score;
    }
    public double getGold() {
        return gold;
    }
    public boolean getIsLive() {
        return isLive;
    }
    public char getType() {
        return type;
    }
    public String getWeapon() {
        return weapon;
    }
    public String getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        healthPoint = health;
    }
    public boolean hasWeapon() {
        return weapon != null;
    }
    public boolean hasArmor() {
        return armor != null;
    }
    public String toString() {
        return id + ".Character " + name + " || Health Point :" + healthPoint + "/" + maxHealthPoint + "( %" + getHealthPercentage()
                + " )" + " || Level :" + level +" || Score :" + getScore() + " || Gold :" + gold + " || isLive :" + isLive +
                " || Type :" + type + " || Weapon :" + weapon + " || Armor :" + armor;

    }
    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }


    public void printItem() {
        System.out.println(name + " Item");
        for (Item item : items) {
            System.out.println(" -" +item);
        }
        System.out.println();
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }


    public void attack(Character character) {
        if (isAlive()) {

            double attackDamage = 0;
            for (Item item : items) {
                if (item.getName().equals(weapon)) {
                    attackDamage = item.getDamage();
                    break;
                }
            }

            double defenceOppenent = 0;
            for (Item item : character.items) {
                if (item.getName().equals(character.armor)) {
                    defenceOppenent = item.getDefense();
                    break;
                }
            }

            double netAttack = attackDamage - defenceOppenent;

            if (netAttack < 0) {
                netAttack = 0;
            }

            System.out.println(name + " attacks " + character.name + " for " + netAttack + " damage");

            // Hero samler guld
            double goldTheft = netAttack / 2;
            if (character.hasGold(goldTheft)) {
                addGold(goldTheft);
            }

            // Hero samler point.
            addXP((int) (gold * 10));

            // Modstanderen iværksætter et modangreb.
            character.takeDamage(netAttack);
        }
    }


    public void takeDamage(double amount) {
        double oldHealthPoint = healthPoint;
        healthPoint -= amount;

        if (healthPoint < 0) {
            healthPoint = 0;
        }

        System.out.println(name + " takes " + amount + " damage, Health: " + oldHealthPoint + " -> " + healthPoint);

        if (healthPoint == 0) {
            isLive = false;
        }

        removeGold(amount);


    }

    public void addGold(double amount){
        if (isLive) {
            double oldHealthGold = gold;
            gold += amount;
            System.out.println(name + " takes " + amount + " gold "+ oldHealthGold + " -> " + gold);
        }
    }

    public void removeGold(double amount){
        if (hasGold(amount)) {

            double oldHealthGold = gold;
            gold -= amount;

            if (gold < 0) {
                gold = 0;
            }

            System.out.println(name + " lost " + amount + " gold after the attack " + oldHealthGold + " -> " + gold);
        }
    }

    public boolean hasGold(double amount) {
        return gold >= amount;
    }

    public void addXP(int amount) {
        if (isLive) {
            score += amount;
            System.out.println(name + " gains " + amount + " XP!, Total : " + score);
        }
    }

    public boolean isAlive (){
        return healthPoint > 0;
    }

    public void heal(int amount){
        if (isLive) {
            double oldHealthPoint = healthPoint;
            healthPoint += amount;

            if (healthPoint > maxHealthPoint) {
                healthPoint = maxHealthPoint;
            }

            System.out.println(name + " heals " + amount + " HP, Health: " + oldHealthPoint + " -> " + healthPoint);
        }
    }


    // ------------------------------------

    /*  levelIncrease  algorithme
    For eksempel: Lad os sige, at scoren er 4000 og level er 1.
    I dette tilfælde skal level ifølge betingelsen være 4,
    og når der foretages en forøgelse, skal level øges i overensstemmelse hermed.

    4000 / 1000 = 4
    4 - 1 = 3

    Det giver en level-forøgelse på 3
    */

    public int levelIncrease(){
        int threshold = level * 1000;
        int levelIncrease = (int) (score / threshold - level);  // Vi dividerer scoren med tærsklen.

        if (levelIncrease < 0) {
            levelIncrease = 0;
        }
        return levelIncrease;
    }

    public void levelUp (){
        if (levelCheck() && isLive && levelIncrease() > 0) {
            System.out.println(name + " is leveling up to level " + levelIncrease() );
            level += levelIncrease();
            score = 0;
        }
    }

    public boolean levelCheck (){
        return score > level * 1000;
    }
    // ------------------------------------


    public boolean isHealthCritical() {
        return healthPoint > 0 && healthPoint < (25 * maxHealthPoint / 100);
    }

    public double getHealthPercentage() {
        return (double) (healthPoint * 100 / maxHealthPoint);
    }





}
