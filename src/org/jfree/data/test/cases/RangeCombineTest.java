package org.jfree.data.test.cases;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeCombineTest {
	private Range range1;
	private Range range2;
	
	@Before
	public void setup() throws Exception	{
		// There is no setup required for this class
	}
	
	@After
	public void teardown()	{
		
	}
	
	@Test
	public void combine_1() {
		range1 = null;
		range2 = null;
		assertEquals("The combined value of null and null should be null", null, Range.combine(range1, range2));
	}
	
	@Test
	public void combine_2()	{
		range1 = null;
		range2 = new Range(10, 20);
		assertEquals("The combined value of null and (10, 20) should be (10, 20)", new Range(10, 20), Range.combine(range1, range2));
	}
	
	public void combine_3()	{
		range1 = new Range(10, 20);
		range2 = new Range(0, 9);
		assertEquals("The combined value of (10, 20) and (0, 9) should be (0, 20)", new Range(0, 20), Range.combine(range1, range2));
	}

}