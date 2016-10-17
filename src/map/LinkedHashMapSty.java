package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapSty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	LinkedHashMap<Integer,Integer> likn = new LinkedHashMap<Integer,Integer>();
	HashMap map = new HashMap<Integer,Integer>();
    for(int i=0;i<20;i++)
    {
    	likn.put(i, i);
    	map.put(i, i);
    }
    
    for(Map.Entry<Integer, Integer> ds: likn.entrySet())
    {
    	System.out.println(ds.getKey()+"=="+ds.getValue());
    	
    }
    Iterator<Integer> ite = map.keySet().iterator(); 
    while(ite.hasNext())
    {
    	Integer ds= ite.next();	
    	System.out.println(map.get(ds));
    }
    }

}
