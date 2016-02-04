package org.jfree.data.test.cases;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeConstrainTest {
	private Range range;
	private double value;

	@Before
	public void setup() throws Exception	{
		range = new Range(0, 10);
	}
	
	@After
	public void teardown()	{
		range = null;
	}
	
	@Test
	public void constrain_1()	{
		value = 5;
		assertEquals("The constraint of 5 on (0, 10) should output 5", 5, range.constrain(value), 0);
	}

	@Test
	public void constrain_2()	{
		value = 100;
		assertEquals("The constraint of 100 on (0, 10) should output 10", 10, range.constrain(value), 0);
	}
	
	@Test
	public void constrain_3()	{
		value = -99;
		assertEquals("The constraint of -99 on (0, 10) should output 0", 0, range.constrain(value), 0);
	}
	
	@Test
	public void constrain_4()	{
		value = 10;
		assertEquals("The constraint of 10 on (0, 10) should output 10", 10, range.constrain(value), 0);
	}
	
	@Test
	public void constrain_5()	{
		value = 0;
		assertEquals("The constraint of 0 on (0, 10) should output 0", 0, range.constrain(value), 0);
	}
	
	@Test
	public void constrain_6()	{
			value = -0.01;
		assertEquals("The constraint of -0.01 on (0, 10) should output 0", 0, range.constrain(value), 0);
	}
	
	@Test
	public void constrain_7()	{
		value = 0.01;
		assertEquals("The constraint of 0.01 on (0, 10) should output 0.01", 0.01, range.constrain(value), 0);
	}
	
	@Test
	public void constrain_8()	{
		value = 9.99;
		assertEquals("The constraint of 9.99 on (0, 10) should output 9.99", 9.99, range.constrain(value), 0);
	}
	
	@Test
	public void constrain_9()	{
		value = 10.01;
		assertEquals("The constraint of 10.01 on (0, 10) should output 10", 10, range.constrain(value), 0);
	}
}
