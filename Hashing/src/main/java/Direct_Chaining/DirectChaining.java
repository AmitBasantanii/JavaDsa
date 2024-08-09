package Direct_Chaining;

import java.util.LinkedList;

public class DirectChaining {

    LinkedList<String> [] hashTable;

    int maxChainSize = 5;

    DirectChaining (int size) {
        hashTable = new LinkedList[size];
    }

    // creating hash table index for providing the place to the word
    public int modASCIIHashFunction (String word, int M) {
        char ch[];

        ch = word.toCharArray();
        int i;
        int sum;

        for (sum = 0, i = 0; i<word.length(); i++) {
            sum = sum + ch[i];
        }

        return sum % M;
    }

    // inserting in hash table
    public void insertHashTable (String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);

        if (hashTable[newIndex] == null) {
            hashTable[newIndex] = new LinkedList<String>();
            hashTable[newIndex].add(word);
        }
        else {
            hashTable[newIndex].add(word);
        }
    }

    // displaying the hash table
    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("\n Hash Table does not exists !!");
            return;
        }

        else {
            System.out.println("\n -----------Hash Table ----------");

            for (int i=0; i<hashTable.length; i++) {
                System.out.println("Index" + i + "key : " + hashTable[i]);
            }
        }
    }

    // searching for the value in the hash table
    public boolean searchHashTable (String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);

        if (hashTable[newIndex] != null && hashTable[newIndex].contains(word)) {

            System.out.println("\n" + "\"" + word + "\"" + "found in Hash Table at location : " + newIndex );
            return true;
        }

        else {
            System.out.println("\n" + "\"" + word + "\"" + "not found in HashTable");
            return false;
        }
    }

    // deleting the key from the hash table
    public void deleteKeyHashTable (String word) {
        int newIndex = modASCIIHashFunction(word, hashTable.length);

        boolean result = searchHashTable(word);

        if (result == true) {
            hashTable[newIndex].remove(word);

            System.out.println("\n" + "\"" + word + "\"" + "has been deleted from the hash table");
        }
    }
}
