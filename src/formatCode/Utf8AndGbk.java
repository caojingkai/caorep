package formatCode;

import java.io.UnsupportedEncodingException;

public class Utf8AndGbk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     try {
    	 String t = "这是一个字符串aa11121123";
		String gbk = new String(t.getBytes("UTF-8"),"GBK");
		System.out.println(gbk);
		String urf = new String(gbk.getBytes("GBK"),"UTF-8");
		System.out.println(urf);
		String urf2 = new String(gbk.getBytes("UTF-8"),"GBK");
		System.out.println(urf2);

	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
