package com.msmart.mergesort;

import java.util.Random;

public class App {

	public static void main(String[] args) {
		Random random = new Random();

		int[] nums = new int[30];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = random.nextInt(1000) - 500;
		}
		
		Mergesort mergesort = new Mergesort(nums);
		mergesort.mergeSort(0, nums.length - 1);
		mergesort.showResult();
	}

}
