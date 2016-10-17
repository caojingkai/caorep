package testAll.taget;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class NumbersTest {

	private static Numbers num = new Numbers();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		int sum = num.add(10, 10);
		Assert.assertEquals(10, sum);
	}

}
