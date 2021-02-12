/**
 * 
 */
package problems.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author PRATAP
 *
 */
public class Numbers_Of_Length_N_And_Value_Less_Than_K {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> A = new ArrayList<>();
		String[] input = br.readLine().split("\\s+");
		for (String s : input) {
			A.add(Integer.parseInt(s));
		}
		Collections.sort(A);
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int sol = Solution(A, B, C);
		System.out.println(sol);
	}

	public static int Solution(ArrayList<Integer> A, int B, int C) {
		// TODO Auto-generated method stub
		if (A.size() <= 0)
			return 0;
//		b = no of digits allowed
//		c = actual no
//		Case 1 : when B > n(C), where n(C) = no of digits in C
		int temp = C, count = 0;
		int ans = 0;
		while (temp > 0) {
			count++;
			temp /= 10;
		}
		if (B > count)
			return 0;
		else if (B < count) {
//			Case 2 : when B < n(C),
//					Case i : if A[0] = 0, then return (A.size() - 1) * Math.pow(A.size(), B)
//					Case ii : ifA[0] !=0, then return Math.pow(A.size(), B)
//			Check if B == 1, then 0 should also be counted
			if (A.get(0) != 0) {
				ans += Math.pow(A.size(), B);
			} else {
				ans += (A.size() - 1) * Math.pow(A.size(), B - 1);
			}
			if (B == 1 && A.get(0) == 0) {
				ans++;
			}
			return ans;
		} else {
//			Case 3 : when B == n(C)
			if (B == 1) {
				for (int i = 0; i < A.size(); i++) {
					if (A.get(i) < C)
						ans++;
				}
			} else {
				int[] arr = new int[B];
				for (int i = arr.length - 1; i >= 0; i--) {
					arr[i] = C % 10;
					C /= 10;
				}
				count = 0;
				for (int i = 0; i < A.size(); i++) {
					if (A.get(i) == 0)
						continue;
					if (A.get(i) > arr[0])
						break;
					count++;
				}
				ans += (count * Math.pow(A.size(), B - 1));
//			Need to discard the values greater than or equal to C
				int flag = 0;
				int j = 0;
//			Let's first check whether the starting digit of C is actually present in A
				for (int i = 0; i < A.size(); i++) {
					if (A.get(i) == arr[0]) {
						flag = 1;
						break;
					}
				}
				j++;
				while (flag == 1 && j <= B - 1) {
					flag = 0;
					int countx = 0;
					for (int i = 0; i < A.size(); i++) {
						if (A.get(i) > arr[j]) {
							countx++;
						}
						if (A.get(i) == arr[j])
							flag = 1;
					}
					ans -= countx * Math.pow(A.size(), B - j - 1);
					j++;
				}
				if (flag == 1)
					ans--;
			}
		}
		return ans;
	}

}
