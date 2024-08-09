package Direct_Chaining;

public class Main {
    public static void main(String[] args ) {
        DirectChaining directChaining = new DirectChaining(13);

        directChaining.insertHashTable("The");
        directChaining.insertHashTable("quick");
        directChaining.insertHashTable("brown");
        directChaining.insertHashTable("animal");
        directChaining.insertHashTable("over");

        directChaining.displayHashTable();

        directChaining.searchHashTable("brown");

        directChaining.searchHashTable("blue");

        directChaining.deleteKeyHashTable("The");
    }
}
