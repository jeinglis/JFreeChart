package org.jfree.data.test.cases.utilities;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class UtilitiesCreateNumberArray2D {

	/**
	 * Test method with null data
	 */
	@Test(expected=IllegalArgumentException.class)
	public void createNumberArray2D_1() {
		double[][] data = null;
		DataUtilities.createNumberArray2D(data);
	}

	/**
	 * Test method with valid data
	 */
	@Test
	public void createNumberArray2D_2() {
		double[][] data = {{1, -2, 3.5, 4, 5.75}, {3, -5, 1.5, 6, 9.35}};
		Number[][] numberObjs = DataUtilities.createNumberArray2D(data);

		assertEquals(data.length,numberObjs.length);		
		for(int k = 0; k < data.length; k++)
			assertEquals(data[k].length, numberObjs[k].length);
			
		for(int i = 0; i < numberObjs.length; i++)
			for(int j = 0; j < numberObjs[i].length; j++)
				assertEquals(data[i][j], numberObjs[i][j].doubleValue(), .000000001d);
	}

}
