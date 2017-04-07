package shixzh.jbl.collection;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		SortedSet<Item> parts = new TreeSet<>();
		parts.add(new Item("hight", 456));
		parts.add(new Item("zear", 123));
		parts.add(new Item("weight", 789));
		System.out.println(parts);

		SortedSet<Item> sortByDecreption = new TreeSet<>(new Comparator<Item>() {
			@Override
			public int compare(Item a, Item b) {
				String descrA = a.getDescreption();
				String descrB = b.getDescreption();
				return descrA.compareTo(descrB);
			}

		});
		sortByDecreption.addAll(parts);
		System.out.println(sortByDecreption);
	}

}
