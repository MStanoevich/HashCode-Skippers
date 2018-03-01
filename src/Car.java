
public class Car {

	public int[] posCar;
	public int carId;
	public int distance;
	public Ride[] ridesTaken;

	public Car(int[] posCar, int carId, int distance, Ride[] ridesTaken){
	    this.posCar = posCar;
	    this.carId = carId;
	    this.distance = distance;
	    this.ridesTaken = ridesTaken;
    }
}
