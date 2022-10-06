public class LinkedList<T> {

    // A Node is the internal structure used to store each
    // piece of data in the list.  Each node holds one
    // piece of data (of type T), and a link (reference) to
    // the next node.
    // Node is a private class, accessible only to the
    // LinkedList class.  A lot of descriptions of linked
    // lists are written such that the Node structure itself
    // is visible globally; that's a really bad idea, since
    // it means any code in the program can modify the list.
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // instance variables

    // We have two special nodes: the first node in the list
    // (called 'front' here) and the last node (called 'back'
    // here).  Additions to the list may be performed at the
    // front or the back, but removals may only be done at
    // the front.
    // Class invariant: either front==null and back==null, or
    // front!=null and back!=null.  We cannot have only one
    // of the two being null.
    private Node front = null;
    private Node back = null;

    // We keep explicit count of the number of items in the
    // list.  If we didn't do this, then the size() method
    // would require us to traverse the list every time,
    // which would be very time consuming for a large list.
    // Class invariant: numItems==0 if and only if both
    // 'front' and 'back' are null.
    private int numItems = 0;

    // addFront - add a new item to the front of the list
    // Note that we need to make sure that if the list was
    // originally empty, the 'back' reference is also set
    // to this one-and-only item.
    public void addFront(T item) {
        Node newNode = new Node(item, front);
        front = newNode;
        if (back == null)
            back = newNode;
        numItems += 1;
    }

    // addBack - add a new item to the back of the list
    // Note that we need to make sure that if the list was
    // originally empty, the 'front' reference is also set
    // to this one-and-only item.
    public void addBack(T item) {
        Node newNode = new Node(item, null);
        if (back != null) {
            back.next = newNode;
        } else {
            front = newNode;
        }
        back = newNode;
        numItems += 1;
    }

    // removeFront - remove the front-most item and return it
    // Note that we need to consider (1) whether the list was
    // already empty, and (2) whether we removed the only item,
    // in which case we need to set the 'back' reference to null.
    public T removeFront() {
        if (front == null) {
            return null;
        }
        T t = front.data;
        front = front.next;
        if (front == null)
            back = null;
        numItems -= 1;
        return t;
    }

    // size - return the size of the list
    public int size() {
        return numItems;
    }

    // isEmpty - return true if the list is empty,
    // and false otherwise.
    public boolean isEmpty() {
        return numItems == 0;
    }

    // We'll use main() as a 'test client'; that is, we
    // use it to perform some minimal sanity checks to
    // make sure the LinkedList class is acting properly.
    // More complete tests would use JUnit or some other
    // testing framework (well beyond the scope of this
    // course).
    public static void main(String[] args) {

        int test = 0;
        assert test++ == 0;
        if (test == 0) {
            System.out.println("This needs to be run with -ea.");
            System.exit(1);
        }

        LinkedList<String> ll = new LinkedList<String>();
        assert ll.size() == 0;
        assert ll.isEmpty();

        ll.addFront("Groucho");
        ll.addFront("Zeppo");
        ll.addBack("Harpo");
        assert ll.size() == 3;
        assert !ll.isEmpty();

        String s = ll.removeFront();
        assert s.equals("Zeppo");
        assert ll.size() == 2;
        assert !ll.isEmpty();

        s = ll.removeFront();
        assert s.equals("Groucho");
        s = ll.removeFront();
        assert s.equals("Harpo");

        assert ll.size() == 0;
        assert ll.isEmpty();
    }
}
