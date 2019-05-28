package com.pranay.GeeksForGeeks;

public class ArrayRotate {
	void leftRotate(int arr[], int d, int n) {
		int i, j, k, temp;
		int g_c_d = gcd(d, n);
		System.out.println("GCD : " + g_c_d);
		for (i = 0; i < g_c_d; i++) {
			System.out.println("i : "+i);
			temp = arr[i];
			System.out.println("temp : " + temp);
			j = i;
			while (true) {
				k = j + d;
				if (k >= n)
					k = k - n;
				if (k == i)
					break;
				System.out.println("j : " +j);
				System.out.println("k : " +k);
				System.out.println("Swapping : "+arr[j] +" : "+ arr[k]);
				arr[j] = arr[k];
				j = k;
				for (int l : arr) {
					System.out.print(l + " ");
				}
				System.out.println();
			}
			arr[j] = temp;
		}
	}

	void printArray(int arr[], int size) {
		int i;
		for (i = 0; i < size; i++)
			System.out.print(arr[i] + " ");
	}

	int gcd(int a, int b) {
		System.out.println("a: " +a+ " b: "+b);
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	// Driver program to test above functions
	public static void main(String[] args) {
		ArrayRotate rotate = new ArrayRotate();
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		rotate.leftRotate(arr, 8, 15);
		rotate.printArray(arr, 15);
	}
}