package Open_Addressing.Linear_Probing;

public class Main {
    public static void main(String[] args) {

        LinearProbing linearProbing = new LinearProbing(13);

        linearProbing.insertInHashTable("The");
        linearProbing.insertInHashTable("quick");
        linearProbing.insertInHashTable("brown");
        linearProbing.insertInHashTable("animal");
        linearProbing.insertInHashTable("over");

        linearProbing.displayHashTable();

        linearProbing.searchHashTable("animal");

        linearProbing.searchHashTable("a");

        linearProbing.deleteKeyHashTable("over");
    }
}
