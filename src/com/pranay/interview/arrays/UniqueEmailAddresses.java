package com.pranay.interview.arrays;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
	public static void main(String[] args) {
		String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
		int count = numUniqueEmails(emails);
		System.out.println(count);
	}

	private static int numUniqueEmails(String[] emails) {
		Set<String> hs = new HashSet<>();
		for (String email: emails) {
			String[] removeDomain = email.split("@");
			String[] removePlus = removeDomain[0].split("\\+");
			String removeDot = removePlus[0].replaceAll("\\.", "");
			String finalEmail = removeDot + "@" + removeDomain[1];
			if (hs.contains(finalEmail))
				continue;
			hs.add(finalEmail);
		}
		return hs.size();
	}
}
