package Class13;

public class ThrowThrowsException {
    public static void main(String[] args) throws Exception {
        transfer(1000);
    }

    //throws keyword is used to declare exceptions in a method signature
    public static void withdraw(int amount)throws Exception{
        int balance = 100;

        if(amount>balance){

            // throw keyword actually throws an exception
            throw new Exception("Insufficient funds");
        }
    }

    public static void transfer(int num){
        try{
            withdraw(num);
            System.out.println("it worked");
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
