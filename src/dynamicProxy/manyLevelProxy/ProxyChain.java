package dynamicProxy.manyLevelProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.proxy.MethodProxy;

public class ProxyChain {
	
	private int proxyIndex = 0;
	
	private List<Proxy> proxyList = new ArrayList<Proxy>();
	
	private final MethodProxy methodProxy;
	
	private final Method tagetMethod;
	
	private final Object targetObject;
	
	private final Object[] methodParams;
	
	
	
	public ProxyChain(MethodProxy methodProxy, Object targetObject,
			Object[] methodParams,  List<Proxy> proxyList, Method tagetMethod) {
		super();
		this.methodProxy = methodProxy;
		this.targetObject = targetObject;
		this.methodParams = methodParams;
		this.proxyList = proxyList;
		this.tagetMethod = tagetMethod;
	}

	public Object doChain() throws Throwable
	{
		System.out.println("cdsd");
		Object methodResult;
		if (proxyIndex < proxyList.size())
		{
			System.out.println("cdsd2");

			methodResult = proxyList.get(proxyIndex++).doProxy(this);
		}
		else 
		{
			System.out.println("cdsd23");

			methodResult = methodProxy.invokeSuper(targetObject,methodParams);
		}
		
		return methodResult;
	}

	public List<Proxy> getProxyList() {
		return proxyList;
	}

	public MethodProxy getMethodProxy() {
		return methodProxy;
	}

	public Object getTargetObject() {
		return targetObject;
	}

	public Object[] getMethodParams() {
		return methodParams;
	}




	

}
