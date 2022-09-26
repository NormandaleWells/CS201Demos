
// Counter is a class that abstracts a simple counter, with a name.
// There are three operations:
//      increment - increment the counter (Duh!)
//      getCount - returns the current count
//      toString - print the name and current count

public class Counter {

    String name;
    int count;

    public Counter(String name) {
        this.name = name;
        this.count = 0;
    }

    public void increment() {
        count += 1;
    }

    public int getCount() {
        return count;
    }

    public String toString() {
        return String.format("%s : %d", name, count);
    }
}
