package dynamicProxy.manyLevelProxyLikeMybatis;

import java.util.Properties;

public class ExampleInterceptor2 implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("ExampleInterceptor-ber");
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub

	}

}
