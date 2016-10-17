package extendsSty.stry;



public abstract class Grandfather {

    public void setRealms() {
      
        afterRealmsSet();
    }
	
    protected void afterRealmsSet() {
        applyCacheManagerToRealms();
        System.out.println("Grandfather.afterRealmsSet");
    }
    protected void applyCacheManagerToRealms() {
    	 System.out.println("Grandfather.applyCacheManagerToRealms");
    }
}