package org.jfree.data.test.cases.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeGetLengthTest {
	private Range range;
	
	@Test
	public void getLength_1() {
		range = new Range(5, 5);
		assertEquals("The length of (5, 5) should be 0", 0, range.getLength(), 0);
	}
	
	@Test
	public void getLength_2() {
		range = new Range(0, 10);
		assertEquals("The length of (0, 10) should be 10", 10, range.getLength(), 0);
	}
}
