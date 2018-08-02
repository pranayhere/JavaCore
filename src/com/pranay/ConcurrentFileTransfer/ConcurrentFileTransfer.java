package com.pranay.ConcurrentFileTransfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentFileTransfer {
	final static File srcFolder = new File("/Users/apple/file1");
	final static File targetFolder = new File("/Users/apple/file2");

	static File[] listOfFiles = srcFolder.listFiles();
	static volatile int size;
	static List<File> list = new CopyOnWriteArrayList<>();
	static AtomicInteger n = new AtomicInteger(0);
	static AtomicBoolean done = new AtomicBoolean(false);
	final static long startTime = System.currentTimeMillis();
	static long endTime;
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("startTime=********************************************************************************"+startTime);
		for (File file : listOfFiles) {
			if(file.isFile()){
				System.err.println("File Name="+file.getName());
				list.add(file);
			}
		}
		size = list.size();
		System.out.println("List Size="+list.size());
		ExecutorService service = Executors.newFixedThreadPool(size);
		while(!done.get()){
			if(n.intValue()>=size)
			{
				break;
			}
			System.err.println("Running a thread to copy a file...");
			Future future = service.submit(new Task1(list,n,srcFolder,targetFolder,done,size));
		}
		
		service.shutdown();
		service.awaitTermination(10L, TimeUnit.MINUTES);
		endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		System.out.println("endTime=********************************************************************************="+totalTime);
	}

}
class Task1 implements Runnable {
	double srcSize,destSize;
	BufferedInputStream in = null;
	BufferedOutputStream out = null;
	Boolean fileAlreadyExists = false;

	List<File> list;
	final int size;
	AtomicInteger n;
	AtomicBoolean done;
	File srcFolder,targetFolder;
	public Task1(List<File> list, AtomicInteger n, File srcfolder, File targetfolder,AtomicBoolean done,final 
			int size) {
		this.list = list;
		this.size = size;
		
		this.n = n;
		this.srcFolder = srcfolder;
		this.targetFolder = targetfolder;
		this.done = done;
	}

	public void run() {
		System.err.println("Thread is running now...!");
		synchronized (this) {
			if(n.intValue()<size){
				n.incrementAndGet();
				System.err.println("n="+n.intValue());
			}
			if(n.intValue()>=size)
			{
				done.set(true);
				Thread.interrupted();
				return;
			}
		}
		System.out.println("********************************************"+list.get(n.intValue()));
		copyFiles(list.get(n.intValue()));

	}

	private double getFileSize(File file)
	{
		return file.length();
	}

	private void copyFiles(File file) {
		File destFile = new File(targetFolder.getAbsolutePath() + File.separator
				+ file.getName());
		File srcFile = new File(srcFolder.getAbsolutePath() + File.separator
				+ file.getName());
		srcSize = getFileSize(srcFile);
		destSize = getFileSize(destFile);
		try {
			if(file.isFile())
				showMessage("Copying " + file.getName());
			if(destFile.exists())
			{
				if(srcSize>destSize)
				{
					destFile.delete();
					showMessage("File copied incorrectly!\n");
				}
				fileAlreadyExists = true;
				throw new Exception("File Already Exists!");
			}
			in = new BufferedInputStream(new FileInputStream(file));
			out = new BufferedOutputStream(new FileOutputStream(destFile));
			int n;
			while ((n = in.read()) != -1) {
				//System.err.print("Data copied is="+n+" bytes!");
				out.write(n);
			}
			showMessage("Copied " + file.getName());
		} 
		catch (Exception e) {
			if(fileAlreadyExists)
				showMessage("Cannot copy file " + file.getAbsolutePath()+ " as file Already present in directory!");
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (Exception e) {
				}
			if (out != null){
				try {
					out.close();
				} catch (Exception e) {}
			}
		}
	}

	private void showMessage(String str)
	{
		System.out.println(str);
	}
}