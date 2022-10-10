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
