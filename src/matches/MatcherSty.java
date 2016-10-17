package matches;

import static java.lang.System.out;
public class MatcherSty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bySomeEnd();
	}
	
	public static void bySomeEnd()
	{
		String Str ="dsfdfPage";
	    String math = ".*Page$";
	    out.print(Str.matches(math));
	}

}
