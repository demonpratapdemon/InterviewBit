/**
 * 
 */
package problems.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class SpiralMatrixII {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> list = generateMatrix(n);
		/*
		 * for (int i = 0; i < list.size(); i++) { for (int j = 0; j <
		 * list.get(i).size(); j++) { System.out.print(list.get(i).get(j) + " "); }
		 * System.out.println(); }
		 */
		System.out.println(list);
	}

	private static ArrayList<ArrayList<Integer>> generateMatrix(int n) {
		// TODO Auto-generated method stub
		int[][] arr = new int[n][n];
		int p = 1;
		int top = 0, bottom = n - 1, left = 0, right = n - 1;
		while (top <= bottom && left <= right) {
			for (int i = left; i <= right; i++) {
				arr[top][i] = p++;
			}
			top++;
			for (int i = top; i <= bottom; i++) {
				arr[i][right] = p++;
			}
			right--;
			for (int i = right; i >= left; i--) {
				arr[bottom][i] = p++;
			}
			bottom--;
			for (int i = bottom; i >= top; i--) {
				arr[i][left] = p++;
			}
			left++;
		}
		ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
		p = 0;
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> inside = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				inside.add(arr[i][j]);
			}
			ans.add(inside);
			p++;
		}
		return ans;
	}

}
