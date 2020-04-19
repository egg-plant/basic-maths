package com.perks.stuart.problem.solving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleFormat {


    void fun() {
        System.out.println("mtString".toLowerCase());
    }

    public static void main(String[] args) {
        Map<String, Integer> toyCount = new HashMap<>();

        //toyCount.getOrDefault()

        SampleFormat format = new SampleFormat();
        format.fun();

        List<String> toys = new ArrayList<String>();
        toys.add("my");

        System.out.println("".split(" ")[0]);

        if (toys.contains("my".toLowerCase())) {
            System.out.println("It does");
        }
    }

}
