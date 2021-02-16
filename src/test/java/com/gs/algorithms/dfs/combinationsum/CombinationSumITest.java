package com.gs.algorithms.dfs.combinationsum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Combination SumI Tests")
public class CombinationSumITest {

	private CombinationSumI combinationSumI;
	
	@BeforeEach
	public void initEach() {
		combinationSumI = new CombinationSumI();
	}
	
	@Test
	@DisplayName("Null input")
	public void testNullScnerio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
														() -> combinationSumI.combinations(null, 10),
														"Input is null or empty");
		assertTrue(thrown.getMessage().contains("null"));
	}
	
	@Test
	@DisplayName("Empty input")
	public void testEmptyScnerio() {
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
														() -> combinationSumI.combinations(new int[0], 10),
														"Input is null or empty");
		assertTrue(thrown.getMessage().contains("empty"));
	}
	
	@Test
	@DisplayName("Empty output")
	public void testEmptyOutputScnerio() {
		int[] nums = new int[]{2, 4, 8};
		int[][] actualValue = combinationSumI.combinations(nums, 7);
		assertArrayEquals(actualValue, new int[0][]);
	}
	
	@Test
	@DisplayName("Valid")
	public void testValidScnerio() {
		int[] nums = new int[]{2, 3, 5, 8};
		int[][] actualValue = combinationSumI.combinations(nums, 8);
		int[][] expectedValue = {
									{2, 2, 2, 2}, 
									{2, 3, 3}, 
									{3, 5},
									{8}
								};
		assertArrayEquals(actualValue, expectedValue);		
	}
}
