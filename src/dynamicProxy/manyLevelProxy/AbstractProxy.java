package dynamicProxy.manyLevelProxy;

import java.lang.reflect.Method;

public class AbstractProxy implements Proxy {

	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		Class<?> cls = null;
		Method method = null;
		Object[] params = proxyChain.getMethodParams();
		
		before(cls, method, params);
		result = proxyChain.doChain();
		after(cls, method, params);
		
		
		return result;
	}
	
	public void begin()
	{
		
	}
	
	public void before(Class<?>cls, Method method, Object[] params)
	{
		
	}
	
	public void after(Class<?>cls, Method method, Object[] params)
	{
		
	}
	
	public void end()
	{
		
	}
	

}
