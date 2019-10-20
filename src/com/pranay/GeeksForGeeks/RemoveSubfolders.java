package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

public class RemoveSubfolders {
	public static void main(String[] args) {
		String folder[] = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};
		List<String> ans = removeSubfolders(folder);
	}

	public static List<String> removeSubfolders(String[] folder) {
		Arrays.sort(folder);
		List<String> ans = new ArrayList<>();
		ans.add(folder[0]);
		for (int i = 1; i < folder.length; i++) {
			if (!(folder[i].startsWith(ans.get(ans.size() - 1)) && folder[i].charAt(ans.get(ans.size() - 1).length()) == '/'))
				ans.add(folder[i]);
		}
		return ans;
	}
}
