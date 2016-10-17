package dynamicProxy;

public class Entrust{
   
	public void say()
	{
		System.out.println("做要做的事情！ 你还想证明什么？");
	}
	
	public void sayFriends(String name,String ...friends)
	{
		System.out.println(name+"的朋友们：");
		for(String str :friends)
		{
			System.out.println(">>>>："+str);
		}
	}
}
