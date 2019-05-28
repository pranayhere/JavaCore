package com.pranay.GeeksForGeeks;

import java.io.*;
import java.util.*;
public class MaximumSqrt
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 
        int i,N,A,B,count,lo,hi,max,sqrt=(int)Math.sqrt(1000000000);
        long square;
 
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        map.put(1,0);
 
        for(i=6000;i<=sqrt;i++)
        {
            if(!map.containsKey(i))
            {
                arr.add(i);
                map.put(i, 0);
                square=i;
                square*=square;
                count=1;
 
                while(square<=7000)
                {
                    map.put((int)square,count++);
                    arr.add((int)square);
                    square*=square;
                }
            }
        }
 
        String str = "pranay";
        str.contains("a");
        Collections.sort(arr);
        int a[]=new int[arr.size()];
 
        for(i=0;i<arr.size();i++)
            a[i]=arr.get(i);
 
        int T=Integer.parseInt(br.readLine().trim());
        StringBuilder sb=new StringBuilder();
 
        while(T-->0)
        {
            max=0;
 
            String s[]=br.readLine().trim().split(" ");
            A=Integer.parseInt(s[0]);
            B=Integer.parseInt(s[1]);
 
            lo=(int)Math.sqrt(A);
            hi=(int)Math.sqrt(B);
 
            if(lo*lo<A)
                lo++;
 
            lo*=lo;
            hi*=hi;
 
            lo=Arrays.binarySearch(a,lo);
            hi=Arrays.binarySearch(a,hi);
 
            for(i=lo;i<=hi;i++)
                max=Math.max(max,map.get(a[i]));
 
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}