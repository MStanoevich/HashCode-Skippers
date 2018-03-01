import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Car {
	public int[] posCar = new int[]{0,0};
	public int carId;
	public int distance;
	//public Ride[] ridesTaken;
	int[] endPos;
	boolean moving = false;

	public List<Ride> rides2take;

	public Car(){
		endPos = new int[]{0,0};
	}

	public int[] endPosition(){
		return rides2take.get(rides2take.size()).endPos;
	}

	public void setEndPos(int[] endPos){
		this.endPos = endPos;
	}

	public int getTotalScore(){
		for(int i = 0; i < rides2take.size(); i++){

		}
		return 0;
	}
}
