public class LPHashMap<Key, Value> implements Map<Key, Value> {

    // Our alpha threshold.
    private final double alphaMax = 0.5;

    // We don't want to resize by doubling the array; that would
    // make the size a non-prime number.  Instead, we'll store
    // a static array of potential array sizes.  Note that we're
    // limited to 397 * alphaMax items here.
    private static final int[] primes = { 5, 11, 23, 47, 97, 197, 397 };

    // primesIndex is the index of the current hash table size.
    private int primesIndex = 0;

    // We'll keep track of an explicit count of items.
    private int numElements = 0;

    // We'll keep the keys and values in separate arrays.
    @SuppressWarnings("unchecked")
    Key[] keys = (Key [])new Object[primes[0]];
    @SuppressWarnings("unchecked")
    Value[] values = (Value[])new Object[primes[0]];

    // resize() takes care of resizing the array if necessary
    // and rehashing all the existing entries to put them
    // in the new table.
    @SuppressWarnings("unchecked")
    private void resize() {

        // We'll store the old entries so we can rehash them.
        Key[]   oldKeys   = keys;
        Value[] oldValues = values;

        // Increment to the next size and resize the arrays.
        primesIndex++;
        keys  = (Key    [])new Object[primes[primesIndex]];
        values = (Value [])new Object[primes[primesIndex]];

        // Rehash all the current entries.  Note that we
        // are calling put(), even though that's what's
        // calling us.  But in this case we know that we've
        // already resized the array to hold all the existing
        // entries, so this avoids more than one level of
        // recursion.
        for (int i = 0; i < oldKeys.length; i++) {
            if (oldKeys[i] != null)
                put(oldKeys[i], oldValues[i]);
        }
    }

    // Compute the hash index for this key.  Note that
    // we cannot simply use h % ht.length, because
    //  (1) h may be negative, which would give us a
    //      negative index; and
    //  (2) we can't use abs(h) % ht.length, because
    //      h could be Integer.MIN_INTEGER, whose
    //      absolute valid is Integer.MIN_INTEGER.
    private int hash(Key key) {
        int h = key.hashCode();
        return (h & 0x7FFFFFFF) % keys.length;
    }

    // Search for the given key in the array of
    // keys.  Stop if a null entry is hit.
    int find(Key key) {

        // Get the starting index for the search.
        int htIdx = hash(key);

        // Keep iterating through the array until
        // either we get a null entry, or one that
        // is equal to the given key.
        while ((keys[htIdx] != null) && !keys[htIdx].equals(key)) {
            htIdx++;
            if (htIdx == keys.length)
                htIdx = 0;
        }

        // At this point, either (1) keys[htIdx] is null,
        // or keys[htIdx] == key.  Either way, we have the
        // index we want, and we'll let the caller sort out
        // the details.
        return htIdx;
    }

    @Override
    public void put(Key key, Value value) {

        // Hash the key to get an index into the hash table.
        int htIdx = find(key);

        if (keys[htIdx] == null) {
            numElements++;
            if (((double)numElements / keys.length) > alphaMax)
                resize();
        }

        // Either keys[htIdx] is null and we have a new
        // entry, or keys[htIdx] is not null and we just
        // need to overwrite the existing value with a
        // new one.  Either way, we do the same thing!
        // (Adding an if to avoid overwriting the key
        // would be slower than just overwriting it with
        // the same value.)
        keys[htIdx] = key;
        values[htIdx] = value;
    }

    @Override
    public Value get(Key key) {

        // Hash the key to get an index into the hash table.
        int htIdx = find(key);

        // Either keys[htIdx] is null and there is no
        // entry for this key, or keys[htIdx] is not
        // null and we need to return the corresponding
        // value.  Either way, we do the same thing!
        // (Note that for a non-existent key, the
        // corresponding entry in the values array had
        // better be null!)
        return values[htIdx];
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        return numElements;
    }

    @Override
    public boolean isEmpty() {
        return numElements == 0;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[ ");
        for (int i = 0; i <keys.length; i++) {
            if (keys[i] != null)
                s.append(String.format("(%s,%s) ", keys[i], values[i]));
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {

        Map<String, Integer> map = new LPHashMap<>();
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
