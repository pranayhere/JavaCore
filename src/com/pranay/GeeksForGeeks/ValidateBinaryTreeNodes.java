package com.pranay.GeeksForGeeks;

import java.util.Arrays;

public class ValidateBinaryTreeNodes {
	public static void main(String[] args) {
		int n = 4;
		int[] leftChild = {1, -1, 3, -1};
		int[] rightChild = {2, -1, -1, -1};

		boolean isValid = validateBinaryTreeNodes(n, leftChild, rightChild);
		System.out.println(isValid);
	}

	private static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		int[] parent = new int[n];
		Arrays.fill(parent, -1);

		for (int i = 0; i < n; i++) {
			if (leftChild[i] != -1) {
				if (parent[leftChild[i]] != -1) {
					return false;
				}
				parent[leftChild[i]] = i;
			}

			if (rightChild[i] != -1) {
				if (parent[rightChild[i]] != -1) {
					return false;
				}
				parent[rightChild[i]] = i;
			}
		}

		int rootCount = 0;
		for (int x : parent) {
			if (x == -1) {
				rootCount++;
			}
		}

		return rootCount == 1;
	}
}
