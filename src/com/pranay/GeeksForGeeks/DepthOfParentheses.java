package com.pranay.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

class Foo {
    public int num;
    
    public Foo(int num) {
        this.num = num;
    }
}

public class DepthOfParentheses {

	public static void main(String[] args) {
		Integer a1 = 1;
		Foo a = new Foo(1);
        Foo b = new Foo(1);
        
        System.out.println(a);
        System.out.println(b);
        
        System.out.println(a.num);
        System.out.println(b.num);
        
        modify(a, b);
        
        System.out.println(a.num);
        System.out.println(b.num);
        
	}

	private static void modify(Integer a) {
		a = 20;	
	}
	
	public static void modify(Foo a1, Foo b1) {
		System.out.println(a1);
        System.out.println(b1);
        
		a1.num++;
//        b1 = new Foo(1);
        b1.num++;
    }

	private static int[] maxDepthAfterSplit(String seq) {
		
		int n = seq.length(), res[] = new int[n];
		
		for (int i = 0; i < n; i++) {
			System.out.println("i : " + (1 & 3));
		}
		return null;
	}

}
