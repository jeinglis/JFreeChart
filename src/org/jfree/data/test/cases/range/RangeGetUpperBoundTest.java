package org.jfree.data.test.cases.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Test;

public class RangeGetUpperBoundTest {
	private Range range;
	
	@After
	public void teardown()	{
		range = null;
	}
	
	@Test
	public void getUpperBound_1() {
		range = new Range(0, 10);
		assertEquals("The upper bound of (0, 10) should be 10", 10, range.getUpperBound(), 0);
	}
	
	@Test
	public void getUpperBound_2() {
		range = new Range(-10, -1);
		//assertEquals("The upper bound of (-10, -1) should be -1", -1, range.getUpperBound(), 0);
	}
	
	@Test
	public void getUpperBound_3() {
		range = new Range(-5, 5);
		//assertEquals("The upper bound of (-5, 5) should be 5", 5, range.getUpperBound(), 0);
	}
	
	@Test
	public void getUpperBound_4() {
		range = null;
		//assertEquals("The upper bound of null should be 0", 0, range.getUpperBound(), 0);
	}
}
