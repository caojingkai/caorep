package dynamicProxy;

public class Entrust{
   
	public void say()
	{
		System.out.println("��Ҫ�������飡 �㻹��֤��ʲô��");
	}
	
	public void sayFriends(String name,String ...friends)
	{
		System.out.println(name+"�������ǣ�");
		for(String str :friends)
		{
			System.out.println(">>>>��"+str);
		}
	}
}
