import java.io.*;

public class Main {

    static Car[] vehicles;
    static Ride[] rides;

    public static void main(String[] args) {
        loadInfo();

        /*
        Car car1 = new Car();
        car1.carId = 1;
        Car car2 = new Car();
        car2.carId = 2;
        car2.endPos = new int[]{0,1};

        vehicles = new Car[2];
        vehicles[0] = car1;
        vehicles[1] = car2;

        rides = new Ride[]{new Ride(0,0,new int[]{0,2}, new int[]{0,5})};
        **/

        //algorithm for closest car
        int shortest = Math.abs(vehicles[0].endPos[0] - rides[0].startPos[0]) +
                Math.abs(vehicles[0].endPos[1] - rides[0].startPos[1]);
        Car closestCar = vehicles[0];

        for(Ride r : rides){
            //check which car is closest
            for(Car c : vehicles){
                int tmpShortest = Math.abs(c.endPos[0] - r.startPos[0]) +
                        Math.abs(c.endPos[1] - r.startPos[1]);
                if (tmpShortest < shortest){
                    c.rides2take.add(r);
                }
            }
        }

        int stepCounter = 0;
        boolean step = true;

        while (step){

            for (Car c : vehicles){
                if (c.moving == false && c.posCar != c.rides2take.get(0).startPos){
                    if(c.posCar[0] != c.rides2take.get(0).startPos[0]){
                        if(c.rides2take.get(0).startPos[0] > c.posCar[0]){
                            c.posCar[0]++;
                        }else if(c.rides2take.get(0).startPos[0] < c.posCar[0]){
                            c.posCar[0]--;
                        }
                        stepCounter++;
                    }else if(c.posCar[1] != c.rides2take.get(0).startPos[1]){
                        if(c.rides2take.get(0).startPos[1] > c.posCar[1]){
                            c.posCar[1]++;
                        }else if(c.rides2take.get(0).startPos[1] < c.posCar[1]){
                            c.posCar[1]--;
                        }
                        stepCounter++;
                        if (stepCounter == c.rides2take.get(0).startStep){
                            c.rides2take.get(0).bonusAvail = true;
                            c.moving = true;
                        }else if(stepCounter > c.rides2take.get(0).startStep){
                            c.rides2take.get(0).bonusAvail = false;
                            c.moving = true;
                        }
                    }
                }else if(c.moving){
                    if(c.posCar[0] != c.rides2take.get(0).endPos[0]){
                        if(c.rides2take.get(0).endPos[0] > c.posCar[0]){
                            c.posCar[0]++;
                        }else if(c.rides2take.get(0).endPos[0] < c.posCar[0]){
                            c.posCar[0]--;
                        }
                        stepCounter++;
                    }else if(c.posCar[1] != c.rides2take.get(0).endPos[1]){
                        if(c.rides2take.get(0).endPos[1] > c.posCar[1]){
                            c.posCar[1]++;
                        }else if(c.rides2take.get(0).endPos[1] < c.posCar[1]){
                            c.posCar[1]--;
                        }
                        stepCounter++;
                    }
                }
            }
            step = false;
        }
        System.out.println("The total is: " + stepCounter);
    }

    public static void loadInfo(){
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
        String[] cars = s.split("\\n");


        String[] summary = cars[0].split("\\s+");
        int rows = Integer.parseInt(summary[0]);
        int cols = Integer.parseInt(summary[1]);
        int numVehicles = Integer.parseInt(summary[2]);
        int numRides = Integer.parseInt(summary[3]);
        int bonus = Integer.parseInt(summary[4]);
        int steps = Integer.parseInt(summary[5]);


        rides = new Ride[numRides];
        vehicles = new Car[numVehicles];
        // start at 1 as line 0 is the summary

        int index = 0;
        for(int i = 1; i < cars.length; i++) {
            String[] ride = cars[i].split("\\s+");
            // assign values to rides
            int startX = Integer.parseInt(ride[0]);
            int startY = Integer.parseInt(ride[1]);

            int endX = Integer.parseInt(ride[2]);
            int endY = Integer.parseInt(ride[3]);

            int startStep = Integer.parseInt(ride[4]);
            int endStep  = Integer.parseInt(ride[5]);

            rides[index] = new Ride(startStep, endStep, new int[]{startX, startY}, new int[]{endX, endY});
            index++;

        }
    }
}
