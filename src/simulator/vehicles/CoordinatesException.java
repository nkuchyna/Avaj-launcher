package simulator.vehicles;

public class CoordinatesException extends Exception {

    public CoordinatesException(){
        System.out.println("Error! Coordinates must be positive integers!");
    }
}