/**
 * 
 */
package problems.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author PRATAP
 *
 */

class Interval {
	public int start;
	public int end;

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

}

public class MergeIntervals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(1, 2));
		list.add(new Interval(3, 5));
		list.add(new Interval(6, 7));
		list.add(new Interval(8, 10));
		list.add(new Interval(12, 16));
		List<Interval> ans = mergeIntervals(list, new Interval(4, 9));
		for (Interval i : ans)
			System.out.print("(" + i.start + ", " + i.end + "),");
		System.out.println();

	}

	public static List<Interval> mergeIntervals(List<Interval> list, Interval i) {
		list.add(i);
		Collections.sort(list, new DefComparator());
		List<Interval> ans = new ArrayList<Interval>();
		int end, start;
		ans.add(list.get(0));
		int p = 0;
		for (int j = 1; j < list.size(); j++) {
			if (ans.get(p).end >= list.get(j).start) {
				end = (ans.get(p).end > list.get(j).end) ? ans.get(p).end : list.get(j).end;
				start = ans.get(p).start;
				ans.remove(p);
				ans.add(new Interval(start, end));
			} else {
				ans.add(list.get(j));
				p++;
			}
		}
		return ans;
	}

}

class DefComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub
		return (o1.start < o2.start) ? -1 : 1;
	}

}
