package testAll.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import testAll.taget.Numbers;

public class TestNumber {
	Numbers num;
	
	@Before
	public void setUp()
	{
		num = new Numbers();
	}
	
	@Test
	public void testAdd()
	{
		int vas = num.add(1, 1);
		System.out.println(vas);
		Assert.assertEquals("ds",vas,10);
	}
	@Test
	public void testAdd2()
	{
		int vas = num.add(1, 1);
		System.out.println(vas);
		Assert.assertEquals("ds",vas,10);
	}
	
}
