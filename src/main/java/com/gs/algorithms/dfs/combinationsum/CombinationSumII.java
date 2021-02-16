package com.gs.algorithms.dfs.combinationsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
input [2 3 5 8] , target 8
output
	  [3 5]
	  [8]
*/
public class CombinationSumII extends CombinationSumBase{

	private List<List<Integer>> combinationList = new ArrayList<List<Integer>>();
	
	public int[][] combinations(int[] nums, int target) {
		if (isNullOrEmpty(nums)) {
			throw new IllegalArgumentException("Input is null or empty");
		}

		helper(nums, 0, target, new LinkedList<Integer>());
		return convertAndSend(combinationList);
	}

	private void helper(int[] nums, int index, int target, LinkedList<Integer> current) {
		if(target == 0) {
			combinationList.add(new ArrayList<Integer>(current));
			return;
		}
		
		if(target < 0 || index >= nums.length) {
			return;
		}
		
		int val = nums[index];
		current.addLast(val);
		helper(nums, index + 1, target - val, current);
		current.removeLast();
		helper(nums, index + 1, target, current);		
	}

	
	public static void main(String[] args) {
		int[][] result = new CombinationSumII().combinations(new int[] { 3, 2, 5, 8 }, 8);
		System.out.println(Arrays.deepToString(result));
	}
}
