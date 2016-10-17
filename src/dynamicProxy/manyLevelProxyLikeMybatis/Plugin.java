package dynamicProxy.manyLevelProxyLikeMybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class Plugin implements InvocationHandler {

	  private Object target;
	  private Interceptor interceptor;
	  




	public Plugin(Object target, Interceptor interceptor) {
		super();
		this.target = target;
		this.interceptor = interceptor;
	}


	//生成代理对象
	public static Object wrap(Object target, Interceptor interceptor)
	{
		System.out.println("生成代理对象");
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces() , new Plugin(target,interceptor));
		 
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
	 // return interceptor.intercept(new Invocation(proxy,method,args));
		return interceptor.intercept(new Invocation(target,method,args));
	}

}
