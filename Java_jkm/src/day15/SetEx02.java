package day15;

import java.util.HashSet;
import java.util.Iterator;

public class SetEx02 {

	public static void main(String[] args) {
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(5);
		set.add(9);
		set.add(2);
		set.add(3);
		
		for(Integer tmp : set) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			Integer num = it.next();
			System.out.print(num + " ");
		}
	}
}
