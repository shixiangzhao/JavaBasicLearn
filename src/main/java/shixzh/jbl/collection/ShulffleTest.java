package shixzh.jbl.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShulffleTest {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < 49; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		System.out.println(numbers);
		List<Integer> wc = numbers.subList(0, 6);
		System.out.println(wc);
		Collections.sort(wc);
		System.out.println(wc);
	}

}
