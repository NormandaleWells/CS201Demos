// SCHashMap.java
//
// Implementation of the Map interface as a hash table, using
// sepa/rate chaining to resolve collisions.

import java.util.ArrayList;

public class SCHashMap<Key, Value> implements Map<Key, Value> {

    // Our alpha threshold.
    private final double alphaMax = 4.0;

    // We don't want to resize by doubling the array; that would
    // make the size a non-prime number.  Instead, we'll store
    // a static array of potential array sizes.  Note that we're
    // limited to 397 * alphaMax items here.
    private static final int[] primes = { 5, 11, 23, 47, 97, 197, 397 };

    private class KV {
        Key key;
        Value value;

        public KV(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    // The actual hash table is an array of ArrayList objects.
    // Note that we don't create the actual ArrayList at any
    // given index until we need to.
    @SuppressWarnings("unchecked")
    ArrayList<KV>[] ht = (ArrayList<KV>[]) new ArrayList[primes[0]];

    // primesIndex is the index of the current hash table size.
    int primesIndex = 0;

    // We'll keep track of an explicit count of items.
    int numElements = 0;

    // resize() takes care of resizing the array if necessary
    // and rehashing all the existing entries to put them
    // in the new table.
    @SuppressWarnings("unchecked")
    private void resize() {

        // We'll store the old entries so we can rehash them.
        ArrayList<KV>[] oldEntries = ht;

        // Increment to the next size and resize the array.
        primesIndex++;
        ht = (ArrayList<KV>[]) new ArrayList[primes[primesIndex]];

        // Rehash all the current entries.  Note that we
        // are calling put(), even though that's what's
        // calling us.  But in this case we know that we've
        // already resized the array to hold all the existing
        // entries, so this avoids more than one level of
        // recursion.
        for (int i = 0; i <oldEntries.length; i++) {
            ArrayList<KV> kvList = oldEntries[i];
            if (kvList == null) continue;
            for (int j = 0; j < kvList.size(); j++) {
                KV kv = kvList.get(j);      // kv = kvList[j]
                put(kv.key, kv.value);
            }
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
        return (h & 0x7FFFFFFF) % ht.length;
    }

    // Given an ArrayList in a hash table entry, find the
    // index of the given key; return -1 if the key does
    // not exist.  It would have nice to use ArrayList.indexOf(),
    // but that would require writing KV.equals() in such
    // a way as to allow comparison to Key, but Java
    // generics are not flexible enough to do this easily.
    private int find(ArrayList<KV> kvList, Key key) {
        for (int i = 0; i < kvList.size(); i++) {
            KV kv = kvList.get(i);
            if (kv.key.equals(key))
                return i;
        }
        return -1;
    }

    @Override
    public void put(Key key, Value value) {

        // Hash the key to get an index into the hash table.
        int htIdx = hash(key);

        // If this entry is null, we know this key does not
        // exist yet, so we allocate a new list.
        ArrayList<KV> kvList = ht[htIdx];
        int idx = -1;
        if (kvList == null) {
            kvList = ht[htIdx] = new ArrayList<KV>();
        } else {
            // Otherwise, we need to search the existing list
            // for an entry containing this key.  Unfortunately,
            // Java does like to make life difficult when it comes
            // to generics.  I tried to use ArrayList.indexOf()
            // here, which would require modifying KV.equals() to
            // allow comparisons to objects of type Key, but that's
            // next to impossible to do with a parameterized type.
            // So an old-fashioned loop it is!
            idx = find(kvList, key);
        }

        // If we didn't find it, add a new entry.  Otherwise,
        // update the value associated with this key.
        if (idx != -1) {
            kvList.get(idx).value = value;
        } else {
            numElements++;
            if ((double) numElements / ht.length > alphaMax) {
                resize();
            }
            kvList.add(new KV(key, value));
        }
    }

    @Override
    public Value get(Key key) {

        // Get the hash index for this key.
        int htIdx = hash(key);

        // If there is no ArrayList at this
        // index, nothing has hashed to this
        // index yet, so we know we can
        // return null.
        ArrayList<KV> kvList = ht[htIdx];
        if (kvList == null) {
            return null;
        }

        // Look for an entry containing this
        // key.  If we get -1 back, the key
        // was not found, and we just return
        // null.  Otherwise, return the value
        // at this index.
        int idx = find(kvList, key);
        return idx == -1 ? null : kvList.get(idx).value;
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

    // toString() returns a string containing all the
    // key/value pairs in the hash table in the form
    // [ (<key>,<value>) ... ].
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[ ");
        for (int i = 0; i <ht.length; i++) {
            ArrayList<KV> kvList = ht[i];
            if (kvList == null) continue;
            for (int j = 0; j < kvList.size(); j++) {
                KV kv = kvList.get(j);
                s.append(String.format("(%s,%s) ", kv.key, kv.value));
            }
        }
        s.append("]");
        return s.toString();
    }

    public static void main(String[] args) {

        SCHashMap<String, Integer> map = new SCHashMap<>();
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
