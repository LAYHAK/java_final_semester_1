package luckydraw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;



public class CustomerDao {
    //use collection sort to sort no of customer

    protected static void listOfCustomers(ArrayList<CustomerDto> customerDtos) {
        customerDtos.add(new CustomerDto(1, "Heng Layhak", "012 278 896"));
        customerDtos.add(new CustomerDto(2, "It Vuthy", "010 250 250"));
        customerDtos.add(new CustomerDto(3, "Nuey Mich", "061 595 047"));
        customerDtos.add(new CustomerDto(4, "Teng Panha", "012 454 616"));
        customerDtos.add(new CustomerDto(5, "Seng Phearun", "010 891 195"));
        customerDtos.add(new CustomerDto(6, "Yet Sokros", "011 278 811"));
        customerDtos.add(new CustomerDto(7, "Nhor Vengchhay", "098 881 995"));
        customerDtos.add(new CustomerDto(8, "Hout Sovannarith", "012 168 681"));
        customerDtos.add(new CustomerDto(9, "Thoem Veasna", "012 888 999"));
    }

    protected static void addWinner(CustomerDto c, ArrayList<CustomerDto> winners, ArrayList<CustomerDto> customerDtos) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.print("The winner is:");
        System.out.println(c.toString());
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
