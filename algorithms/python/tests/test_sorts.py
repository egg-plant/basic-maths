import unittest
from python.sort.merge_sort import merge_sort
from python.sort.insertion_sort import insertion_sort


class SortingTestCases(unittest.TestCase):
    expected = [2, 3, 8, 115]

    def test_insertion_sort(self):
        self.assertEqual(insertion_sort([115, 3, 2, 8]), self.expected)

    def test_merge_sort(self):
        self.assertEqual(merge_sort([2, 3, 8, 115]), self.expected)


if __name__ == '__main__':
    unittest.main()
