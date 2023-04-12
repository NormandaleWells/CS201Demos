This combines the changes we did to create generic functions
(that is, when IntArrayUtils was converted to ArrayUtils by
making all the functions generic), and what we did to
create UnorderedIntSet and OrderedSetInt from IntSet.

The result is a generic class called OrderedSet.  To
summarize the changes (starting with OrderedIntSet):

(1) Added the type parameter to the Set interface
definition, and changed the appropriate methods
parameters from int to T.

(2) Added the type parameter to the class definition.
Note that once we may the class generic, we don't have
to mark the individual methods as generic.

(3) Changed the int[] instance variable to a T[].

(4) Mofified the contructor to create the array using
the really tortured syntax that Java requires to do that.

(5) Modified the instance methods to take parameters of
type T rather than int where necessary

Changing genericizing IntBinarySearch to create BinarySearch
was done outside of class, but involved the same sorts of
changes that were made to IntArrayUtils to create ArrayUtils.



Results of running this on my i7-9700 based desktop computer:

Reading set from .\100Kints.txt
Using OrderedSet
File read, creating list of (up to) 100000 items
There were 4886 duplicate items.
Elapsed time:    6.197 seconds.
Reading integers from .\100Kints.nodup.txt
9536 of 100000 integers were in the set
Elapsed time:    0.023 seconds.


Reading set from .\1Mints.txt
Using OrderedSet
File read, creating list of (up to) 1000000 items
There were 48432 duplicate items.
Elapsed time: 3168.079 seconds.
Reading integers from .\1Mints.nodup.txt
95092 of 1000000 integers were in the set
Elapsed time:    0.383 seconds.

Yes, it took nearly 53 minutes to create a set of 1M integers.

===============================================

Results of running this on an i7-1165G7 based HP
Pavilion laptop:

Reading set from .\100Kints.txt
Using OrderedSet
File read, creating list of (up to) 100000 items
There were 4886 duplicate items.
Elapsed time:    3.767 seconds.
Reading integers from .\100Kints.nodup.txt
9536 of 100000 integers were in the set
Elapsed time:    0.016 seconds.

Reading set from .\1Mints.txt
Using OrderedSet
File read, creating list of (up to) 1000000 items
There were 48432 duplicate items.
Elapsed time: 2347.834 seconds.
Reading integers from .\1Mints.nodup.txt
95092 of 1000000 integers were in the set
Elapsed time:    0.353 seconds.
