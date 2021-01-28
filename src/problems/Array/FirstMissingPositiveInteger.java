/**
 * 
 */
package problems.Array;

import java.util.ArrayList;

/**
 * @author PRATAP
 *
 */
public class FirstMissingPositiveInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1 };
		ArrayList<Integer> a = new ArrayList<>();
		for (int i : arr)
			a.add(i);
		int x = firstMissingPositive(a);
		System.out.println(x);
	}

	public static int firstMissingPositive(ArrayList<Integer> A) {
		int[] arr = new int[A.size()];
        for(int i = 0; i< A.size(); i++) {
            if ( A.get(i) > 0 && A.get(i) <= A.size()) {
               arr[A.get(i) - 1] = 1; 
            }
        }
        
        for(int i = 0 ;i < arr.length; i++) {
            if(arr[i] != 1) {
                return i+1;
            }
        }
        return arr.length + 1;
	}

}
