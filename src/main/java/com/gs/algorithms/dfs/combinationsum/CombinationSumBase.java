package com.gs.algorithms.dfs.combinationsum;

import java.util.List;

public abstract class CombinationSumBase {

	public abstract int[][] combinations(int[] nums, int target);
	
	protected boolean isNullOrEmpty(int[] nums) {
		return nums == null || nums.length == 0;
	}
	
	protected int[][] convertAndSend(List<List<Integer>> combinationList) {
		int[][] result = new int[combinationList.size()][];
		int index = 0;
		while(index < combinationList.size()) {
			result[index] =  convertListToArray(combinationList.get(index));
			index++;
		}		
		return result;
	}

	private int[] convertListToArray(List<Integer> list) {
		int[] row = new int[list.size()];
		int index = 0;
		while(index < list.size()) {
			row[index] = list.get(index++);
		}
		return row;
	}
	
}
