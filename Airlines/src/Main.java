import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Airline airline1 = new Airline("Moscow", 12345, "Boeing 767",
                "10.30", "Monday");
        Airline airline2 = new Airline("London", 34543, "Boeing 737",
                "10.00", "Monday");
        Airline airline3 = new Airline("New York", 23415, "Airbus",
                "11.30", "Tuesday");
        Airline airline4 = new Airline("Moscow", 12346, "Airbus",
                "11.00", "Wednesday");
        Airline airline5 = new Airline("Munich", 65421, "Boeing 767",
                "11.40", "Friday");
        Airline[] airlines = {airline1, airline2, airline3, airline4, airline5};
        AirlinesDatabase database = new AirlinesDatabase(airlines);
        chooseOption(database);
    }

    private static void chooseOption(AirlinesDatabase database) throws IOException {
        boolean stop = false;
        int option;
        do{
            System.out.println("Please choose one of the suggested options and enter its number.");
            System.out.println("1. Display a list of flights for a given destination.");
            System.out.println("2. Display a list of flights for a given day of the week.");
            System.out.println("3. Display a list of flights for a given day of the week that have " +
                    "a longer departure time than the specified one.");
            option = Integer.parseInt(reader.readLine());
            if(option == 1 || option == 2 || option == 3) stop = true;
            else System.out.println("Please try again");
        } while (!stop);
        getFlights(option, database);
    }

    private static void getFlights(int option, AirlinesDatabase database) throws IOException {
        switch (option) {
            case 1 -> {
                System.out.println("Please enter destination:");
                String destination = reader.readLine();
                for (int i = 0; i < database.getAirlines().length; i++) {
                    if(database.getAirlines()[i].getDestination().equalsIgnoreCase(destination))
                        System.out.println(database.getAirlines()[i]);
                }
            }
            case 2 -> {
                System.out.println("Please enter day of the week:");
                String day = reader.readLine();
                for (int i = 0; i < database.getAirlines().length; i++) {
                    if(database.getAirlines()[i].getDayOfWeek().equalsIgnoreCase(day))
                        System.out.println(database.getAirlines()[i]);
                }
            }
            case 3 -> {
                System.out.println("Please enter day of the week:");
                String day = reader.readLine();
                System.out.println("Please enter time(hh.mm):");
                double time = Double.parseDouble(reader.readLine());
                for (int i = 0; i < database.getAirlines().length; i++) {
                    double time1 = Double.parseDouble(database.getAirlines()[i].getTimeOfDeparture());
                    if(database.getAirlines()[i].getDayOfWeek().equalsIgnoreCase(day) && time1 > time)
                        System.out.println(database.getAirlines()[i]);
                }
            }
        }
    }
}
