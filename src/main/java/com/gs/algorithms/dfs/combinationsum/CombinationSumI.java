package com.gs.algorithms.dfs.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
input [2 3 5] , target 8
output
	  [2 2 2 2]
	  [2 3 3]
	  [3 5]
Note : element can be reused as much possible
*/
public class CombinationSumI extends CombinationSumBase {

	private List<List<Integer>> combinationList = new ArrayList<List<Integer>>();

	public int[][] combinations(int[] nums, int target) {

		if (isNullOrEmpty(nums)) {
			throw new IllegalArgumentException("Input is null or empty");
		}

		helper(nums, 0, target, new LinkedList<Integer>());
		return convertAndSend(combinationList);
	}

	private void helper(int[] nums, int index, int sum, LinkedList<Integer> current) {
		if (sum == 0) {
			combinationList.add(new ArrayList<Integer>(current));
			return;
		}

		if (sum < 0 || index >= nums.length) {
			return;
		}

		int num = nums[index];
		current.addLast(num);
		helper(nums, index, sum - num, current);
		current.removeLast();
		helper(nums, index + 1, sum, current);
	}

	public static void main(String[] args) {
		int[][] result = new CombinationSumI().combinations(new int[] { 3, 2, 5, 8 }, 8);
		System.out.println(Arrays.deepToString(result));
	}

}
