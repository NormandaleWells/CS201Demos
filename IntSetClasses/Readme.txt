This folder contains the final UnorderedIntSet and OrderedIntSet
classes created by starting with the IntSet class (from the IntSet
lab) and making the following changes:

(1) Change the class name to UnorderedIntSet.
(2) Create the 'set' and 'numElements' instance variables.
(3) Change the static functions into non-static methods, which
    also involves removing the 'set' and 'n' function parameters
    (since these are now instance variables of the class).

This requires the following changes to TestIntSet:

(1) Replace the code to create the 'set' and 'n' variables with
    'IntSet set = new IntSet(maxSize)'.
(2) Change the calls to add(), contains(), and countRange() to
    remove the 'set' and 'n' parameters.
(3) Use 'set.size()' instead of 'n' in println() calls.

I'm probably missing a few other differences, but these are the
main ones.

Then copy UnorderedIntSet to OrderedIntSet and make the necessary
changes to keep the array sorted.

CheckDuplicates.java is included to demonstrate the performance
different between ordered and unordered arrays.  createSet()
needs to be modified to switch between ordered and unordered arrays.
Yeah, this could be a command line parameter; maybe some day.

Here are the results from my (vintage 2016) laptop:

C:\Carleton\ClassDemos\Section01\IntSetClass>java CheckDuplicates 1Mints.txt 1Mints.nodup.txt
Reading set from 1Mints.txt
Using UnorderedIntSet
There were 48432 duplicate items.
Elapsed time:  131.357 seconds.
Reading integers from 1Mints.nodup.txt
95092 of 1000000 integers were in the set
Elapsed time:  279.937 seconds.

C:\Carleton\ClassDemos\Section01\IntSetClass>java CheckDuplicates 1Mints.txt 1Mints.nodup.txt
Reading set from 1Mints.txt
Using OrderedIntSet
There were 48432 duplicate items.
Elapsed time:  103.303 seconds.
Reading integers from 1Mints.nodup.txt
95092 of 1000000 integers were in the set
Elapsed time:    0.225 seconds.

The set creation is about 25% faster, but the set searching is where the
ordered arrays really shine, with a better than 1000x performance
improvement on 1 million items.
