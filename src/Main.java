import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
    	Ride[] rides = createRides();
        Car[] cars = createCars();
        int steps = getSteps();


    }
    
	// Method for generating the rides from the input file
    public static Ride[] createRides() {
    	BufferedReader br = null;
        File file = new File("Examples/a_example.in");
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        StringBuilder sb = new StringBuilder();
        String line = "";
        try {
            line = br.readLine();
        } catch (IOException e ) {
            System.out.println(e.getMessage());
        }

        while(line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            try {

                line = br.readLine();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        String s = sb.toString();
        String[] row = s.split("\\n");


        String[] summary = row[0].split("\\s+");
        int rows = Integer.parseInt(summary[0]);
        int cols = Integer.parseInt(summary[1]);
        int vehicles = Integer.parseInt(summary[2]);
        int numRides = Integer.parseInt(summary[3]);
        int bonus = Integer.parseInt(summary[4]);
        int steps = Integer.parseInt(summary[5]);
        
    	Ride[] rides = new Ride[numRides];
        // start at 1 as line 0 is the summary

        int index = 0;
        for(int i = 1; i < row.length; i++) {
            String[] ride = row[i].split("\\s+");
            // assign values to rides
            int startX = Integer.parseInt(ride[0]);
            int startY = Integer.parseInt(ride[1]);

            int endX = Integer.parseInt(ride[2]);
            int endY = Integer.parseInt(ride[3]);

            int startStep = Integer.parseInt(ride[4]);
            int endStep  = Integer.parseInt(ride[5]);
            // id = i - 1 to index from 0
            rides[index] = new Ride(startStep, endStep, new int[]{startX, startY}, new int[]{endX, endY}, i-1);
            index++;

        }
        return rides;

    }

    public void orderRides(Ride[] rides) {
        int[] start = new int[]{0,0};
        int closestDistance = Integer.MAX_VALUE;
        int indexClosest = Integer.MAX_VALUE;
        // get first ride
        for(int i = 0; i < rides.length; i++) {
            int diffX = Math.abs(rides[i].startPos[0] - start[0]);
            int diffY = Math.abs(rides[i].startPos[1] - start[1]);

            if (diffX + diffY < closestDistance) {
                closestDistance = diffX + diffY;
                indexClosest = i;
            }
        }
        Queue<Ride> rideQueue = new LinkedList<>();
        Ride firstRide = rides[indexClosest];

        Ride closestRide = null;
        int lowestDiff = Integer.MAX_VALUE;
        for(int i = 0; i < rides.length; i++) {
            for (int j = 0; j < rides.length; j++) {
                if(i != indexClosest) {
                    Ride checkRide = rides[i];
                    int diff = (Math.abs(checkRide.startPos[0] - firstRide.endPos[0]) + Math.abs(checkRide.startPos[1] - firstRide.endPos[1]));

                    if(diff < lowestDiff && !contains(rideQueue, i)) {
                        lowestDiff = diff;
                        closestRide = checkRide;
                    }
                }
                rideQueue.add(closestRide);
            }
        }


    }
    boolean contains(Queue<Ride> list, int id) {
        for (Ride item : list) {
            if (item.id == id) {
                return true;
            }
        }
        return false;
    }
   
    // Method for generating the cars from the input file
    public static Car[] createCars() {

            BufferedReader br = null;
            File file = new File("Examples/a_example.in");
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            StringBuilder sb = new StringBuilder();
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e ) {
                System.out.println(e.getMessage());
            }

            while(line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {

                    line = br.readLine();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            String s = sb.toString();
            String[] row = s.split("\\n");


            String[] summary = row[0].split("\\s+");
            int rows = Integer.parseInt(summary[0]);
            int cols = Integer.parseInt(summary[1]);
            int vehicles = Integer.parseInt(summary[2]);
            int numRides = Integer.parseInt(summary[3]);
            int bonus = Integer.parseInt(summary[4]);
            int steps = Integer.parseInt(summary[5]);

        
        Car[] cars = new Car[vehicles];

        int index = 0;
        for(int i = 0; i < vehicles; i++){
            int[] startPos = {0,0};
            int id = 1;
            int distance = 0;
            Ride[] ridesTaken = null;
            cars[index] = new Car(startPos, id, distance, ridesTaken) ;
            index++;
            id++;
        }
      return cars;
    }

    

    public static int getSteps(){
            BufferedReader br = null;
            File file = new File("Examples/a_example.in");
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            StringBuilder sb = new StringBuilder();
            String line = "";
            try {
                line = br.readLine();
            } catch (IOException e ) {
                System.out.println(e.getMessage());
            }

            while(line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                try {

                    line = br.readLine();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            String s = sb.toString();
            String[] row = s.split("\\n");


            String[] summary = row[0].split("\\s+");
            int rows = Integer.parseInt(summary[0]);
            int cols = Integer.parseInt(summary[1]);
            int vehicles = Integer.parseInt(summary[2]);
            int numRides = Integer.parseInt(summary[3]);
            int bonus = Integer.parseInt(summary[4]);
            int steps = Integer.parseInt(summary[5]);

            return steps;
        }

}
