package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler{

	private Object target;
	
	public JDKProxy(Object obj)
	{
		this.target = obj;
	}
	
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		before();
		Object obj = arg1.invoke(target, arg2);
		after();
		return obj;
	}
	
	//代理对象
	public <T> T getProxy()
	{
		T obj = (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	    return obj;
	}
	
	public void before()
	{
		System.out.println("before");
	}
	public void after()
	{
		System.out.println("after");
	}

}
