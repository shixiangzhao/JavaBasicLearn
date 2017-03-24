package shixzh.jbl.hashset;

import java.util.HashSet;
import java.util.Set;

public class PrintDuplicateIntegerByHashSet {

	public static Set<Integer> findDuplicateInteger(int[] array1, int[] array2) {
		Set<Integer> duplicateSet = new HashSet<>();
		Set<Integer> tempSet = new HashSet<>();
		for (int i = 0; i < array1.length; i++) {
			// 去掉array1的重复元素
			tempSet.add(array1[i]);
		}
		System.out.println(tempSet.toString());
		for (int j = 0; j < array2.length; j++) {
			// 如果重复，则添加失败
			if (!tempSet.add(array2[j])) {
				duplicateSet.add(array2[j]);
			}
		}
		return duplicateSet;
	}

	public static void main(String[] args) {
		int[] array1 = { 2, 1, 9, 3, 7, 4, 1, 8 };
		int[] array2 = { 7, 10, 2, 1, 8, 32, 4 };

		Set<Integer> duplicateSet = findDuplicateInteger(array1, array2);
		System.out.println(duplicateSet.toString());

	}

	public static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}
}
