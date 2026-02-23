import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HeroBuilderMain {

    // Vi skabte en helt
    Character hero = new Character("Ragnar",'W');

    ArrayList<Character> enemy = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();
    Random random = new Random();
    int laps = 1;

    public int randomWeaponSelection() {
        int weaponSelection = random.nextInt(3);
        return weaponSelection;
    }

    public int randomArmorSelection() {
        int armorSelection = random.nextInt(3) +3;
        return armorSelection;
    }

    public void printItem() {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void printMonster() {
        for (Character e : enemy) {
            System.out.println(e);
        }
    }

    public void printMenu() {

        System.out.println(" === MENU === ");
        System.out.println("1.Character");
        System.out.println("2.Remaining monsters");
        System.out.println("3.Item");
        System.out.println("4.Attack");
        System.out.println("5.Exit");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number :");
        int number = scan.nextInt();

        switch (number) {
            case 1:
                System.out.println(hero);
                break;
            case 2:
                printMonster();
                break;
            case 3:
                printItem();
                break;
            case 4:
                war();
                break;
            case 5:
                System.out.println("The character gave up fighting.");
                System.exit(0);
                break;
            default:
                printMenu();
                break;
        }

    }

    public void war() {
        System.out.println( " === " + laps + ".laps === ");

        if ( !hero.hasWeapon() || !hero.hasArmor()) {
            System.out.println(" === Characters receive random items ===");
            int weaponSelection = randomWeaponSelection();
            int armorSelection = randomArmorSelection();
            // Hero modtager genstande
            hero.addItem(items.get(weaponSelection));
            hero.addItem(items.get(armorSelection));

            hero.printItem();

            // Hero vælger weapon og armor
            hero.setWeapon(items.get(weaponSelection).getName());
            hero.setArmor(items.get(armorSelection).getName());

        }


        // Et tilfældigt tal svarende til antallet af monstre på fjendelisten genereres,
        // og et monster udvælges tilfældigt.
        int enemySelection = random.nextInt(enemy.size());
        Character opponent = enemy.get(enemySelection);

        // Monster modtager tilfældige genstande
        int enemyWeaponSelection = randomWeaponSelection();
        int enemyArmorSelection = randomArmorSelection();
        opponent.addItem(items.get(enemyWeaponSelection));
        opponent.addItem(items.get(enemyArmorSelection));
        // Monster vælger weapon og armor
        opponent.setWeapon(items.get(enemyWeaponSelection).getName());
        opponent.setArmor(items.get(enemyArmorSelection).getName());
        opponent.printItem();

        // Characters udskrives
        System.out.println(hero);
        System.out.println(opponent);


        while (hero.isAlive() && opponent.isAlive()) {
            System.out.println(" === Attack Begins === ");
            hero.attack(opponent);
            hero.levelUp();
            if (opponent.isAlive()) {
                System.out.println(" === Counterattack === ");
                opponent.attack(hero);
            }
        }

        System.out.println("------------------------");
        hero.heal(random.nextInt(100)+1);
        if (hero.isHealthCritical()) {
            System.out.println(hero.getName() + " WARNING: Find a healer!");
        }

        // fjerner opponent
        enemy.remove(opponent);
        laps++;
    }


    void main() {

        hero.setHealth(200);

        // Vi definerer Monster
        enemy.add(new Character("Goblin",'R'));
        enemy.add(new Character("Fire Imp", 'M'));
        enemy.add(new Character("Cave Orc", 'w'));
        enemy.add(new Character("Rotting Zombie", 'U'));
        enemy.add(new Character("Dark Wolf", 'B'));

        // Vi definerer Item
        items.add(new Item("Sword", 2.5, 80, 85, 100, 0, "A"));
        items.add(new Item("Bow", 3.5, 100, 80, 120, 0, "A"));
        items.add(new Item("Dagger", 1.9, 110, 90, 100, 0, "A"));
        items.add(new Item("Shield", 4.5, 75, 0, 90, 55, "D"));
        items.add(new Item("Robe", 2, 77, 0, 85, 50, "D"));
        items.add(new Item("Armor", 2.3, 140, 0, 100, 45, "D"));

        while (hero.isAlive() && !enemy.isEmpty()){
            printMenu();
        }

    }

}
