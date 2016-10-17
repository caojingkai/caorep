package dynamicProxy.manyLevelProxyLikeMybatis;

import java.util.Properties;

public class ExampleInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("ExampleInterceptor-berf");
		Object ob= invocation.proceed();
		System.out.println("ExampleInterceptor-after");
		return ob;
	}

	@Override
	public Object plugin(Object target)
	{
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

}
