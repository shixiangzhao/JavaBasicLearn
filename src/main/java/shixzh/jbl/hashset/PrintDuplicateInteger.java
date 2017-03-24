package shixzh.jbl.hashset;

import java.util.Arrays;

//该算法主要针对已排序数组，打印两个数组的重复元素，未排序则复杂度较高
public class PrintDuplicateInteger {
	private static int[] array1 = { 2, 1, 9, 3, 7, 4, 1, 8 };
	private static int[] array2 = { 7, 10, 2, 1, 8, 32, 4 };

	public static void main(String[] args) {
		Arrays.sort(array1);
		printArray(array1);
		Arrays.sort(array2);
		printArray(array2);
		int i = 0;
		int j = 0;
		while (i < array1.length && j < array2.length) {
			System.out.println("i = " + i + " j = " + j);
			if (array1[i] == array2[j]) {
				System.out.println("dumpline key: " + i + " value: " + array1[i]);
				// 无法解决需求: 要求重复多次即输出多次，且array2包含自重复元素
				i++;
			}
			if (array1[i] < array2[j]) {
				i++;
			}
			if (i < array1.length && array1[i] > array2[j]) {
				j++;
			}
		}
	}

	private static void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}