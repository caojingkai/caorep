package urlSty;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class TestgetFileByURL {

	public static void main (String []args)
	{
		HttpURLConnection hh;
		String  urlAdress ="http://pic1.win4000.com/wallpaper/9/569379afe9f27.jpg";
		try {
			URL url = new URL(urlAdress);
			URLConnection urlConn = url.openConnection();
			InputStream input = urlConn.getInputStream();
			byte[] buffer = new byte[1024];
			BufferedInputStream burrered = new BufferedInputStream(input);  
			FileOutputStream fos = new FileOutputStream("E:\\haha3.gif");  
			int size = 0;
			while ((size=burrered.read(buffer)) != -1)
			{
				fos.write(buffer, 0, size);
			}
			fos.flush();
			fos.close();
			burrered.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}