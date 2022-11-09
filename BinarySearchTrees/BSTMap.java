// BSTMap
//
// Implementation of the Map interface using an _unbalanced_
// binary search tree.

import java.util.ArrayList;

public class BSTMap<Key extends Comparable<Key>, Value> implements Map<Key, Value> {

    // Each Node stores a key/value pair, along with references
    // the left and right subtree.  For any Node n, the left
    // subtree contains keys less than n.key, and the right
    // subtree contains keys greater than n.key.
    private class Node {
        Key key;
        Value value;
        Node left = null;
        Node right = null;

        Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    // The only Node we need an explicit reference to is
    // the root of the tree (the top-most node).
    Node root = null;

    // Traversing the tree to find the number of Nodes is
    // a O(N) operation - and a slow one at that.  We're
    // better off keeping an explicit count of the number
    // of nodes.
    int numElements = 0;

    // Add a key/value pair to this subtree (or update an
    // existing entry if this key already exists).
    private Node put(Key key, Value value, Node subtreeRoot) {

        if (subtreeRoot == null) {
            numElements++;
            return new Node(key, value);
        }

        // See how the key we're looking for compares to
        // the key at the root of this subtree.
        int c = key.compareTo(subtreeRoot.key);

        // If c == 0, we update the value for this key.
        // Otherwise, try to add the key to the
        // appropriate subtree.
        if (c < 0)
            subtreeRoot.left = put(key, value, subtreeRoot.left);
        else if (c > 0)
            subtreeRoot.right = put(key, value, subtreeRoot.right);
        else
            subtreeRoot.value = value;

        // Return the node we're given!  This will
        // relink this node back into the parent.
        return subtreeRoot;
    }

    // Add a key to the set.
    @Override
    public void put(Key key, Value value) {
        root = put(key, value, root);
    }

    // Retrieve the value associated with the
    // given key, or null if no such key exists.
    // Note that this is NOT recursive!  This is
    // just as easy to do iteratively.
    @Override
    public Value get(Key key) {
        Node n = root;
        while (n != null) {
            int c = key.compareTo(n.key);
            if (c == 0)
                return n.value;
            else if (c < 0)
                n = n.left;
            else
                n = n.right;
        }
        return null;
    }

    // Check to see if the given key exists.  The
    // easiest way to do this is to call get() and
    // check to see whether that returned null.
    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // Return the size of the tree.
    @Override
    public int size() {
        return numElements;
    }

    // Determine whether the Map is empty.
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    // Return the minimum key.
    @Override
    public Key minKey() {
        // Just start at the root and keep going
        // down the left side of the tree.
        Node n = root;
        while (n != null) {
            n = n.left;
        }
        return n == null ? null : n.key;
    }

    // Return the maximum key.
    @Override
    public Key maxKey() {
        // Just start at the root and keep going
        // down the right side of the tree.
        Node n = root;
        while (n != null) {
            n = n.right;
        }
        return n == null ? null : n.key;
    }

    // An in-order traversal of a subtree rooted at n first
    // recursively visits the left subtree, then n.key, then
    // recursively visits the right subtree.
    // For our purposes here, "visits" means it adds the
    // key to an ArrayList.
    private void inOrderTraversal(Node n, ArrayList<Key> keys) {
        if (n == null) return;
        inOrderTraversal(n.left, keys);
        keys.add(n.key);
        inOrderTraversal(n.right, keys);
    }

    // Return a String representation of the tree.  This will
    // be a string in the form:
    //      [ (<key>,<value>)... ]
    @Override
    public String toString() {
        ArrayList<Key> keys = new ArrayList<Key>();
        inOrderTraversal(root, keys);
        String s = "[ ";
        for (Key key : keys) {
            s += String.format("(%s,%s) ", key, get(key));
        }
        s += "]";
        return s;
    }

    public static void main(String[] args) {
        BSTMap<String,Integer> map = new BSTMap<>();
        System.out.println("Is empty? : " + map.isEmpty());
        System.out.println("Contains 42? : " + map.contains("forty two")); 

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);
        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        System.out.println("Size = " + map.size());
        System.out.println("Does 7 exist? : " + map.contains("seven"));
        System.out.println("Does 13 exist? : " + map.contains("thirteen"));
        System.out.println(map);
    }
}
