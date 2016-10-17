package dynamicProxy.manyLevelProxy;

public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
