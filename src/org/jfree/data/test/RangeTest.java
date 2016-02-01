package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	private Range exampleRange;

	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(-1,1);
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
	
	@Test
	public void combineTest()	{
		
	}
	
	@Test
	public void constrainTest()	{
		
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
