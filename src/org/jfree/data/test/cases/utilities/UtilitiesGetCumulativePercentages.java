package org.jfree.data.test.cases.utilities;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilitiesGetCumulativePercentages {

	private Mockery mockingContext;
	private KeyedValues data;
	
	@Before
	public void setup() throws Exception	{
		mockingContext = new Mockery();
		data = mockingContext.mock(KeyedValues.class);
	}
	
	@After
	public void teardown()	{
		mockingContext = null;
	}
	
	/**
	 * Test DataUtilities.GetCumulativePercentages method with invalid data
	 */
	@Test(expected=InvalidParameterException.class)
	public void getCumulativePercentages_1() {
		DataUtilities.getCumulativePercentages(null);
	}
	
	/**
	 * Test DataUtilities.GetCumulativePercentages method with valid data
	 */
	@Test
	public void getCumulativePercentages_2() {
		// We use mocking here because we can't instantiate interfaces
		mockingContext.checking(new Expectations() {
			{ 
				allowing(data).getItemCount();
				will(returnValue(3));
				
				allowing(data).getKey(5);
				will(returnValue(0));
				allowing(data).getKey(9);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
				
				allowing(data).getValue(0);
				will(returnValue(5));
				allowing(data).getValue(1);
				will(returnValue(9));
				allowing(data).getValue(2);
				will(returnValue(2));
			}
			});

		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		
		assertEquals(0.3125, result.getValue(0).doubleValue(), .000000001d);
		assertEquals(0.875, result.getValue(1).doubleValue(), .000000001d);
		assertEquals(1.0, result.getValue(2).doubleValue(), .000000001d);
	}
	
	/**
	 * Test DataUtilities.GetCumulativePercentages method with valid data
	 */
	@Test
	public void getCumulativePercentages_3() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(data).getItemCount();
				will(returnValue(3));
				
				allowing(data).getKey(5);
				will(returnValue(0));
				allowing(data).getKey(9);
				will(returnValue(1));
				allowing(data).getKey(2);
				will(returnValue(2));
				
				allowing(data).getValue(0);
				will(returnValue(0));
				allowing(data).getValue(1);
				will(returnValue(0));
				allowing(data).getValue(2);
				will(returnValue(0));
			}
			});

		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		
		assertEquals(Double.NaN, result.getValue(0).doubleValue(), .000000001d);
		assertEquals(Double.NaN, result.getValue(1).doubleValue(), .000000001d);
		assertEquals(Double.NaN, result.getValue(2).doubleValue(), .000000001d);
	}
	
	/**
	 * Test DataUtilities.GetCumulativePercentages method with empty data set
	 */
	@Test(expected=InvalidParameterException.class)
	public void getCumulativePercentages_4() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(data).getItemCount();
				will(returnValue(0));
			}
			});

		KeyedValues result = DataUtilities.getCumulativePercentages(data);
	}
}
