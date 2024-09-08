package com.pranay.interview.design;

/**
 * Example -
 * Homepage - abc.com
 * Visit - def.com
 * Visit - ghi.com // lost from history
 * Back(50) - abc.com
 * Forward - 1 - def.com
 * Visit - jkl.com
 */

// ptr = currPage
// List<URL> = LinkedList<>()
 //   abc.com -> def.com -> jkl.com -> p.con -> q.com ->  r.com
 //                                              |
 //                                             ptr
 //           Back(2) = abc.com () 5 - 2 = 3
 //   abc.com, def.com, jkl.com, p.con, q.com
 //       |    x.com
  //     ptr
    //  abc.com, qqq.com
  //          fowd(50) = jkl.com

public class WebPageHistory {
    class ListNode {
        String url;
        ListNode next;
        ListNode prev;

        public ListNode() {}

        public ListNode(String url) {
            this.url = url;
        }
    }

    ListNode current;

    public WebPageHistory(String homePage) {
        current = new ListNode(homePage);
    }

    public void visitPage(String url) { // O(1)
        if (current.next != null) {
            current.next.prev = null;
        }

        ListNode page = new ListNode(url);
        current.next = page;
        page.prev = current;
        current = current.next;
    }

    public String goBack(int noOfClicks) { // O(noOFclick)
        while (noOfClicks > 0 && current.prev != null) {
            current = current.prev;
            noOfClicks--;
        }

        return current.url;
    }

    public String goForward(int noOfClicks) { // O(noOfCliejk)
        while (noOfClicks > 0 && current.next != null) {
            current = current.next;
            noOfClicks--;
        }

        return current.url;
    }

    public static void main(String[] args) {
        WebPageHistory wph = new WebPageHistory("abc.com");
        wph.visitPage("b.com");
        wph.visitPage("c.com");
        wph.visitPage("d.com");
        wph.visitPage("e.com");

        System.out.println(wph.goBack(10));
        System.out.println(wph.goForward(10));

        System.out.println(wph.goBack(2));
        wph.visitPage("f.com");

        System.out.println(wph.goBack(1));
        System.out.println(wph.goForward(1));
    }
}