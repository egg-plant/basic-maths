package com.perks.stuart.problem.solving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringAndArrayProblems {

    boolean duplicatesInAString(String data) {
        if (data.isEmpty() || data.length() == 1) {
            return false;
        } else {

            char[] sorted = data.toCharArray();
            Arrays.sort(sorted);

            for (int i = 1; i < sorted.length; i++) {
                if (sorted[i - 1] == sorted[i]) {
                    return true;
                }
            }
            return false;

            // n * n log n asymptotic is n log n
        }
    }


    boolean duplicatesInAStringDataStructure(String data) {
        if (data.isEmpty() || data.length() == 1) {
            return false;
        } else {

            Map<Character, Integer> count = new HashMap<Character, Integer>();
            // We can use a set that doesnt allow unique keys or a table taht will show unique keys
            for (int i = 0; i < data.length(); i++) {
                if (count.containsKey(data.charAt(i))) {
                    //   int currentCOunt = count.get(data.charAt(i));
                    return true;
                    //  count.put(data.charAt(i), currentCOunt);
                } else {
                    count.put(data.charAt(i), 1);
                }
            }
            return false;

        }
    }

//    boolean checkPermutation(String a, String b) {
//
//        // store the first string in an array
//        // then loop over second string and decrement the counts of the string
//        // if array does not contain a key that is in the second string return false
//        // then check each value is zero for each key
//       if(a.length() != b.length()) {
//           return false;
//       }
//
//       Map<Character,Integer> mappedData = new HashMap<>(a.length());
//
//        for (int i = 0; i < a.length(); i++) {
//            if (mappedData.containsKey(a.charAt(i))) {
//                //   int currentCOunt = count.get(data.charAt(i));
//                return true;
//                //  count.put(data.charAt(i), currentCOunt);
//            } else {
//                mappedData.put(a.charAt(i), 1);
//            }
//        }
//
//    }

    // terminates with null
    String reverseCStyleString(String data) {
        char[] splitString = data.toCharArray();
        int i = 0;
        int j = splitString.length - 1;
        char temp;

        while (i < j) {
            temp = splitString[i];
            splitString[i] = splitString[j];
            splitString[j] = temp;
            i++;
            j--;
        }
        return new String(splitString);
    }

    String removeDuplicatesWithoutDataStructure(String data) {
        if (data == null || data.isEmpty()) return data;
        if (data.length() < 2) return data;
        StringBuilder stringBuilder = new StringBuilder(data);
        // TODO not the most efficient O(n^2)
        for (int i = 0; i < data.length(); i++) {
            for (int j = i + 1; j < data.length() - 1; j++) {
                if (data.charAt(i) == data.charAt(j)) {
                    stringBuilder.deleteCharAt(j);
                }
            }
        }
        return stringBuilder.toString();
    }

    // Two strings are said to be anagrams of one another if you can turn the first string into
    //the second by rearranging its letters.
    // Question are we including spaces
    // is it case senstive
    // can they differ in length the input?
    // can it contain characters punctuation
    boolean areTheseAnagrams(String a, String b) {
        // null checks
        return true;
    }


}
