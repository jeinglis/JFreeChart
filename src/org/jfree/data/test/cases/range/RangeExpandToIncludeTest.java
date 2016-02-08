package org.jfree.data.test.cases.range;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeExpandToIncludeTest {
	private Range range;
	private double value;
	
	@Before
	public void setUp() throws Exception {
		range = new Range(0, 10);
		value = 0;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void expandToInclude_1() {
		range = null;
		assertEquals("A null range expanded to 0 should be (0, 0)", new Range(0, 0), Range.expandToInclude(range, value));
	}

	@Test
	public void expandToInclude_2() {
		value = 5;
		assertEquals("(0, 10) expanded to 5 should be (0, 10)", new Range(0, 10), Range.expandToInclude(range, value));
	}

	@Test
	public void expandToInclude_3() {
		value = 15;
		assertEquals("(0, 10) expanded to 15 should be (0, 15)", new Range(0, 15), Range.expandToInclude(range, value));
	}

	@Test
	public void expandToInclude_4() {
		value = -5;
		assertEquals("(0, 10) expanded to -5 should be (-5, 10)", new Range(-5, 10), Range.expandToInclude(range, value));
	}
}
