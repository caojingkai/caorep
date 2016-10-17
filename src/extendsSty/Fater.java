package extendsSty;

public class Fater  extends ThreeGrandfather implements Grandfather{
	public Fater() {
		this.other = new OtherP();
		other.setIntt(10000);
	}
	private OtherP other;
	
	
	
	public OtherP getOther() {
		return other;
	}



	public void setOther(OtherP other) {
		this.other = other;
	}
   public static void main(String[] args) {
		// TODO Auto-generated method stub
	   ThreeGrandfather tgf  = new Fater();
	   tgf.threeGrandfather();
	   
	}
   


	 void threeGrandfather()
	{
		System.out.println("Fater.threeGrandfather");
	}

   
   
   
	@Override
	public void greatGrandfather() {
		// TODO Auto-generated method stub
		
	}



	public void twoGrandfather() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void grandfather() {
		// TODO Auto-generated method stub
		
	}

}
