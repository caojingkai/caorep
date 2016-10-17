package dynamicProxy;


/**
 * 二、静态代理 
 * 由程序员创建或工具生成代理类的源码，再编译代理类。
 * 所谓静态也就是在程序运行前就已经存在代理类的字节码文件，代理类和委托类的关系在运行前就确定了。 
 * 三、动态代理 动态代理类的源码是在程序运行期间由JVM根据反射等机制动态的生成，所以不存在代理类的字节码文件。
 * 代理类和委托类的关系是在程序运行时确定。 newProxyInstance(新的代理实例)，创建时需要类加载器，委托类继承的接口，调用处理器生成动态代理类实例
 * 各种类的各种方法
 */
/*
 *  动态代理三步骤
 *   
 *  （1）新建调用类，链接委托类的类，该类中定义调用委托类的一下前后操作
 *  （2）新建代理类
 *  （3）使用代理对象调用方法
 */

/**
 * java.lang.ClassLoader
 * 这是类装载器类，负责将类的字节码装载到 Java 虚拟机（JVM）中并为其定义类对象，然后该类才能被使用。Proxy 静态方法生成动态代理类同样需要通过类装载器来进行装载才能使用，它与普通类的唯一区别就是其字节码是由 JVM 在运行时动态生成的而非预存在于任何一个 .class 文件中。 
 * 每次生成动态代理类对象时都需要指定一个类装载器对象 
 *
 */

public class FirstTouch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

}
