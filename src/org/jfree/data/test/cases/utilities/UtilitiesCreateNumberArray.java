package org.jfree.data.test.cases.utilities;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class UtilitiesCreateNumberArray {
	
	/**
	 * Test method with null data
	 */
	@Test(expected=InvalidParameterException.class)
	public void createNumberArray_1() {
		double[] data = null;
		DataUtilities.createNumberArray(data);
	}
	
	/**
	 * Test method with valid data
	 */
	@Test
	public void createNumberArray_2() {
		double[] data = {1, -2, 3.5, 4, 5.75};
		Number[] numberObjs = DataUtilities.createNumberArray(data);

		assertEquals(data.length,numberObjs.length);
		for(int i = 0; i < data.length; i++)
			assertEquals(data[i], numberObjs[i].doubleValue(), .000000001d);
	}
}