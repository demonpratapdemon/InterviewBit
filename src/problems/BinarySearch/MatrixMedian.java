/**
 * 
 */
package problems.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author PRATAP
 *
 */
public class MatrixMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> adding = new ArrayList<>();
		adding.add(1);
		adding.add(3);
		adding.add(5);
		arr.add(0, adding);
		adding = new ArrayList<>();
		adding.add(2);
		adding.add(6);
		adding.add(9);
		arr.add(1, adding);
		adding = new ArrayList<>();
		adding.add(3);
		adding.add(6);
		adding.add(9);
		arr.add(2, adding);
		int median = findMedian(arr);
		System.out.println(median);
	}

	public static int findMedian(ArrayList<ArrayList<Integer>> arr) {
		// TODO Auto-generated method stub
		int n = arr.size();
		int m = arr.get(0).size();
		int min = arr.get(0).get(0);
		int max = arr.get(0).get(m - 1);
		for (int i = 1; i < n; i++) {
			min = Math.min(min, arr.get(i).get(0));
			max = Math.max(max, arr.get(i).get(m - 1));
		}
		int desired = (1 + n * m) / 2;
		while (min < max) {
			int mid = (min + max) / 2;
			int place = 0;
			for (int i = 0; i < n; i++) {
				int index = Collections.binarySearch(arr.get(i), mid);
				if (index < 0) {
					place += Math.abs(index + 1);
				} else {
					place += index;
					int k = index;
					while (k < m && arr.get(i).get(k) == mid) {
						place++;
						k++;
					}
					/*
					 * if (arr.get(i).get(index) == mid) place++;
					 */
				}
			}
			if (place < desired)
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}

}
