package _2_4_Tree;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args ) throws IOException {
        boolean cycleController = true;
        Tree234 theTree = new Tree234();

        while (cycleController) {
            switch (getInput ( "[SsIiFfEe]", "\n(S)how, (I)nsert, (F)ind or (E)xit").charAt(0)) {
                case 's' : case 'S':
                    System.out.println("\n Typical 2-3-4 tree with 4 children structure : \n");
                    System.out.println("                                      ***");
                    System.out.println("        ***                ***                    ***               ***");
                    System.out.println(" *** *** *** ***            *** *** *** ***           *** *** *** ***             *** *** *** ***");
                    System.out.println("\n The tree contains : ");
                    theTree.printTree();
                    break;

                case 'i' : case 'I':
                    theTree.insert(Integer.parseInt(getInput("[0-9]+" , "Value to insert : ")));
                    break;

                case 'f' : case 'F' :
                    if (theTree.find(Integer.parseInt(getInput("[0,9]+ " , "Value to find : "))) != -1) {
                        System.out.println("Value is in the tree ");
                    }
                    else {
                        System.out.println("Value is not in the tree");
                    }
                    break;

                case 'e' : case 'E' :
                    cycleController = false;
                    break;

                default:
                    System.out.println("Invalid Entry \n");
            }
        }
    }

    public static String getInput(String filter, String message) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);

        while (!sc.hasNext(filter)) {
            System.out.println("Wrong Choice ");
            sc.next();
        }
        return sc.next();
    }
}
