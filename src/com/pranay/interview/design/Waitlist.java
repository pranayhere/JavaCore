package com.pranay.interview.design;

import java.util.HashMap;
import java.util.Map;

class DLL {
    static class ListNode {
        String name;
        Integer party;
        ListNode prev, next;

        public ListNode(String name, Integer party) {
            this.name = name;
            this.party = party;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "name='" + name + '\'' +
                    ", party=" + party +
                    '}';
        }
    }

    ListNode head = null;
    ListNode tail = null;

    public ListNode addNode(String val, Integer party) {
        ListNode curr = new ListNode(val, party);

        if (head == null) {
            head = tail = curr;
            head.prev = null;
            tail.next = null;
        } else {
            tail.next = curr;
            curr.prev = tail;
            tail = curr;
            tail.next = null;
        }

        return curr;
    }

    public void remove(ListNode node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = head.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = tail.prev;
        }
    }

    public ListNode getFirst() {
        ListNode first = head;
        head = head.next;

        return first;
    }
}

public class Waitlist {
    Map<String, DLL.ListNode> nodeTracker;
    Map<Integer, DLL> waitingList;

    public Waitlist() {
        nodeTracker = new HashMap<>();
        waitingList = new HashMap<>();
    }

    public static void main(String[] args) {
        Waitlist wl = new Waitlist();
        wl.add("pranay", 4);
        wl.add("poonam", 5);
        wl.add("rujju", 4);
        wl.add("praju", 5);
        wl.add("rahul", 5);

        wl.remove("rahul");
        System.out.println(wl.allocate(5));
        System.out.println(wl.allocate(5));

        System.out.println(wl.allocate(4));
        System.out.println(wl.allocate(4));

    }

    private void add(String name, Integer party) {
        if (!waitingList.containsKey(party)) {
            waitingList.put(party, new DLL());
        }

        DLL dll = waitingList.get(party);
        DLL.ListNode curr = dll.addNode(name, party);
        nodeTracker.put(name, curr);
    }

    private void remove(String name) {
        if (!nodeTracker.containsKey(name)) {
            return;
        }

        DLL.ListNode rm = nodeTracker.get(name);
        Integer party = rm.party;

        DLL dll = waitingList.get(party);
        dll.remove(rm);
    }

    private DLL.ListNode allocate(Integer party) {
        DLL dll = waitingList.get(party);
        return dll.getFirst();
    }
}
