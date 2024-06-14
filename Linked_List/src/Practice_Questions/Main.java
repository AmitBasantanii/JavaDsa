package Practice_Questions;

public class Main {
    public static void main(String... args) {
        LinkedList linkedList = new LinkedList();

        linkedList.createLL(1);

        linkedList.insertInLL(2);
        linkedList.insertInLL(3);
        linkedList.insertInLL(2);
        linkedList.insertInLL(5);

        linkedList.traverseLL();

        remove_duplicates_from_unsortedLL removeDuplicatesFromUnsortedLL = new remove_duplicates_from_unsortedLL();
        removeDuplicatesFromUnsortedLL.deleteDuplicates(linkedList);
        linkedList.traverseLL();

        return_Nth_to_last returnNthToLast = new return_Nth_to_last();

        Node n = returnNthToLast.nthToLast(linkedList, 4);
        System.out.println(n.value);

        // partition
        linkedList.insertInLL(9);
        linkedList.insertInLL(5);
        linkedList.insertInLL(10);
        linkedList.insertInLL(2);

        Partition p = new Partition();
        LinkedList t = p.partition(linkedList, 4);
        t.traverseLL();


    }

}
