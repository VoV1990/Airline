import java.io.IOException;

public class Main {
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
        AirlinesDatabase database = new AirlinesDatabase(airline1, airline2, airline3, airline4, airline5);
        database.chooseOption();
    }
}
