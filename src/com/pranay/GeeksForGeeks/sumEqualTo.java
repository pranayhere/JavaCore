package com.pranay.GeeksForGeeks;

public class sumEqualTo {

	static int res;
	static int[] num = new int[6];
	static boolean[] flag = new boolean[6];
	public static void main(String[] args) {
		int[][] input = {
				{1,1,1,1,1},
				{1,2,3,4,5},
				{2,3,5,7,11},
	            {0,0,0,0,0},
	        };
	        
	        for (int[] in : input) {
	        	if (in[0] == 0 && in[1] == 0 && in[2] == 0 && in[3] == 0 && in[4] == 0)
	        		break;
	        	
	        	num[0] = in[0];
	        	num[1] = in[1];
	        	num[2] = in[2];
	        	num[3] = in[3];
	        	num[4] = in[4];
	        	
	        	res = 0;
	            for (int i : in) {
//	        		System.out.println("first stmt");
//	            	System.out.println(i);
	            	backTrack(i, 1);
	            }
	            if (res == 1)
	                System.out.println("Possible!");
	            else
	                System.out.println("Not Possible");
	        }

	}

	static void backTrack(int sum, int current)
	{
//		System.out.print(current);
//		System.out.println(sum);
		
	  int i = 1;
	  if(sum == 23 && current == 5)
	  {
		   res = 1;
	       return;
	  }
	  else{
	    for(i = 0 ; i < 5 ; i++){
	       if(!flag[i]){
	    	   flag[i] = true ;
	           backTrack( sum + num[i], current + 1) ;
	           backTrack( sum * num[i], current + 1) ;
	           backTrack( sum - num[i], current + 1) ;
	           flag[i] = false;
	       }
	    }
	 }

	}
}
