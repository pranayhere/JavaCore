package com.pranay.GeeksForGeeks;

public class ProfileTest {

	public static void main(String[] args) {
		try {
			badMethod();
			System.out.println("A");
		} catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println("B");
		} 
		
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("C");
		} finally {
			System.out.println("D");
		}
		System.out.println("E");
	}

	private static void badMethod() {
		// TODO Auto-generated method stub
		throw new RuntimeException();
	}

}
