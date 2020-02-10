print("Insertion Sort")


def insertion_sort(unsorted):
    """Insertion sort based on Introduction to Algorithms Book (Cormen et al)
    Time O(n^2) Space O(1) STABLE Sorts in Place"""
    for j in range(1, len(unsorted)):
        key = unsorted[j]
        i = j - 1
        while i >= 0 and unsorted[i] > key:
            unsorted[i + 1] = unsorted[i]
            i = i - 1

        unsorted[i + 1] = key

    return unsorted
