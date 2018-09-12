public class Ticket {
    private String venue;
    private int price;
    private boolean valid;
    private int numRides;
    private int clipCounter;

    public Ticket(String venue, int price, int numRides) {

        this.venue = venue;
        this.price = price;
        this.valid = true;
        this.numRides = numRides;
        this.clipCounter = 0;
    }
    public Ticket(String venue, int price) {
        this.venue = venue;
        this.price = price;
        this.valid = true;    //5. Newly ticket is valid (default is false)
        this.numRides = 1;
        this.clipCounter = 0;
    }


    @Override
    public String toString() {
        String printMessage;
        printMessage = "##################" + System.lineSeparator();
        printMessage += "# " + venue + System.lineSeparator();
        printMessage += "# Ticket" + System.lineSeparator();
        printMessage += "# " + price + " cents." + System.lineSeparator();
        printMessage += "##################";

        return printMessage;


    }

    public boolean isValid() {
       if (clipCounter< numRides){
           valid = true;
       }
       else {
           valid = false;
       }

         return valid;
    }



    public boolean use() {

        boolean tempValid = isValid();
        clipCounter = clipCounter +1;

        return tempValid;

    }


}
