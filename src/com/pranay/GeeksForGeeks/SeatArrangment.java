package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class SeatArrangment {
	int a = 100;
	public static void main(String[] args) throws Exception {
			int a = 200;
			SeatArrangment s = new SeatArrangment();
			System.out.println(a);
		
		
		
		
//		String S = " ";
//		int N = 2;
//		int count = familyOfFour(N, S);
//		System.out.println(count);
	}

	private static int familyOfFour(int N, String S) {
		if (S.equals(" ")) {
			return 2;
		}
		String[][] cols = {{"A", "B", "C"}, {"D", "E", "F", "G"}, {"H", "J", "K"}};
		String[] reserved = S.split(" ");
		Arrays.sort(reserved);
		int prevCount = 0;
		int reservedIdx = 0;
		int totalFamilies = 0;
		for (int i =1; i<=N; i++) {
			int rowFamilies = 0;
			int totalmember = 0;
			for (int j = 0; j<3; j++) {
				int memberCount = 0;
				
				for (int k=0; k<cols[j].length; k++) {
//					System.out.println(i+1 + cols[j][k]);
					String currentSeat = i + cols[j][k];
					if (currentSeat.equals(reserved[reservedIdx])) {
//						System.out.println(currentSeat + "is reserved");
						
						if (memberCount < 2) {
							memberCount = 0;
						} else if (memberCount >= 2) {
							memberCount = 2;
							break;
						} 
						if (reservedIdx < reserved.length-1) reservedIdx++;
					} else {
						memberCount++;
//						System.out.println("memberCount : " + memberCount);						
					}

				}
				
				if (cols[j].length == 3 && memberCount == 3) {
					memberCount = 2;
				}
				if (prevCount == 2 && memberCount == 2) {
					rowFamilies++;
					prevCount = 0;
				}
				else if (memberCount == 4) {
					rowFamilies++;
					prevCount = 0;
				}
				else
					prevCount = memberCount;
//				System.out.println("member in "+i+""+j+" are : " + memberCount);
//				System.out.println("RowFam : " + rowFamilies + " " + " prevCount: " +prevCount);
				totalmember += memberCount;
			}
			prevCount = 0;
//			System.out.println("Total member in row " + i + " = " +totalmember);
//			System.out.println("Row Families " +rowFamilies);
			totalFamilies += rowFamilies;
			rowFamilies = 0;
		}
//		System.out.println(" totalFamilies : " + totalFamilies);
		return totalFamilies;
	}
}
