package org.jfree.data.test.cases.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeEqualTest {
	private Range range;
	
	@Before
	public void setup() throws Exception	{
		range = new Range(0, 10);
	}
	
	@After
	public void teardown()	{
		range = null;
	}
	
	/**
	 * Test Range.equals with null input
	 */
	@Test
	public void equals_1() {
		assertEquals("(0, 10) == NULL should be false", false, range.equals(null));
	}
	
	/**
	 * Test Range.equals with an object that is not a Range
	 */
	@Test
	public void equals_2() {
		assertEquals("Range == Double should be false", false, range.equals(new Double(10)));
	}
	
	/**
	 * Test Range.equals with two equivalent Range instances
	 */
	@Test
	public void equals_3() {
		assertEquals("(0, 10) == (0, 10) should be true", true, range.equals(new Range(0, 10)));
	}
	
	/**
	 * Test Range.equals with two different Range instances
	 */
	@Test
	public void equals_4() {
		assertEquals("(0, 10) == (-5, 5) should be false", false, range.equals(new Range(-5, 5)));
	}
}
