int maxHealth = 100;

void main (){

    // First character
    String firstName = "Ragnar";
    int firstHealthPoint = 85;
    int firstLevel = 5;
    double firstPlayerScore = 2300;
    double firstGold = 156.50;
    Boolean firstIsLive = true;
    char firstType = 'W';  // warrior
    String[] firstInventory = {"Sword", "Shield", "Potion"};

    // Second character
    String secondName = "Seer";
    int secondHealthPoint = 70;
    int secondLevel = 15;
    double secondPlayerScore = 6000;
    double secondGold = 500.6;
    Boolean secondIsLive = true;
    char secondType = 'M';  // Mage
    String[] secondInventory = {"Sword", "Shield", "Potion"};

    System.out.println("=== FIRST CHARACTER SHEET ===");
    System.out.println("Name: " + firstName);
    System.out.println("Class: " + firstType);
    System.out.println("Level: " + firstLevel);
    System.out.println("Health: " + firstHealthPoint + "/" + maxHealth);
    System.out.println("XP: " + firstPlayerScore);
    System.out.println("Gold : " + firstGold);
    System.out.println("Alive: " + firstIsLive);
    System.out.println("Inventory (3 items):");
    System.out.println("- " + firstInventory[0]);
    System.out.println("- " + firstInventory[1]);
    System.out.println("- " + firstInventory[2]);

    System.out.println("=== SECOND CHARACTER SHEET ===");
    System.out.println("Name: " + secondName);
    System.out.println("Class: " + secondType);
    System.out.println("Level: " + secondLevel);
    System.out.println("Health: " + secondHealthPoint + "/" + maxHealth);
    System.out.println("XP: " + secondPlayerScore);
    System.out.println("Gold : " + secondGold);
    System.out.println("Alive: " + secondIsLive);
    System.out.println("Inventory (3 items):");
    System.out.println("- " + secondInventory[0]);
    System.out.println("- " + secondInventory[1]);
    System.out.println("- " + secondInventory[2]);



}