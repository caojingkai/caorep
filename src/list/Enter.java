package list;

import java.util.ArrayList;
import java.util.List;

public class Enter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		listSty();
	}
	
	public static void listSty()
	{
		Content c1 =new Content(1);
		Content c2 =new Content(2);
		Content c3 =new Content(3);
		List l1 = new ArrayList<Content>();
		l1.add(c1);
		//p(l1,"l1");
		
		
		List l2 = new ArrayList<Content>();
		
		
		l2.add(c1);
		l2.add(c2);
		
		l1.addAll(l2);
		
		p(l1,"l2");
		
	}
	
	
	public static void p(List<Content> list,String listName)
	{
		int i=0;
		for(Content content:list)
		{
		   System.out.println(listName+"("+i+++")"+">>>>"+content);
		}
	}

}
