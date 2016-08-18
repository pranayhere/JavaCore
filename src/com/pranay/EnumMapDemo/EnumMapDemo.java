package com.pranay.EnumMapDemo;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public class EnumMapDemo {

	public enum STATE {
		NEW, RUNNING, RUNNABLE, WAITING, FINISHED;
	}
	
	public static void main(String[] args) {
		Map<STATE, String> stateMap = (Map<STATE, String>) Collections.synchronizedMap(new EnumMap<STATE, String>(STATE.class));
		stateMap.put(STATE.RUNNING, "b");
		stateMap.put(STATE.FINISHED, "c");
		stateMap.put(STATE.NEW, "a");
		stateMap.put(STATE.NEW, "d");
		stateMap.put(STATE.WAITING, "e");
		stateMap.put(STATE.RUNNABLE, "g");
	
		System.out.println("EnumMap: " + stateMap);
	 
		Iterator<STATE> enumKeySet = stateMap.keySet().iterator();
        while(enumKeySet.hasNext()){
            STATE currentState = enumKeySet.next();
            System.out.println("key : " + currentState + " value : " + stateMap.get(currentState));
        }

        System.out.println("Does stateMap has :" + STATE.NEW + " : " 
                +  stateMap.containsKey(STATE.NEW));
	}
}
