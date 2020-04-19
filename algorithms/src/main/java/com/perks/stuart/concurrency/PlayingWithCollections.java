package com.perks.stuart.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PlayingWithCollections {

    void playing() {
        Map<String, List<String>> data = new ConcurrentHashMap<>();


        // add and create list if not
        data.computeIfAbsent("a", k -> new ArrayList<>()).add("Pow");

        // kotlin
        // store.getOrPut("A", { mutableListOf<String>() }).add("New Value")

        data.computeIfAbsent("b", k -> new ArrayList<>()).add("lol");

        data.computeIfAbsent("a", k -> new ArrayList<>()).add("haha");

        data.forEach((k, v) -> System.out.println("Key:" + k + " value: " + v));
        // remove if there
        data.computeIfPresent("a", (k, v) -> data.remove("a"));

        // data.computeIfPresent()
        //listOf(1,2,3).map { it.inc() }.reduce { sum, element -> sum + element }

        data.forEach((k, v) -> System.out.println("Key:" + k + " value: " + v));
    }

    public static void main(String[] args) {
        PlayingWithCollections coll = new PlayingWithCollections();

        coll.playing();
    }


}
