package com.pranay.GeeksForGeeks;

import java.util.*;
import java.util.stream.Collectors;

public class InvalidTransactions {
// ["lee,886,1785,beijing","alex,763,1157,amsterdam","lee,924,859,barcelona","alex,397,1464,barcelona","bob,412,1404,amsterdam"]
    public static void main(String[] args) {
        String[] transactions = {"lee,886,1785,beijing","alex,763,1157,amsterdam","lee,277,129,amsterdam","bob,770,105,amsterdam","lee,603,926,amsterdam","chalicefy,476,50,budapest","lee,924,859,barcelona","alex,302,590,amsterdam","alex,397,1464,barcelona","bob,412,1404,amsterdam","lee,505,849,budapest"};
        List<String> invalidTxn = invalidTransactions(transactions);
        System.out.println(invalidTxn);
    }

    private static List<String> invalidTransactions(String[] transactions) {
        String prev = null;
        String curr = null;
        Set<String> invalidTxn = new LinkedHashSet<>();
        Map<String, String> hm = new HashMap<>();

        for (String tx : transactions) {
            curr = tx;
            String[] txn = curr.split(",");
            if (Integer.parseInt(txn[2]) > 1000) {
                invalidTxn.add(curr);
            }

            if (hm.containsKey(txn[0])) {
                prev = hm.get(txn[0]);
                System.out.println("curr : " + curr);
                System.out.println("prev : " + prev);
                String txnPrev[] = prev.split(",");
                if (txnPrev[0].equals(txn[0]) && Math.abs(Integer.parseInt(txn[1]) - Integer.parseInt(txnPrev[1])) <60 && !txnPrev[3].equals(txn[3]) ) {
                    System.out.println(prev + " ==== " +curr);
                    invalidTxn.add(prev);
                    invalidTxn.add(curr);
                }
            }

            if (hm.containsKey(txn[0])) {
                String prevs = hm.get(txn[0]);
                String prevStr[] = prevs.split(",");
                if (Integer.parseInt(prevStr[1]) < Integer.parseInt(txn[1]))
                    hm.put(txn[0], tx);
            } else{
                hm.put(txn[0], tx);
            }
            hm.forEach((k, v) -> System.out.println(k + " - " + v));
            System.out.println();
        }
        return invalidTxn.stream().collect(Collectors.toList());
    }
}
