package com.pranay.GeeksForGeeks;

public class Days {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "Sat";
		int k = 23;
		String day  = solution("Wed", 2);
		System.out.println(day);
	}

	public static String solution(String S, int K) {
	    
        int idx = 0;
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for(int i=0; i<days.length; i++) {
            if (days[i] == S) {
                idx = i;
                break;
            }
        }
        
        int pos = (idx + (K % 7)) % 7;
        
        
		return days[pos];
        
    }
}
