package Practice_Questions;

public class return_Nth_to_last {
    Node nthToLast ( LinkedList linkedList,int n) {
        Node p1 = linkedList.head;
        Node p2 = linkedList.head;

        for (int i=0; i<n; i++) {
            if( p2 == null) {
                return null;
            }
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
