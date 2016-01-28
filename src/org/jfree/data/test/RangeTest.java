package org.jfree.data.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

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


}
