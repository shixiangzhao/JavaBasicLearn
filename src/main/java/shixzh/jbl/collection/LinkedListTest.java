package shixzh.jbl.collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * This program demonstrates operations on linked list.
 * 
 * @author Cienet
 *
 */
public class LinkedListTest {

	public static void main(String[] args) {
		List<String> a = new LinkedList<>();
		a.add("shichao");
		a.add("jiao");
		a.add("hong");
		List<String> b = new LinkedList<>();
		b.add("songwei");
		b.add("zhaoda");
		b.add("cuihuan");
		b.add("wenjian");

		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		// Merge the words from b into a
		while (bIter.hasNext()) {
			if (aIter.hasNext()) {
				aIter.next();
			}
			aIter.add(bIter.next());
		}
		System.out.println("a = " + a);

		// Remove every second word from b
		bIter = b.iterator();
		while (bIter.hasNext()) {
			bIter.next();
			if (bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println("b = " + b);

		// Bulk operation: remove all words in b from a
		a.removeAll(b);
		System.out.println("a = " + a);

	}

}
