import math

print("Binary search in Recursive fashion or Iterative")


def recursive_binary_search(data, start_index, end_index, to_find):
    if end_index >= start_index:
        mid_point = math.floor((start_index + end_index) / 2)

        # midpoint is found return it
        if data[mid_point] == to_find:
            return mid_point

        # midpoint is higher than to find check in lower half of list exclude midpoint
        elif data[mid_point] > to_find:
            return recursive_binary_search(data, start_index, mid_point - 1, to_find)

        # midpoint is lower than to find check in higher half of list exclude midpoint
        else:
            return recursive_binary_search(data, mid_point + 1, end_index, to_find)

    else:
        # Element is not in array
        return -1


# Test array
arr = [7, 42, 111, 200, 200]
x = 7

# Function call subtract one from length as its an indices so starts at zero but length starts at 1.
result = recursive_binary_search(arr, 0, len(arr) - 1, x)

if result != -1:
    print("Recursive Search element is present at index %d" % result)
else:
    print("Recursive Search is not present in array")


def iterative_binary_search(data, start_index, end_index, to_find):
    guess_count = 0

    while start_index <= end_index:
        guess_count += 1
        mid_point = math.floor((start_index + end_index) / 2)

        if data[mid_point] == to_find:
            print("Total guess is %d" % guess_count)
            return mid_point

        # midpoint is higher than to find check in lower half of list exclude midpoint
        elif data[mid_point] > to_find:
            end_index = mid_point - 1

        # midpoint is lower than to find check in higher half of list exclude midpoint
        else:
            start_index = mid_point + 1

    return -1


# Function call subtract one from length as its an indices so starts at zero but length starts at 1.
result = iterative_binary_search(arr, 0, len(arr) - 1, x)

if result != -1:
    print("Iterative Search Element is present at index %d" % result)
else:
    print("Iterative Search Element is not present in array")
