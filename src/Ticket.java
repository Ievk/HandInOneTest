public class Ticket {
    private String venue;
    private int price;

    public Ticket(String venue, int price)
    {
         this.venue = venue;
         this.price = price;
    }

    @Override
    public String toString() {
        String printMessage;
        printMessage = "##################"+ System.lineSeparator();
        printMessage += "# "+ venue+ System.lineSeparator();
        printMessage += "# Ticket"+ System.lineSeparator();
        printMessage += "# " + price + " cents."+ System.lineSeparator();
        printMessage += "##################";

      return printMessage;
    }





}
