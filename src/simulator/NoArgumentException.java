package simulator;

public class NoArgumentException extends Exception {

    public NoArgumentException(){
    	System.out.println("Error! Must be one argument.");
    }
}