package classSty;

import java.util.ArrayList;
import java.util.List;

/*
 * stydy Class ¿‡
 */
public class ClassTest {
	
	
	public ClassTest(List<? extends ClassTest> list) {
		super();
		this.list = list;
	}

	List<? extends ClassTest> list;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("unused")
		List<Class<?>> list =new ArrayList<Class<?>>();
		list.add(ClassTest.class);
	}

	@SuppressWarnings("rawtypes")
	public <T> Class getClassP(Class<T> T)
	{
	  return T.getClass();
	}
	
	public <T> String getClassStr(Class<T> T)
	{
		return T.toString();
	}
	

	
}

class Apple extends ClassTest{

	public Apple(List<? extends ClassTest> list) {
		super(list);
		// TODO Auto-generated constructor stub
	}};


