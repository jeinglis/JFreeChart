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
	private Values2D values;
	
	@Before
	public void setup() throws Exception	{
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}
	
	@After
	public void teardown()	{
		mockingContext = null;
	}
	
	@Test(expected=InvalidParameterException.class)
	public void getCumulativePercentages_1() {
		DataUtilities.getCumulativePercentages(null);
	}
	
	@Test
	public void getCumulativePercentages_2() {
		mockingContext.checking(new Expectations() {
			{ 
				one(values).getColumnCount();
				will(returnValue(2));
				one(values).getRowCount();
				will(returnValue(3));
				
				one(values).getValue(0, 0);
				will(returnValue(0));
				one(values).getValue(0, 1);
				will(returnValue(5));
				
				one(values).getValue(1, 0);
				will(returnValue(1));
				one(values).getValue(1, 1);
				will(returnValue(9));
				
				one(values).getValue(2, 0);
				will(returnValue(2));
				one(values).getValue(2, 1);
				will(returnValue(2));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		
		KeyedValues data;
		DataUtilities.getCumulativePercentages(data);
	}
	
	@Test
	public void getCumulativePercentages_3() {
		KeyedValues data;
		DataUtilities.getCumulativePercentages(data);
	}

}
