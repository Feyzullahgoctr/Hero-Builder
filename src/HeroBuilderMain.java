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
        System.out.println("=======================================");
        for (Item item : items) {
            System.out.println(item);
        }
        System.out.println("=======================================");
    }

    public void printMonster() {
        System.out.println("=======================================");
        for (Character e : enemy) {
            System.out.println(e);
        }
        System.out.println("=======================================");
    }

    public void printMenu() {

        System.out.println(" === MENU === ");
        System.out.println("0.Content");
        System.out.println("1.Character");
        System.out.println("2.Remaining monsters");
        System.out.println("3.Item");
        System.out.println("4.Attack");
        System.out.println("5.Exit");

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Number :");
        int number = scan.nextInt();

        switch (number) {
            case 0:
                printContents();
                break;
            case 1:
                System.out.println("=======================================");
                System.out.println(hero);
                System.out.println("=======================================");
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
        System.out.println( " =============== " + laps + ".laps  =============== ");

        if ( !hero.hasWeapon() || !hero.hasArmor()) {
            System.out.println(" === Characters receive random items ===");
            int weaponSelection = randomWeaponSelection();
            int armorSelection = randomArmorSelection();
            // Hero modtager genstande
            hero.addItem(items.get(weaponSelection));
            hero.addItem(items.get(armorSelection));
            // Hero vælger weapon og armor
            hero.setWeapon(items.get(weaponSelection).getName());
            hero.setArmor(items.get(armorSelection).getName());

            hero.printItem();

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
        System.out.println(" ============== Character ============== ");
        System.out.println(hero);
        System.out.println(opponent);
        System.out.println();


        // Koden kører indtil en af dem dør
        while (hero.isAlive() && opponent.isAlive()) {
            System.out.println(" ============ Attack Begins ============ ");
            hero.attack(opponent);
            hero.levelUp();
            System.out.println();
            if (opponent.isAlive()) {
                System.out.println(" ============ Counterattack ============ ");
                opponent.attack(hero);
                System.out.println();
            }
        }

        // Hero får tilfældige helbredspoint efter hvert monsterangreb.
        System.out.println("---------------------------------------");
        hero.heal(random.nextInt(100)+1);

        // Der udstedes en advarsel, hvis helbredstilstanden er under 25 %.
        if (hero.isHealthCritical()) {
            System.out.println(hero.getName() + " WARNING: Find a healer!");
        }

        // Hvis monsteret er dødt, fjernes det fra listen.
        if (!opponent.getIsLive()) {
            enemy.remove(opponent);
            System.out.println( opponent.getName() +" removes from list");
        }

        if (hero.isAlive()) {
            System.out.println(hero.getName() + " wins");
        } else {
            System.out.println(opponent.getName() + " wins!");
        }
        System.out.println();

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


        // While-løkken kører, indtil der ikke er flere fjender på listen.
        // Helten vil være i live.
        while (hero.isAlive() && !enemy.isEmpty()){
            printMenu();
        }

    }

    void printContents() {
        System.out.println("""
            
            ================= Den forklarer hvordan programmet fungerer ===================
           
            Der er en menu med følgende punkter:
            Character
            Monster
            Item
            Attack
            
            I starten har karakteren:
            Level 0
            Score 0
            Gold 100
            Ingen våben
            Ingen rustning
            
            Der er i alt 5 monstre.
            De har heller ingen våben eller rustning fra starten.            
            Når man vælger Attack, bliver et monster valgt tilfældigt.
            Både karakteren og monsteret får derefter tilfældigt valgt et våben og en rustning.
            Derefter angriber de hinanden på skift, indtil en af dem dør.            
            Når der udføres et attack, beregnes skaden ved at trække forsvarerens defense fra angriberens damage:
            
            Skade = Angriberens damage - Forsvarerens defense
            
            Den skade, der gives, fratrækkes forsvarerens health.
            Angriberen får guld svarende til halvdelen af den givne skade.
            Det samme beløb trækkes fra forsvarerens guld.            
            Derudover får angriberen XP svarende til 10 gange det optjente guld.
            Den optjente XP lægges til den samlede XP.            
            Hvis betingelsen for level er opfyldt, stiger karakterens level.            
            Derefter laver monsteret et modangreb.
            Her bruges samme logik (skade, guld, XP osv.).            
            De angriber hinanden skiftevis, indtil en af dem dør.            
            Hvis helten dør, afsluttes programmet helt.
            
            Hvis monsteret dør:
            - Helten får tilfældigt health tilbage.
            - Hvis heltens health falder under 25%, vises en advarsel på skærmen.
            - Monsteret fjernes fra listen.
            
            Derefter vises menuen igen.       
            Hvis man vælger Attack igen, fortsætter programmet på samme måde,
            indtil alle monstre er døde.
            Alternativt kan man vælge Exit for at afslutte programmet.
            
            ===============================================================================      
            """);

    }

}
