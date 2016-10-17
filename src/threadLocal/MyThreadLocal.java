package threadLocal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyThreadLocal <T>{

	//Concurrent [kən'kɝənt]
	private Map<Thread,T> container = new ConcurrentHashMap<Thread,T>();
   
	public T get()
   {  
	   Thread thread = Thread.currentThread();
	   T value = container.get(thread);
	   if (null == value && !container.containsKey(thread)) 
	   {
		   value = initialValue();
		   container.put(thread, value);
	   }
		return value;
	}
   public void set(T value)
  {
	   container.put(Thread.currentThread(),value);
  }
   
   public void remove()
   {
	container.remove(Thread.currentThread());   
   }
   
   protected T initialValue()
   {
	   return null;
   }

}
