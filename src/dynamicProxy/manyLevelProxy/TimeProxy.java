package dynamicProxy.manyLevelProxy;

import java.io.PrintStream;
import java.lang.reflect.Method;

public class TimeProxy extends AbstractProxy {

	public static PrintStream print= System.out;
	@Override
	public void before(Class<?>cls, Method method, Object[] params)
	{
		print.println("ʱ�����before...");
	}
	
	@Override
	public void after(Class<?>cls, Method method, Object[] params)
	{
		print.println("ʱ�����after...");
	}

}
