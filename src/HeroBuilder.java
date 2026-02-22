/*double maxHealth = 100;
// Iteration 1: Variables
// First character
String firstName = "Ragnar";
int firstHealthPoint = 85;
int firstLevel = 5;
double firstPlayerScore = 2300;
double firstGold = 156.50;
boolean firstIsLive = true;
char firstType = 'W';  // warrior
String[] firstInventory = {"Sword", "Shield", "Potion"};

// Second character
String secondName = "Seer";
int secondHealthPoint = 70;
int secondLevel = 15;
double secondPlayerScore = 6000;
double secondGold = 500.6;
boolean secondIsLive = true;
char secondType = 'M';  // Mage
String[] secondInventory = {"Sword", "Shield", "Potion"};*/

/*
void printCharactersTitle(String characters){
    System.out.println("\n=== " + characters + " CHARACTER SHEET ===");
}
*/

/*void printCharactersSheet(){
    System.out.println("Name: " + firstName);
    System.out.println("Class: " + firstType);
    System.out.println("Level: " + firstLevel);
    System.out.println("Health: " + firstHealthPoint + "/" + maxHealth);
    System.out.println("XP: " + firstPlayerScore);
    System.out.println("Gold : " + firstGold);
    System.out.println("Alive: " + isAlive ());
}*/

/*void printInventory(String[] inventory){
    System.out.println("Inventory (" + inventory.length +   " items):");
    for (int i = 0; i < inventory.length; i++) {
        System.out.println("- " + inventory[i]);
    }
}*/

/*void takeDamage(int amount) {
    int oldHealthPoint = 0;
    oldHealthPoint = firstHealthPoint;
    firstHealthPoint -= amount;
    firstHealthPoint = clamp(firstHealthPoint, 0, 100);
    System.out.println();
    System.out.print(firstName + " takes " + amount + " damage ");
    System.out.print("Health: " + oldHealthPoint + " -> " + firstHealthPoint);
}*/

/*void heal(int amount){
    int oldHealthPoint = 0;
    oldHealthPoint = firstHealthPoint;
    firstHealthPoint += amount;
    firstHealthPoint = clamp(firstHealthPoint, 0, 100);
    System.out.println();
    System.out.print(firstName + " heals " + amount + " HP ");
    System.out.print("Health: " + oldHealthPoint + " -> " + firstHealthPoint);
}*/

/*void addGold(double amount){
    double oldHealthGold = 0;
    oldHealthGold = firstGold;
    firstGold += amount;
    System.out.println();
    System.out.print(firstName + " takes " + amount + " gold ");
    System.out.print("GOLD: " + oldHealthGold + " -> " + firstGold);
}*/

/*void addXP(int amount) {
    firstPlayerScore += amount;
    System.out.println();
    System.out.print(firstName + " gains " + amount + " XP! ");
    System.out.print("Total : " + firstPlayerScore);
    System.out.println();
}*/

/*boolean levelCheck (){
    int threshold = firstLevel * 1000;
    if (firstPlayerScore > threshold) {
        return true;
    } else {
        return false;
    }
}*/

/*void printLevelUp(){
    System.out.println("\n=== STATUS ===");
    System.out.println("Ready to level up");
    System.out.println(firstName + " is leveling up to level " + (firstLevel + 1));
    System.out.println();
}*/

/*void levelUp (){
    if (levelCheck() && isAlive()) {
        printLevelUp();
        firstLevel++;
        firstPlayerScore = 0;
        firstHealthPoint = 100;
    }
}*/

/*

boolean isAlive (){
    return firstHealthPoint > 0;
}
*/

/*int clamp(int value, int min, int max){
    if (value < min) {
        return min;
    } else if (value > max) {
        return max;
    } else {
        return value;
    }
}*/

/*boolean removeGold(double amount){
    if (firstGold > 0) {
        firstGold -= amount;
        return true;
    } else {
        return false;
    }

}*/
/*

boolean isHealthCritical() {
    return firstHealthPoint > 0 && firstHealthPoint < 25 * maxHealth / 100 ;
}

double getHealthPercentage(){
    return firstHealthPoint * 100 / maxHealth;
}
*/



/*
void main (){



    printCharactersTitle("FIRST");
    printCharactersSheet();
    printInventory(firstInventory);

   */
/* printCharactersTitle("SECOND");
    printCharactersSheet();
    printInventory(secondInventory);*//*


    if (removeGold(100.0)) {
        System.out.println("\nBought a potion!");
    } else {
        System.out.println("Not enough gold!");
    }

    while (isAlive()) {

        Random number = new Random();
        int attack = number.nextInt(100);
        int heal = number.nextInt(100);
        int gold = number.nextInt(500);
        int xp = number.nextInt(5000);

        heal(heal);
        takeDamage(attack);
        addGold(gold);
        addXP(xp);


        if (isHealthCritical()) {
            System.out.println("WARNING: Find a healer!");
        }

        System.out.println("Health: " + getHealthPercentage() + "%");

        levelUp();

    }

    printCharactersTitle("FIRST");
    printCharactersSheet();
    printInventory(firstInventory);


}

*/



