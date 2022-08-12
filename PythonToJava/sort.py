
# swap two elements of an array
def swap(a, idx1, idx2):
    t = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = t


# return the index of the minimum element in
# the subrange [lo,hi) of list a.
def min_element(a, lo, hi):
    min_idx = lo
    for i in range(lo+1, hi):
        if a[i] < a[min_idx]:
            min_idx = i
    return min_idx


# sort the given list using the selection sort algorithm
def selection_sort(a):
    for i in range(0,len(a)):
        idx = min_element(a, i, len(a))
        swap(a, i, idx)


# sort the given list using the insertion sort algorithm
def insertion_sort(a):
    for i in range(1,len(a)):
        j = i
        while (j > 0 and a[j] < a[j-1]):
            swap(a, j, j-1)
            j -= 1


# test the selection_sort and insertion_sort functions
if __name__ == "__main__":
    a1 = [ 27, 82, 41, 124, 62, 31, 94 ]

    a = a1[:]
    selection_sort(a)
    print(a)

    a = a1[:]
    insertion_sort(a)
    print(a)

    weasleys = [ "Bill", "Charlie", "Percy", "George", "Fred", "Ron", "Ginny" ]
    insertion_sort(weasleys)
    print(weasleys)
