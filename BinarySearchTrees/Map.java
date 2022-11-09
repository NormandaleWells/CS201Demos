public interface Map<Key,Value> {

    // Add a key/value pair to the map.  If there is
    // already an entry for this, it just updates
    // the value.
    void put(Key key, Value value);

    // Retrieve the value associated with the given
    // key.  Return null if there is no entry in the
    // map for this key.
    Value get(Key key);

    // Determine whether the map contains an entry
    // for this key.
    boolean contains(Key key);

    // Retrieve the maximum and minimum keys.
    Key minKey();
    Key maxKey();

    // Return the number of key/value pairs in the map.
    int size();

    // Determine whether the map is empty.
    boolean isEmpty();
}
