/**
 * 
 */
package problems.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PRATAP
 *
 */
public class SumOfPairwiseHammingDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new ArrayList<Integer>();
		int[] a = { 96, 96, 7, 81, 2, 13 };
		for (int i : a)
			arr.add(i);
		int sol = hammingDistance(arr);
		System.out.println(sol);
	}

	public static int hammingDistance(List<Integer> arr) {
		// TODO Auto-generated method stub
		Long ans = new Long(0);
		int countOnes = 0;
		long zeros = 0;
		long n = arr.size();
		for (int i = 0; i < 32; i++) {
			countOnes = 0;
			zeros = 0;
			for (int j = 0; j < n; j++) {
				if ((arr.get(j) & (1 << i)) > 0)
					countOnes++;
				if (arr.get(j) == 0)
					zeros++;
			}
			if (zeros == n)
				break;
			ans += countOnes * (n - countOnes) * 2;
		}
		ans %= 1000000007;
		return ans.intValue();
	}

}
