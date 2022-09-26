
// Counter is an ADT that abstracts a simple counter, with a name.
// There are three operations:
//      increment - increment the counter (Duh!)
//      getCount - returns the current count
//      toString - print the name and current count

// This is adapted from Sedgewick and Wayne, section 1.2.

// This code is over-commented for pedagogical purposes.

public class Counter {

    // instance variables - each Counter object gets its own private
    // version of these.  These are all private to prevent any code
    // other than the API defined by this class from directly accessing
    // or modifying them.

    // The name of the object.  This is provided to the constructor
    // and then never touched again, so we can make this 'final'.
    private final String name;

    // The count for this object - that is, the number of times that
    // increment() has been called on it.
    private int count;

    // Constructors

    // We have just one constructor, which just takes the Counter name.
    // Note that I'm using 'this' explicitly here to refer to instance
    // variables; this allows the use of 'name' for both the constructor
    // argument and the instance variable, using 'this.' to disambiguate
    // between them.
    // It isn't strictly necessary to initialize 'count' to 0, since Java
    // always initializes instance data to 0 (for integer types), 0.0 (for
    // floating point types), false (for booleans), or null (for reference
    // types), but I like to initialize everything explicitly so that a
    // future reader of the code knows that I considered it and knew that
    // 0 is an appropriate initial value.
    public Counter(String name) {
        this.name = name;
        this.count = 0;
    }

    // Instance methods - these are the ONLY methods that are allowed
    // to access or modify the instance variables.  Calling an instance
    // method requires the caller to specify the object to which the
    // method is being applied; the particular data modified/accessed
    // by the method is the instance data for that object.

    // increment - add one to the count for the given object
    public void increment() {
        count += 1;
    }

    // getCount - return the current count.  (S&W call this tally().)
    public int getCount() {
        return count;
    }

    // toString - create and return a String representation of this
    // object, in the form "<name> : <count>".
    // This function is inherited from the Object class, which every
    // class implicitly inherits from.  The default implementation
    // in the Object class is generally useless, so it's generally
    // best to implement this for every class.  (It also makes
    //debugging easier, since (1) it allows you to print out the
    // object's state at any time, and (2) some debuggers will call
    // toString() and show the result when hovering over an object.)
    @Override
    public String toString() {
        return String.format("%s : %d", name, count);
    }

    // equals - return true if this object is equal to the other,
    // and false otherwise.  "equal" here means they have the
    // same count.  Like toStrin g(), equals() is inherited from
    // the Object class.
    // See S&W page 103 for some details on how equals() needs to
    // be implemented to be consistent with Java's needs.
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;
        Counter c = (Counter)other;
        return c.count == this.count;
    }
}
