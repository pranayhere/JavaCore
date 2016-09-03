package com.pranay.invoice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.pranay.ExecutorServiceDemo.ExecutorServiceDemo.MyRunnable;

public class Invoice {
	private static final int MYTHREADS = 30;

	public static void main(String[] args) throws IOException {
		ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
		FileInputStream fin = new FileInputStream("/Users/apple/records1.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fin));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/Users/apple/outputfile.txt"));

		String str[] = new String[74261];
		for(int i=0; i<100; i++) {
			str[i] = br.readLine();
		}

//		long startTime = System.nanoTime();
//		for(int i=0; i<100; i++) {
//			String url = "http://219.90.103.59:16000/ws_05U_invoice_detail?inv_no="+str[i];			
//			URL siteURL = new URL(url);
//			BufferedReader in = new BufferedReader(new InputStreamReader(siteURL.openStream()));
//
//			String inputLine;
//			while ((inputLine = in.readLine()) != null) {
//				System.out.println(inputLine);
//				if(!inputLine.contains("Invoice No. Not Found")) {
//					System.out.println(url);
//				}
//			}
//			in.close();	
//		}
//		long endTime = System.nanoTime();
//		long duration = (endTime - startTime);
//		System.out.println("Total time : "+duration);
		
		
		for (int i = 0; i < 50000; i++) { 
			String url = "http://219.90.103.59:16000/ws_05U_invoice_detail?inv_no="+str[i];
			System.out.println(url);
			Runnable worker = new MyRunnable(url,url, writer);
			executor.execute(worker);
		}
		writer.close();
		executor.shutdown();
		while (!executor.isTerminated()) {
 
		}
		System.out.println("\nFinished all threads");		
	}
	
	public static class MyRunnable implements Runnable {
		private final String url;
		private BufferedWriter writer;
		
		MyRunnable(String url, String name, BufferedWriter writer) {
			this.url = url;
			this.writer = writer;
		}
		
		@Override
		public void run() {
			System.out.println("started : "+Thread.currentThread().getName());
			try {
				URL siteURL = new URL(url);
				BufferedReader in = new BufferedReader(new InputStreamReader(siteURL.openStream()));
	
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					System.out.println(inputLine);
					if(!inputLine.contains("Invoice No. Not Found")) {
						System.out.println(url);
					}
				}
				in.close();
			} catch (Exception e) {
				System.out.println("in exception");
			}
		}
	}
}