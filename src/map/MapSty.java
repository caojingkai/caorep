package map;

import java.util.HashMap;
import java.util.Map;

public class MapSty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Map<String,String> map =new HashMap<String, String>();
     map.put("one", "one1");
     for(Map.Entry<String, String> str: map.entrySet())
     {
    	 String strKey = str.getKey();
    	 String strValue = str.getValue();
    	 System.out.println(strKey+"/"+strValue);
     }
     map.values();
	}

}
