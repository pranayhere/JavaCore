package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class DefangIPaddr {

	public static String defangIPaddr(String address) {
        String[] arr = address.split("\\.");
        System.out.println(Arrays.toString(arr));
        String ans = "";
        for(int i = 0; i<arr.length-1; i++) {
            ans += arr[i] + "[.]";
        }
        return ans + arr[arr.length-1];
    }
	
	public static void main(String[] args) {
		String address = "1.1.1.1";
		System.out.println(defangIPaddr(address));
	}

}
