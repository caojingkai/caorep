package dynamicProxy;

import java.util.ArrayList;
import java.util.List;

import dynamicProxy.manyLevelProxy.LogProxy;
import dynamicProxy.manyLevelProxy.Proxy;
import dynamicProxy.manyLevelProxy.ProxyManager;
import dynamicProxy.manyLevelProxy.TimeProxy;
import dynamicProxy.manyLevelProxyLikeMybatis.EntrustIn;
import dynamicProxy.manyLevelProxyLikeMybatis.ExampleInterceptor;
import dynamicProxy.manyLevelProxyLikeMybatis.ExampleInterceptor2;
import dynamicProxy.manyLevelProxyLikeMybatis.InterceptorChain;

public class Client {

	public static void main(String[] args) 
	{
		//funcJDKProxy();
		//funcCGLiProxy();
		//多层代理
		//manyLevelProxy();
		manyLevelProxyLikeMybatis();
	}
	
	public static void funcJDKProxy()
	{
		JDKProxy proxy = new JDKProxy(new Entrust());
		EntrustInter enters = proxy.getProxy();
		enters.say();
	}
	
	public static void funcCGLiProxy()
	{
		 // TODO Auto-generated method stub
		 CGLiProxy proxy = new CGLiProxy();
		 Entrust ds = new Entrust();
		 Entrust entrust = proxy.getProxy(ds.getClass());
		  entrust.say();
	}
	
	public static void manyLevelProxy()
	{
		List<Proxy> proxyList = new ArrayList<Proxy>(); 
		proxyList.add(new LogProxy());
		proxyList.add(new TimeProxy());
		
		Entrust ds = new Entrust();
		String  friends[] = {"曹若森","haha"};
		Entrust entrust= ProxyManager.createProxy(ds.getClass(), proxyList);
		
		//entrust.sayFriends("小米老师", friends);
	}
	
	public static void manyLevelProxyLikeMybatis()
	{
		InterceptorChain interceptorChain = new InterceptorChain();
		interceptorChain.addInterceptor(new ExampleInterceptor());

		interceptorChain.addInterceptor(new ExampleInterceptor2());
		EntrustIn ds = new EntrustIn();
		EntrustInter entrustInter = (EntrustInter)interceptorChain.pluginAll(ds);
		
		
		System.out.println(entrustInter.say());
	}
}
