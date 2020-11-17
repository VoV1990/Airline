import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AirlinesDatabase {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Airline[] airlines;

    public AirlinesDatabase(Airline... newAirlines) {
        cloneArray(newAirlines);
    }

    public Airline[] getAirlines() {
        return airlines;
    }

    private static void cloneArray(Airline[] newAirlines) {
        Airline[]tempBase = new Airline[0];
        if(airlines != null) {
            tempBase = airlines;
            airlines = new Airline[tempBase.length + newAirlines.length];
        } else airlines = new Airline[newAirlines.length];
        int index = 0;
        int index2 = 0;
        for (; index < tempBase.length; index++) {
            airlines[index] = tempBase[index];
        }
        for (; index2 < newAirlines.length; index2++) {
            airlines[index] = newAirlines[index2];
            index++;
        }
    }

    public void chooseOption() throws IOException {
        boolean stop = false;
        int option = 0;
        do{
            System.out.println("Please choose one of the suggested options and enter its number.");
            System.out.println("1. Display a list of flights for a given destination.");
            System.out.println("2. Display a list of flights for a given day of the week.");
            System.out.println("3. Display a list of flights for a given day of the week that have " +
                    "a longer departure time than the specified one.");
            try {
                option = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("Invalid data.");
            }
            if(option == 1 || option == 2 || option == 3) stop = true;
            else System.out.println("Please try again.");
        } while (!stop);
        getFlights(option);
    }

    private void getFlights(int option) throws IOException {
        switch (option) {
            case 1 -> {
                System.out.println("Please enter destination:");
                String destination = reader.readLine();
                for (int i = 0; i < this.getAirlines().length; i++) {
                    if(this.getAirlines()[i].getDestination().equalsIgnoreCase(destination))
                        System.out.println(this.getAirlines()[i]);
                }
            }
            case 2 -> {
                System.out.println("Please enter day of the week:");
                String day = reader.readLine();
                for (int i = 0; i < this.getAirlines().length; i++) {
                    if(this.getAirlines()[i].getDayOfWeek().equalsIgnoreCase(day))
                        System.out.println(this.getAirlines()[i]);
                }
            }
            case 3 -> {
                System.out.println("Please enter day of the week:");
                String day = reader.readLine();
                System.out.println("Please enter time(hh.mm):");
                double time = Double.parseDouble(reader.readLine());
                for (int i = 0; i < this.getAirlines().length; i++) {
                    double time1 = Double.parseDouble(this.getAirlines()[i].getTimeOfDeparture());
                    if(this.getAirlines()[i].getDayOfWeek().equalsIgnoreCase(day) && time1 > time)
                        System.out.println(this.getAirlines()[i]);
                }
            }
        }
    }
}
