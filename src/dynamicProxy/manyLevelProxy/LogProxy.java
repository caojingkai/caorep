package dynamicProxy.manyLevelProxy;

import java.io.PrintStream;
import java.lang.reflect.Method;

public class LogProxy extends AbstractProxy {

	public static PrintStream print= System.out;
	@Override
	public void before(Class<?>cls, Method method, Object[] params)
	{ 
		print.println("日志代理before..."+params.length);
		String [] friends =(String [])params[1];
		for (String srt :friends)
		{
			print.print(srt+"/");
		}
		
		
	}
	
	@Override
	public void after(Class<?>cls, Method method, Object[] params)
	{
		print.println("日志代理after...");
		
	}
}
