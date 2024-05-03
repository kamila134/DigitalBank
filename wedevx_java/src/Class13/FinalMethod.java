package Class13;

public class FinalMethod {

}

class Test {
    public final void testing(){
        System.out.println("Let's see if this can be overridden or overloaded");

    }

    public void testing (int i){
        System.out.println("So it can be overloaded but not overridden ");
    }
}
