package org.jfree.data.test.cases.utilities;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValue;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values;
import org.jfree.data.Values2D;
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
	 * Test method with invalid data
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getCumulativePercentages_1() {
		DataUtilities.getCumulativePercentages(null);
	}
	
	/**
	 * Test method with valid data
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

		double comSum = 16;
		double expectedSum = 0;
		double actualSum = 0;
		
		for(int i = 0; i < data.getItemCount(); i++){
			assertEquals(i, result.getKey(i));
			
			expectedSum = (data.getValue(i).doubleValue()/comSum);
			actualSum = (result.getValue(i).doubleValue()/comSum);
			assertEquals(expectedSum, actualSum, .000000001d);
		}
	}
	
	/**
	 * Test method with invalid data
	 */
	@Test
	public void getCumulativePercentages_3() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(data).getItemCount();
				will(returnValue(3));
				
				allowing(data).getKey(0);
				will(returnValue(0));
				allowing(data).getKey(1);
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
		
		double comSum = 16;
//		double expectedSum = 0;
		double actualSum = 0;
		
		for(int i = 0; i < data.getItemCount(); i++){
			assertEquals(i, result.getKey(i));
//			expectedSum = (data.getValue(i).doubleValue()/comSum);
			actualSum = (result.getValue(i).doubleValue()/comSum);
			assertEquals(Double.NaN, actualSum, .000000001d);
		}
	}
	
	/**
	 * Test method with empty data set
	 */
	@Test
	public void getCumulativePercentages_4() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(data).getItemCount();
				will(returnValue(3));
				
//				allowing(data).getKey(0);
//				will(returnValue(0));
//				allowing(data).getKey(1);
//				will(returnValue(1));
//				allowing(data).getKey(2);
//				will(returnValue(2));
			}
			});

		KeyedValues result = DataUtilities.getCumulativePercentages(data);
		
		double comSum = 16;
		double expectedSum = 0;
		double actualSum = 0;
		
		for(int i = 0; i < data.getItemCount(); i++){
			assertEquals(i, result.getKey(i));
			expectedSum = (data.getValue(i).doubleValue()/comSum);
			actualSum = (result.getValue(i).doubleValue()/comSum);
			assertEquals(expectedSum, actualSum, .000000001d);
		}
	}

}
