package extendsSty.stry;



public abstract class Father1 extends Grandfather{

    protected void afterRealmsSet() {
        super.afterRealmsSet();
        System.out.println("Father1.afterRealmsSet");
    }
}
