/**
 * 
 */
package problems.Math;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class RearrangeArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 2, 4, 1, 0 };
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : arr)
			list.add(i);
		arrange(list);

	}

	public static void arrange(ArrayList<Integer> arr) {
		int n = arr.size();
		for (int i = 0; i < n; i++) {
			arr.set(i, arr.get(i) + (arr.get(arr.get(i)) % n) * n);
		}

		for (int i = 0; i < n; i++) {
			arr.set(i, arr.get(i) / n);
		}

		for (int i : arr)
			System.out.print(i + " ");
	}

}
