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
public class ExcelColumnTitle {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number : ");
		Integer value = Integer.parseInt(br.readLine());
		String columnTitle = getColumnTitle(value);
		System.out.println(columnTitle);
	}

	private static String getColumnTitle(Integer value) {
		// TODO Auto-generated method stub
		/*
		 * Rem Char 
		 * ----------
		 * 0 	A 
		 * 1 	B 
		 * 2 	C 
		 * .
		 * .
		 * .
		 * 24	Y
		 * 25	Z
		 */
//		For this we need to subtract 1 from value before taking modulo and before dividing
		String result = "";
		while (value > 0) {
			result = (char) ((value - 1) % 26 + 65) + result;
			value = (value - 1) / 26;
		}
		return result;

	}

}
