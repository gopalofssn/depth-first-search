package com.gs.algorithms.dfs.combinationsum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Combination SumI Tests")
public class CombinationSumIITest {

	private CombinationSumBase combinationSumII;
	
	@BeforeEach
	public void initEach() {
		combinationSumII = new CombinationSumII();
	}
	
	@Test
	@DisplayName("Null input")
	public void testNullScnerio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
														() -> combinationSumII.combinations(null, 10),
														"Input is null or empty");
		assertTrue(thrown.getMessage().contains("null"));
	}
	
	@Test
	@DisplayName("Empty input")
	public void testEmptyScnerio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
														() -> combinationSumII.combinations(new int[0], 10),
														"Input is null or empty");
		assertTrue(thrown.getMessage().contains("empty"));
	}
	
	@Test
	@DisplayName("Empty output")
	public void testEmptyOutputScnerio() {
		int[] nums = new int[]{2, 4, 8};
		int[][] actualValue = combinationSumII.combinations(nums, 7);
		assertArrayEquals(actualValue, new int[0][]);
	}
	
	@Test
	@DisplayName("Valid")
	public void testValidScnerio() {
		int[] nums = new int[]{2, 3, 5, 8};
		int[][] actualValue = combinationSumII.combinations(nums, 8);
		int[][] expectedValue = {
									{3, 5},
									{8}
								};
		assertArrayEquals(actualValue, expectedValue);		
	}
}
