package extendsSty;

public abstract class TwoGrandfather implements GreatGrandfather {

	public abstract void twoGrandfather();
	
	public void aterMake()
	{
		System.out.println("TwoGrandfather.aterMake()");
	}
	
	public void greatGrandfather()
	{
		System.out.println(this.getClass().getName());
	}
}
