package com.pranay.interview.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertKeyUsage {
    public static void main(String[] args) {
        String[] keyName = {"daniel", "daniel", "daniel", "luis", "luis", "luis", "luis"};
        String[] keyTime = {"10:00", "10:40", "11:00", "09:00", "11:00", "13:00", "15:00"};

        AlertKeyUsage ak = new AlertKeyUsage();
        List<String> names = ak.alertNames(keyName, keyTime);
        System.out.println("Ans : " + names);
    }

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];

            int t = convert(time);
            hm.computeIfAbsent(name, k -> new ArrayList<>()).add(t);
        }

        List<String> names = new ArrayList<>();

        for (String name : hm.keySet()) {
            List<Integer> checkout = hm.get(name);

            if (checkout.size() < 3)
                continue;

            Collections.sort(checkout);
            int lo = 0;
            for (int hi = 0; hi < checkout.size(); hi++) {
                if (checkout.get(hi) - checkout.get(lo) > 3601)
                    lo++;
                else {
                    if (hi - lo + 1 >= 3) {
                        names.add(name);
                        break;
                    }
                }

            }
        }
        Collections.sort(names);
        return names;
    }

    public int convert(String time) {
        String[] times = time.split(":");
        int hours = Integer.parseInt(times[0]);
        int mins = Integer.parseInt(times[1]);

        return (60 * mins) + (60 * 60 * hours);
    }
}
