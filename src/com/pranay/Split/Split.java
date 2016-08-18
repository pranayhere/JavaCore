package com.pranay.Split;

import java.util.ArrayList;
import java.util.List;

public class Split {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inputString = ",Here is some text, which is, not making, any, sense,";
		//String[] output = split(inputString, ',');
		String[] output = splitMine(inputString, ',');
		for (int i = 0; i < output.length; i++) {
			System.out.println("--"+output[i]);
		}
	}

	public final static String[] splitMine(String str, char separatorChar) {
		if (str == null) {
			return null;
		}
		str.split(str);
		int len = str.length();
		if (len == 0) {
			return null;
		}
		List<String> list = new ArrayList<String>();
		int temp =0;
		int fromIndex = 0;
		while (temp>=0){
			temp = str.indexOf(separatorChar,fromIndex);
			if(temp<0){
				list.add(str.substring(fromIndex,len));
				break;
			}else{
				list.add(str.substring(fromIndex,temp));
			}
			fromIndex = temp+1;
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		return arr;
	}
}
