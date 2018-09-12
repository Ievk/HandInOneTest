/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    private String venue;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(String venue, int price)
    {
        this.venue = venue;
        this.price = price;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public Ticket printTicket()
    {

        if(balance >= price) {

            Ticket ticket = new Ticket(venue, price);
            // Simulate the printing of a ticket.

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;

            return ticket;
        }
        else {

            Ticket ticketNotValid = new Ticket(venue, price,-1);
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
            return ticketNotValid;
                    
        }
    }

    public Ticket printMultiRideTicket(int numRides)
    {
        if(numRides>=1) {
            int totalTicketPrice = numRides * price;
            // check if ennough money has been inserted
            if (balance >= totalTicketPrice) {

                Ticket ticket = new Ticket(venue, price, numRides);

                //this total is the grand total of the sales for the machine
                total = total + totalTicketPrice;

                balance = balance - totalTicketPrice;

                return ticket;
            } else {
                Ticket ticketNotValid = new Ticket(venue, price,-1);

                System.out.println("You must insert at least: " +
                        (totalTicketPrice - balance) + " more cents.");

                return ticketNotValid;
            }
        }
        else {
            System.out.println("Cannot issue a multi-ride ticket for fewer than 1 rides!");
            return null;
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    public static void main(String[] args) {
       //Used for test
        Ticket ticket;
        TicketMachine machine;
        machine = new TicketMachine("Le Geai Bleu", 20);
        machine.insertMoney(500);
      //  ticket = machine.printTicket();
        ticket = machine.printMultiRideTicket(10);
        System.out.println(ticket);
        System.out.println(machine.printMultiRideTicket(10));
        System.out.println(machine.printMultiRideTicket(10));
        System.out.println(machine.printMultiRideTicket(2));
        System.out.println(machine.printMultiRideTicket(-1));

        boolean result = ticket.isValid();
        boolean wasUsed = ticket.use();
        boolean resultAfterUse =  ticket.isValid();
    }
}
