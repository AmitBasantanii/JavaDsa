package Practice_Questions;

import java.util.HashSet;

public class remove_duplicates_from_unsortedLL {

    public void deleteDuplicates(LinkedList linkedList) {
        HashSet<Integer> hashSet = new HashSet();

        Node current = linkedList.head;
        Node previous = null;

        while (current != null) {
            int currentValue = current.value;
            if(hashSet.contains(currentValue)) {
                previous.next = current.next;
                linkedList.size--;
            }
            else {
                hashSet.add(currentValue);
                previous = current;
            }
            current = current.next;
        }
    }
}
