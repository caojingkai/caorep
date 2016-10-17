package stringSty;
import static java.lang.System.out;

import java.util.ArrayList;
import java.util.List;
public class StringSty1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ss();
	}

	public static void ss()
	{
		String srt="perms[user:main,user:issue]";
		String pair[] = srt.split("\\[",3);		
		for(String str :pair)
		{
			out.println(str);
		}
		
	}
	
	public static String[] split(String aLine, char delimiter, char beginQuoteChar, char endQuoteChar, boolean retainQuotes, boolean trimTokens)
    {
        String line = aLine;
        if(line == null)
            return null;
        List tokens = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        for(int i = 0; i < line.length(); i++)
        {
            char c = line.charAt(i);
            if(c == beginQuoteChar)
            {
                if(inQuotes && line.length() > i + 1 && line.charAt(i + 1) == beginQuoteChar)
                {
                    sb.append(line.charAt(i + 1));
                    i++;
                    continue;
                }
                inQuotes = !inQuotes;
                if(retainQuotes)
                    sb.append(c);
                continue;
            }
            if(c == endQuoteChar)
            {
                inQuotes = !inQuotes;
                if(retainQuotes)
                    sb.append(c);
                continue;
            }
            if(c == delimiter && !inQuotes)
            {
                String s = sb.toString();
                if(trimTokens)
                    s = s.trim();
                tokens.add(s);
                sb = new StringBuilder();
            } else
            {
                sb.append(c);
            }
        }

        String s = sb.toString();
        if(trimTokens)
            s = s.trim();
        tokens.add(s);
        return (String[])tokens.toArray(new String[tokens.size()]);
    }
	
	
    public static String clean(String in)
    {
        String out = in;
        if(in != null)
        {
            out = in.trim();
            if(out.equals(""))
                out = null;
        }
        return out;
    }

}
