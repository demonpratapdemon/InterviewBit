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
public class ExcelColumnNumber {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Column title : ");
		String columnTitle = br.readLine();
		int columnNumber = getColumnNumber(columnTitle);
		System.out.println(columnNumber);
	}

	private static int getColumnNumber(String columnTitle) {
		// TODO Auto-generated method stub
		int result = 0;
		int counter = 0;
		for (int i = columnTitle.length() - 1; i > -1; i--) {
			result += (int) (columnTitle.charAt(i) - 64) * Math.pow(26, counter++);
		}
		return result;
	}

}
