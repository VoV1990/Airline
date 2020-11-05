public class AirlinesDatabase {
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
}
