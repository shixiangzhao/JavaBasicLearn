package shixzh.jbl.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * This program uses a set to print all unique words in System.in
 * 
 * @author Cienet
 *
 */
public class SetTest {

	public static void main(String[] args) {
		Set<String> words = new HashSet<>();
		long totalCount = 0;

		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				String word = in.next();
				long callTime = System.currentTimeMillis();
				words.add(word);
				callTime = System.currentTimeMillis() - callTime;
				totalCount += callTime;
			}
		}

		Iterator<String> it = words.iterator();
		for (int i = 0; i <= 20 && it.hasNext(); i++) {
			System.out.println(it.next());
		}
		System.out.println("...");
		System.out.println(words.size() + " distinct words. " + totalCount + " milliseconds.");
	}
}
