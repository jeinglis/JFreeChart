package org.jfree.data.test.cases;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilitiesCalculateColumnTotal {
	
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
	
	@Test(expected=NullPointerException.class)
	//@Test(expected=InvalidParameterException.class)
	public void calculateColumnTotal_1() {
		mockingContext.checking(new Expectations() {
			{ 
				one(values).getRowCount();
				will(returnValue(2));
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(0, 0);
				will(returnValue(7.5));
				one(values).getValue(1, 0);
				will(returnValue(2.5));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(null, 0);
		assertEquals(10.0, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotal_2() {
		mockingContext.checking(new Expectations() {
			{ 
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(0, 1);
				will(returnValue(2));
				one(values).getValue(1, 1);
				will(returnValue(5));
				one(values).getValue(2, 1);
				will(returnValue(8));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals(15.0, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotal_3() {
		mockingContext.checking(new Expectations() {
			{ 
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(0, 1);
				will(returnValue(2));
				one(values).getValue(1, 1);
				will(returnValue(5));
				one(values).getValue(2, 1);
				will(returnValue(8));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals(0.0, result, .000000001d);
	}
	
	@Test
	public void calculateColumnTotal_4() {
		mockingContext.checking(new Expectations() {
			{ 
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getValue(0, 1);
				will(returnValue(2));
				one(values).getValue(1, 1);
				will(returnValue(5));
				one(values).getValue(2, 1);
				will(returnValue(8));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, 3);
		assertEquals(0.0, result, .000000001d);
	}

}
