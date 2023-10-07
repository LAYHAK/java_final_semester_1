package luckydraw;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CustomerDao {

    protected static void listOfCustomers(ArrayList<CustomerDto> customerDtos) {
        customerDtos.add(new CustomerDto(1, "John Doe", "1234567890"));
        customerDtos.add(new CustomerDto(2, "Jane Doe", "0987654321"));
        customerDtos.add(new CustomerDto(3, "Peter Parker", "9876543210"));
        customerDtos.add(new CustomerDto(4, "Mary Jane Watson", "1098765432"));
        customerDtos.add(new CustomerDto(5, "Bruce Wayne", "2109876543"));
        customerDtos.add(new CustomerDto(6, "Clark Kent", "3210987654"));
        customerDtos.add(new CustomerDto(7, "Diana Prince", "4321098765"));
        customerDtos.add(new CustomerDto(8, "Arthur Curry", "5432109876"));
        customerDtos.add(new CustomerDto(9, "Barry Allen", "6543210987"));
        customerDtos.add(new CustomerDto(10, "Victor Stone", "7654321098"));
    }

    protected static void addWinner(CustomerDto c, ArrayList<CustomerDto> winners, ArrayList<CustomerDto> customerDtos) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.print("The winner phone number is:");
        System.out.println(c.getTel());
        winners.add(c);
        customerDtos.remove(c);
    }

    protected static void printSentence(ArrayList<CustomerDto> winners) {
        if (!winners.isEmpty()) {
            if (winners.size() == 1) {
                System.out.println("------------------------------------");
                System.out.println("The winner of the lucky draw is:");
                System.out.println("------------------------------------");
            } else {
                System.out.println("------------------------------------");
                System.out.println("The winners of the lucky draw are:");
                System.out.println("------------------------------------");
            }
        }
//         else {
//            System.out.println("------------------------------------");
//            System.out.println("No winners");
//            System.out.println("------------------------------------");
//        }
    }

    protected static void listOfChoices(int i) {
        printWelcome(i);
        System.out.print("""
                --------------------------------------------
                Choose one of the following options:
                1.Click 'S' to start
                2.Click 'R' to reset
                3.Click 'E' to end
                4.Click 'H' to view the list of customerDtos
                5.Click 'W' to view the list of winners
                --------------------------------------------
                """);
        if (i >= 1) System.out.println();
        printNoteToUser(i);
    }

    private static void printNoteToUser(int i) {
        if (i == 0) System.out.print("""
                -------------------*Note*-------------------
                1.Each customerDto can only win once
                2.The maximum number of winners is 5
                --------------------------------------------
                        """);
    }

    private static void printWelcome(int i) {
        if (i == 0)
            System.out.print("""
                    Welcome to the lucky draw application
                    """);
    }

    protected static void resetWinners(ArrayList<CustomerDto> customerDtos, ArrayList<CustomerDto> winners) throws InterruptedException {
        if (winners.isEmpty()) {
            System.out.println("------------------------------------");

            System.out.println("No winners to reset");
            System.out.println("------------------------------------");

            return;
        }
        System.out.println("------------------------------------");
        System.out.println("Resetting winners...");
        TimeUnit.SECONDS.sleep(3);
        customerDtos.addAll(winners);
        winners.clear();
        System.out.println("Reset complete");
        System.out.println("------------------------------------");
    }

    protected static void listAllCustomers(ArrayList<CustomerDto> customerDtos) {
        for (CustomerDto customerDto : customerDtos) {
            System.out.println(customerDto.toString());
        }
    }

    protected static void listAllWinners(ArrayList<CustomerDto> winners) {
        if (winners.isEmpty()) {
            System.out.println("""
                    ------------------------------------
                            No winners to show
                    ------------------------------------
                                        """);
            return;
        }
        for (CustomerDto winner : winners) {
            System.out.println(winner.toString());
        }
    }

    protected static void reachMaximum() {
        System.out.println("------------------------------------------------------");
        System.out.println("Sorry, you have reached the maximum number of winners");
        System.out.println("------------------------------------------------------");
    }
    protected static void notListedChoice() {
        System.out.println("""
        ------------------------------------
                Invalid choice
        ------------------------------------
        """);
    }
}
