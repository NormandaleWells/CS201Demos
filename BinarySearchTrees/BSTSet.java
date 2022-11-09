import java.util.ArrayList;

public class BSTSet<T extends Comparable<T>> implements Set<T> {

    private class Node {
        T key;
        Node left = null;
        Node right = null;

        Node(T key) {
            this.key = key;
        }
    }

    Node root = null;
    int numElements = 0;

    // Search for the given key, starting at this
    // surtree.
    private boolean contains(T key, Node subtreeRoot) {
        // If this is an empty subtree, the key does
        // not exist in the tree.
        if (subtreeRoot == null)
            return false;
        
        // See how the key we're looking for compares to
        // the key at the root of this subtree.
        int c = key.compareTo(subtreeRoot.key);

        // If they're equal, we found the key.
        if (c == 0)
            return true;

        // If less, search the left subtree.
        if (c < 0)
            return contains(key, subtreeRoot.left);

        // Otherwise, search the right subtree.
        return contains(key, subtreeRoot.right);
    }

    // Add the key to this subtree.
    private Node add(T key, Node subtreeRoot) {

        if (subtreeRoot == null) {
            numElements++;
            return new Node(key);
        }
        // See how the key we're looking for compares to
        // the key at the root of this subtree.
        int c = key.compareTo(subtreeRoot.key);

        // If c == 0, we drop down to the end.
        // Otherwise, try to add the key to the
        // appropriate subtree.
        if (c < 0)
            subtreeRoot.left = add(key, subtreeRoot.left);
        else if (c > 0)
            subtreeRoot.right = add(key, subtreeRoot.right);

        // Return the node we're given!  This will
        // relink this node back into the parent.
        return subtreeRoot;
    }

    @Override
    // Add a key to the set.
    public void add(T key) {
        root = add(key, root);
    }

    @Override
    // Search the entire tree for the given value.
    public boolean contains(T key) {
        return contains(key, root);
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private void inOrderTraversal(Node n, ArrayList<T> q) {
        if (n == null) return;
        inOrderTraversal(n.left, q);
        q.add(n.key);
        inOrderTraversal(n.right, q);
    }

    @Override
    public String toString() {
        ArrayList<T> q = new ArrayList<T>();
        inOrderTraversal(root, q);
        String s = "[ ";
        for (T item : q) {
            s += item.toString() + " ";
        }
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        BSTSet<Integer> set = new BSTSet<>();
        System.out.println("Is empty? : " + set.isEmpty());
        System.out.println("Contains 42? : " + set.contains(42)); 

        set.add(27);
        set.add(82);
        set.add(41);
        set.add(124);
        set.add(62);
        set.add(31);
        set.add(94);
        System.out.println("Size = " + set.size());
        System.out.println("Does 27 exist? : " + set.contains(27));
        System.out.println("Does 62 exist? : " + set.contains(82));
        System.out.println("Does 42 exist? : " + set.contains(42));
        System.out.println(set);
    }
}
