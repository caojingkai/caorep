package byteSty;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
public class Byte {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println((byte)1002);
		//readFile();
		//showByte();
		movel();
	}
	
	public static void readFile()
	{
	   	String fileName ="E:\\tt.txt";
	    File file = new File(fileName);
	    try {
			FileInputStream input = new FileInputStream(file);
			out.println(input.available());
			byte [] by = new byte[input.available()];
			int num =0;
			input.read(by);
			input.close();
			String str = new String(by);
			out.println(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void showByte()
	{
		String str="1220";
		byte [] ra= str.getBytes();
		int intt = 10;
		out.println(ra.length);
		for(int i=0; i<ra.length;i++)
		{
			out.println(ra[i]);
		}
	}
	
/*	java中有三种移位运算符
	<<      :     左移运算符，num << 1,相当于num乘以2
	>>      :     右移运算符，num >> 1,相当于num除以2
	>>>    :     无符号右移，忽略符号位，空位都以0补齐*/
	public static void movel()
	{
		int bitIndexCounter =4; //8421 0100
		int dtss = 1 << bitIndexCounter; //10000
		int ds32 = bitIndexCounter <<1;  //1000
		System.out.println("dtss:"+dtss);
		System.out.println("ds32:"+ds32);
		 char arrych[] = new char[10 << 1];
		 out.println("arry.length"+arrych.length);
		 int ds = 10<<1;
		 System.out.println(Integer.toBinaryString(ds));
		 int sd = 100>>1;
		 System.out.println(Integer.toBinaryString(sd));
		 out.println("10<<1="+ds+",100>>1="+sd);
	}
	
	

}

