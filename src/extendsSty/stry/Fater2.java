package extendsSty.stry;


public abstract class Fater2 extends Father1 {

    protected void afterRealmsSet() {
        super.afterRealmsSet();
        
        System.out.println("Fater2.afterRealmsSet");
      
    }

}
