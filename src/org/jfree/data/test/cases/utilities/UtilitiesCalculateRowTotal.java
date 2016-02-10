package org.jfree.data.test.cases.utilities;

import static org.junit.Assert.assertEquals;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilitiesCalculateRowTotal {

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
	
	// From the javadoc, an InvalidParameterException should be thrown
	@Test(expected=InvalidParameterException.class)
	public void calculateRowTotal_1() {
		mockingContext.checking(new Expectations() {
			{ 
				one(values).getRowCount();
				will(returnValue(2));
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
	public void calculateRowTotal_2() {
		mockingContext.checking(new Expectations() {
			{ 
				one(values).getRowCount();
				will(returnValue(3));
				one(values).getColumnCount();
				will(returnValue(3));
				one(values).getValue(1, 0);
				will(returnValue(4));
				one(values).getValue(1, 1);
				will(returnValue(5));
				one(values).getValue(1, 2);
				will(returnValue(6));
			}
			});
		
		double result = DataUtilities.calculateRowTotal(values, 1);
		assertEquals(15.0, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotal_3() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(values).getRowCount();
				will(returnValue(3));
				allowing(values).getColumnCount();
				will(returnValue(3));
				
				// the javadoc for getValue() throws IndexOutOfBoundsException
				// when an invalid parameter is passed
				allowing(values).getValue(-1, 0);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(-1, 1);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(-1, 2);
				will(throwException(new IndexOutOfBoundsException()));
			}
			});
		
		double result = DataUtilities.calculateRowTotal(values, -1);
		assertEquals(0.0, result, .000000001d);
	}
	
	@Test
	public void calculateRowTotal_4() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(values).getRowCount();
				will(returnValue(3));
				allowing(values).getColumnCount();
				will(returnValue(3));
				
				// the javadoc for getValue() throws IndexOutOfBoundsException
				// when an invalid parameter is passed
				allowing(values).getValue(3, 0);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(3, 1);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(3, 2);
				will(throwException(new IndexOutOfBoundsException()));
			}
			});
		
		double result = DataUtilities.calculateRowTotal(values, 3);
		assertEquals(0.0, result, .000000001d);
	}
	
	

}
