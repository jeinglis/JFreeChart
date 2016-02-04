package org.jfree.data.test.cases;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandTest {
	
	private Range exampleRange,expectedRange;
	private double lowerMargin,upperMargin;
	
	
	@Before
	public void setUp() throws Exception {
		exampleRange = new Range(0,10);
	}


	@Test(expected = InvalidParameterException.class)
	public void ExpandNullRange() {
		Range.expand(exampleRange,lowerMargin,upperMargin);
	}
	
	@Test
	public void ValidRangeWithPositiveMargins() {
		lowerMargin = 0.5;
		upperMargin = 0.5;
		expectedRange = new Range(-5,15);
		
		assertEquals("Range should be expanded to (-5,15)",expectedRange,Range.expand(exampleRange,lowerMargin,upperMargin));
	}
	
	@Test
	public void ValidRangeWithNegativeMargins() {
		lowerMargin = -0.5;
		upperMargin = -0.20;
		expectedRange = new Range(5,8);
		
		assertEquals("Range should be expanded to (5,8)",expectedRange,Range.expand(exampleRange,lowerMargin,upperMargin));
	}
	
	
	@Test
	public void ValidRangeWithZeroMargins() {
		lowerMargin = 0;
		upperMargin = 0;
		expectedRange = new Range(0,10);
		
		assertEquals("Range should be expanded to (5,8)",expectedRange,Range.expand(exampleRange,lowerMargin,upperMargin));
	}

}
