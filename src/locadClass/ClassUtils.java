package locadClass;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static java.lang.System.out;
public class ClassUtils {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toUrl();
		 //getClassSet("org/apache/ibatis");
	}
	
	//获得加载器
	public static ClassLoader getClassLoader()
	{
		return Thread.currentThread().getContextClassLoader();
	}
	
	//加载链接指定的类
	public static Class<?> loadClass(String className, boolean isIntialized)
	{
		Class<?> cls = null;
		try {
			cls = Class.forName(className, false, getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return cls;
	}
	
	/**
	 * 在web 工程中结果如下：
	 *  classLoader.getResources(pathName);
	 * （1）pathName=""
	 * file:/G:/Users/crs/tomcat6.0/apache-tomcat-6.0.45/lib/
       file:/G:/Users/crs/tomcat6.0/apache-tomcat-6.0.45/wtpwebapps/chapter1/WEB-INF/classes/
       (2)pathName="com"
        file:/G:/Users/crs/tomcat6.0/apache-tomcat-6.0.45/wtpwebapps/chapter1/WEB-INF/classes/com/
		jar:file:/G:/Users/crs/tomcat6.0/apache-tomcat-6.0.45/wtpwebapps/chapter1/WEB-INF/lib/fastjson-1.1.41.jar!/com
		jar:file:/G:/Users/crs/tomcat6.0/apache-tomcat-6.0.45/wtpwebapps/chapter1/WEB-INF/lib/mysql-connector-java-5.1.30.jar!/com
     *
     *在java工程中
     *classLoader.getResources(pathName);
	 * pathName=""
     * file:/G:/Users/crs/lunaWorkspace/corejava1.0/bin/
	 */
	//加载工程下指定jar,或文件下的类
   public static void getClassSet(String pathName)
   {
	   ClassLoader classLoader= Thread.currentThread().getContextClassLoader();
	   Set<Class<?>> classSet = new HashSet<Class<?>>();
	   
	   try {
		Enumeration<URL> urls = classLoader.getResources(pathName);
        
		while(urls.hasMoreElements())
		{
			URL  url = urls.nextElement();
			if(url != null)
			{
				String protocal = url.getProtocol();
				out.println(""+url.getProtocol()+":"+url.getPath());
				if("file".equals(protocal))
				{
					addClass(classSet, url.getPath(),pathName);
				}
				else if ("jar".equals(protocal))
				{
					JarURLConnection jarURLConnection = (JarURLConnection)url.openConnection();
					JarFile jarFile = jarURLConnection.getJarFile();
					Enumeration<JarEntry> jarEntries =jarFile.entries();
					
					while(jarEntries.hasMoreElements())
					{
						JarEntry jarEntry = jarEntries.nextElement();
						String jarEntryName = jarEntry.getName();
						if(jarEntryName.endsWith(".class"))
						{
							String className = jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replace("/", ".");
							out.println(className);
							doAddClass(classSet, className);
						}
					}
				}
				
			}
		}
		
	   } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	    
	   out.println("classSet.size:" + classSet.size()+"");
   }
   
   private static void addClass(Set<Class<?>> classSet, String packagePath, String packageName)
   {
	   File[] files = new File(packagePath).listFiles(new FileFilter(){

		@Override
		public boolean accept(File pathname) {
			// TODO Auto-generated method stub
			return (pathname.isFile() && pathname.getName().endsWith(".class")) || pathname.isDirectory();
		}});
	   
	   for(File file: files)
	   {
		   
		   String fileName = file.getName();
		   if (file.isFile())
		   {
			   String className = fileName.substring(0, fileName.lastIndexOf("."));
			   doAddClass(classSet, packageName+"."+className);
		   }
		   else
		   {
			   String subPackagepath = packagePath+ "/"+fileName;
			   String subPackageName = packageName+"."+fileName;
			   addClass(classSet,subPackagepath,subPackageName);
		   }
	   }
	   
   }
   
   private static void doAddClass(Set<Class<?>> classSet, String classPath)
   {
	   Class<?> cls = loadClass(classPath,false);
	   classSet.add(cls);
   }

   public static void toUrl()
   {
	   File file = new File("G:/Users/crs/lunaWorkspace/corejava1.0/bin/locadClass/Client.class");  
	// Convert File to a URL  
	 URL url;
	try {
		url = file.toURL();
		URLClassLoader urlconn =new URLClassLoader( new  URL[] { url }, Thread.currentThread().getContextClassLoader()); 
		Class<?> cls = urlconn.loadClass("locadClass.Client");
		//Class<?> cls = Class.forName("locadClass.Client");
		out.println(cls.getName());
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields)
		{
			out.println(field.getName());
		}
		Method method= cls.getDeclaredMethod("printStr");  //如果
		Object client= cls.newInstance();

		setField(client,fields[0],"cjk");
		
		invokeMethod(client,method,null);
		
		out.println(cls.getName());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SecurityException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (NoSuchMethodException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
   }
   
   public static void setField(Object obj, Field field, Object value)
   {
	   field.setAccessible(true);
	   try {
		field.set(obj, value);
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   
   public static Object invokeMethod(Object obj, Method method, Object ...args)
   {
	   try {
		 method.setAccessible(true);
		  return method.invoke(obj, args);
	} catch (IllegalArgumentException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InvocationTargetException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return args;
   }
   
}
