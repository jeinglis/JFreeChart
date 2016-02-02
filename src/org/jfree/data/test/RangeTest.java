package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	private Range exampleRange;
	private Range range1;
	private Range range2;
	private double value;

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1,1);
		range1 = null;
		range2 = null;
		value = 0;
	}

	@Test
	public void CentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0",0,exampleRange.getCentralValue(), .000000001d);
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * The following are tests designed by our team for assignment 2
	 */
	
	// TODO evaluate whether instantiation is permitted in tests or if must be done in setup
	
	@Test
	public void combineTest()	{
		// Case # 1
		range1 = null;
		range2 = null;
		assertEquals("The combined value of null and null should be null", null, Range.combine(range1, range2));
		
		// Case # 2
		range1 = null;
		range2 = new Range(10, 20);
		assertEquals("The combined value of null and (10, 20) should be (10, 20)", new Range(10, 20), Range.combine(range1, range2));
		
		// Case # 3
		range1 = new Range(10, 20);
		range2 = new Range(0, 9);
		assertEquals("The combined value of (10, 20) and (0, 9) should be (0, 20)", new Range(0, 20), Range.combine(range1, range2));
	}
	
	@Test
	public void constrainTest()	{
		// Case # 1
		range1 = new Range(0, 10);
		value = 5;
		assertEquals("The constraint of (0, 10) and 5 should be 5", 5, range1.constrain(value), 0);
		
		
		// Case # 2
		range1 = new Range(0, 10);
		value = 100;
		assertEquals("The constraint of (0, 10) and 100 should be 10", 10, range1.constrain(value), 0);
		
		
		// Case # 3  TODO - figure out why this fails
		range1 = new Range(0, 10);
		value = -99;
		assertEquals("The constraint of (0, 10) and -99 should be 0", 0, range1.constrain(value), 0);
		
		
		// Case # 4
		
		
		// Case # 5
		
		
		// Case # 6
		
		
		// Case # 7
		
		
		// Case # 8
		
		
		// Case # 9
	}
	
	@Test
	public void containsTest()	{
		
	}
	
	@Test
	public void equalsTest()	{
		
	}
	
	@Test
	public void expandTest()	{
		
	}
	
	@Test
	public void expandToIncludeTest()	{
		
	}
	
	@Test
	public void getCentralValueTest()	{
		
	}
	
	@Test
	public void getLengthTest()	{
		
	}
	
	@Test
	public void getLowerBoundTest()	{
		
	}
	
	@Test
	public void getUpperBoundTest()	{
		
	}
	
	@Test
	public void hashCodeTest()	{
		
	}
	
	@Test
	public void intersectsTest()	{
		
	}
	
	@Test
	public void shiftTest()	{
		
	}
	
	@Test
	public void shiftAllowZeroCrossingTest()	{
		
	}
	
	@Test
	public void toStringTest()	{
		
	}
}
