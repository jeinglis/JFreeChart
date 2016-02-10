package org.jfree.data.test.cases.utilities;

import static org.junit.Assert.*;
import java.security.InvalidParameterException;
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
	
	/**
	 * Test for invalid input to method
	 */
	// From the javadoc, an InvalidParameterException should be thrown
	@Test//(expected=InvalidParameterException.class)
	public void calculateColumnTotal_1() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(values).getRowCount();
				will(returnValue(-1));
				allowing(values).getColumnCount();
				will(returnValue(-1));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, 0);
		assertEquals(0.0, result, .000000001d);
	}
	
	/**
	 * Test with valid data object and a column in the scope
	 */
	@Test
	public void calculateColumnTotal_2() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(values).getRowCount();
				will(returnValue(3));
				allowing(values).getColumnCount();
				will(returnValue(3));
				
				allowing(values).getValue(0, 1);
				will(returnValue(2));
				allowing(values).getValue(1, 1);
				will(returnValue(5));
				allowing(values).getValue(2, 1);
				will(returnValue(8));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, 1);
		assertEquals(15.0, result, .000000001d);
	}
	
	
	/**
	 * Test with valid data object and a negative column value
	 */
	@Test
	public void calculateColumnTotal_3() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(values).getRowCount();
				will(returnValue(3));
				allowing(values).getColumnCount();
				will(returnValue(3));
				
				// the javadoc for getValue() throws IndexOutOfBoundsException
				// when an invalid parameter is passed
				allowing(values).getValue(0, -1);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(1, -1);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(2, -1);
				will(throwException(new IndexOutOfBoundsException()));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, -1);
		assertEquals(0.0, result, .000000001d);
	}
	
	
	/**
	 * Test with valid data object and a positive column value above the data table scope
	 */
	@Test
	public void calculateColumnTotal_4() {
		mockingContext.checking(new Expectations() {
			{ 
				allowing(values).getRowCount();
				will(returnValue(3));
				allowing(values).getColumnCount();
				will(returnValue(3));
				
				// the javadoc for getValue() throws IndexOutOfBoundsException
				// when an invalid parameter is passed
				allowing(values).getValue(0, 3);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(1, 3);
				will(throwException(new IndexOutOfBoundsException()));
				allowing(values).getValue(2, 3);
				will(throwException(new IndexOutOfBoundsException()));
			}
			});
		
		double result = DataUtilities.calculateColumnTotal(values, 3);
		assertEquals(0.0, result, .000000001d);
	}

}
