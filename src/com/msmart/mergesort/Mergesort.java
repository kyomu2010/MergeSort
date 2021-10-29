package com.msmart.mergesort;

import java.util.Arrays;

public class Mergesort {

	private int[] nums;
	private int[] tempArray;

	public Mergesort(int[] nums) {
		this.nums = nums;
		this.tempArray = new int[nums.length];
	}

	public void mergeSort(int low, int high) {

		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;

		// partition arrays
		mergeSort(low, middle);
		mergeSort(middle + 1, high);

		// merge arrays
		merge(low, middle, high);
	}

	public void showResult() {
		Arrays.stream(nums).forEach(System.out::println);
	}

	private void merge(int low, int middle, int high) {

		// copy nums[i] -> tempArray[i]
		tempArray = Arrays.stream(nums).toArray();

		int i = low;
		int j = middle + 1;
		int k = low;

		// copy the smallest values from either the left or the right side back
		// to the original array
		while ((i <= middle) && (j <= high)) {
			if (tempArray[i] <= tempArray[j]) {
				nums[k] = tempArray[i];
				i++;
			} else {
				nums[k] = tempArray[j];
				j++;
			}
			k++;
		}

		// copy the rest of the left side of the array into the target array
		while (i <= middle) {
			nums[k] = tempArray[i];
			k++;
			i++;
		}

		// copy the rest of the right side of the array into the target array
		while (j <= high) {
			nums[k] = tempArray[j];
			k++;
			j++;
		}
	}

	public boolean isSorted() {
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				return false;
			}
		}
		return true;
	}
}
