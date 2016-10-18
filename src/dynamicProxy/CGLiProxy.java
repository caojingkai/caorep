package dynamicProxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//ÒªÒýÈëasm-all-4.0.jar
public class CGLiProxy implements MethodInterceptor{

   
	 @SuppressWarnings("unchecked")
	public <T> T getProxy(Class<T> cls)
	 { 
		 return (T)Enhancer.create(cls, this);
	 }
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		// TODO Auto-generated met hod stub
		before();
		Object result = arg3.invokeSuper(arg0, arg2);
		after();
		return result;
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
