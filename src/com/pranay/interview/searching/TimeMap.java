package com.pranay.interview.searching;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 * https://leetcode.com/problems/time-based-key-value-store/
 * ["TimeMap","set","get","get","set","get","get","get"]
 * [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5],["foo",1]]
 *
 * ["TimeMap","set","set","set","set","get","get","get","get","get","get","set","get","get","get","set","set","set","set","get","get"]
 * [[],["ctondw","ztpearaw",1],["vrobykydll","hwliiq",2],["gszaw","ztpearaw",3],["ctondw","gszaw",4],["gszaw",5],["ctondw",6],["ctondw",7],["gszaw",8],["vrobykydll",9],["ctondw",10],["vrobykydll","kcvcjzzwx",11],["vrobykydll",12],["ctondw",13],["vrobykydll",14],["ztpearaw","zondoubtib",15],["kcvcjzzwx","hwliiq",16],["wtgbfvg","vrobykydll",17],["hwliiq","gzsiivks",18],["kcvcjzzwx",19],["ztpearaw",20]]
 *
 * [null,null,null,null,null,"","gszaw","gszaw","","","gszaw",null,"kcvcjzzwx","","kcvcjzzwx",null,null,null,null,"",""]
 * [null,null,null,null,null,"ztpearaw","gszaw","gszaw","ztpearaw","hwliiq","gszaw",null,"kcvcjzzwx","gszaw","kcvcjzzwx",null,null,null,null,"hwliiq","zondoubtib"]
 */
public class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public static void main(String[] args) {
        TimeMap tm = new TimeMap();
        tm.set("ctondw","ztpearaw",1);
        tm.set("vrobykydll","hwliiq",2);
        tm.set("gszaw","ztpearaw",3);
        tm.set("ctondw","gszaw",4);
        System.out.println(tm.get("gszaw",5));
        System.out.println(tm.get("ctondw",6));
        System.out.println(tm.get("ctondw",7));
        System.out.println(tm.get("gszaw",8));
        System.out.println(tm.get("vrobykydll",9));
        System.out.println(tm.get("ctondw",10));
    }

    private String get(String k, int ts) {
        if (!timeMap.containsKey(k))
            return "";

        TreeMap<Integer, String> tm = timeMap.get(k);
        Integer newTs = tm.floorKey(ts);

        return newTs == null ? "" : tm.get(newTs);
    }

    private void set(String key, String val, int ts) {
        timeMap.computeIfAbsent(key, k -> new TreeMap<>()).put(ts, val);
    }
}
