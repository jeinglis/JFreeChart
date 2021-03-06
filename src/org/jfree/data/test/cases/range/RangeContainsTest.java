package org.jfree.data.test.cases.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeContainsTest {
	
	private Range exampleRange;
	
	private double largerThanUpper = 10.01;
	private double upperBound = 10;
	
	private double median = 5;
	
	private double lowerBound = 0;
	private double lessThanLower = -0.01;
	
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(0,10);
	}

	/**
	 * Test Range.contains with a number within the range
	 */
	@Test
	public void RangeDoesNotContainsLargerThanUpperValue() {
		assertEquals("The range does not contain 10.01 and should return false",false,exampleRange.contains(largerThanUpper));
	}
	
	/**
	 * Test Range.contains with a number above the upper range limit
	 */
	@Test
	public void RangeContainsUpperBoundValue() {
		assertEquals("The range contains 10 and should return true",true,exampleRange.contains(upperBound));
	}
	
	/**
	 * Test Range.contains with a number below the lower range limit
	 */
	@Test
	public void RangeContainsMedianValue() {
		assertEquals("The range contains 5 and should return true",true,exampleRange.contains(median));
	}

	/**
	 * Test Range.contains with an upper bound
	 */
	@Test
	public void RangeContainsLowerBoundValue() {
		assertEquals("The range contains 0 and should return true",true,exampleRange.contains(lowerBound));
	}
	
	/**
	 * Test Range.contains with a lower bound
	 */
	@Test
	public void RangeDoesNotContainsLessThanLowerBoundValue() {
		assertEquals("The range does not contain -0.01 and should return false",false,exampleRange.contains(lessThanLower));
	}
	
	@After
	public void tearDown() throws Exception {
		exampleRange = null;
	}
	
}