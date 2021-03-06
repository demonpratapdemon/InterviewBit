/**
 * 
 */
package problems.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author PRATAP
 *
 */
public class PalindromeInteger {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int palindrome = isPalindrome(number);
		System.out.println(palindrome);
	}

	private static int isPalindrome(int number) {
		// TODO Auto-generated method stub
		int reverse = 0;
		int temp = number;
		while (temp > 0) {
			reverse = reverse * 10 + (temp % 10);
			temp /= 10;
		}
		if (reverse == number)
			return 1;
		return 0;
	}

}
