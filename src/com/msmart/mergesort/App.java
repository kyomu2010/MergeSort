package com.msmart.mergesort;

import java.util.Random;

public class App {

	public static Random random = new Random();

	public static void main(String[] args) {

		// get number of available processors
		int numOfThreads = Runtime.getRuntime().availableProcessors();

		int[] nums = { 4, 2, 6, 5, 44, 78, -4, 0, 1 };

		/*
		 * Mergesort mergesort = new Mergesort(nums); mergesort.parallelMergeSort(0,
		 * nums.length-1, numOfThreads); mergesort.showResult();
		 */

		System.out.println("Number of threads: " + numOfThreads);
		System.out.println("");

		int[] numbers = createRandomArray();
		Mergesort mergesort = new Mergesort(numbers);

		long startTime = System.currentTimeMillis();
		mergesort.parallelMergeSort(0, numbers.length - 1, numOfThreads);
		long endTime = System.currentTimeMillis();

		System.out.printf("Time taken for 1000 elements parallel: %d", endTime - startTime);

		startTime = System.currentTimeMillis();
		mergesort.mergeSort(0, numbers.length - 1);
		endTime = System.currentTimeMillis();
		
		System.out.println("");
		System.out.printf("Time taken for 1000 elements sequential: %d", endTime - startTime);

	}

	public static int[] createRandomArray() {
		int[] array = new int[1000];
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(1000);
		}
		return array;
	}

}
