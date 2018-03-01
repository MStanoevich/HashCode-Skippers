import java.io.*;

public class Main {
    public static void main(String[] args) {
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
        int vehicles = Integer.parseInt(summary[2]);
        int numRides = Integer.parseInt(summary[3]);
        int bonus = Integer.parseInt(summary[4]);
        int steps = Integer.parseInt(summary[5]);


        Ride[] rides = new Ride[numRides];
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
