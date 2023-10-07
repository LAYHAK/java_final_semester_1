package luckydraw;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import static luckydraw.CustomerDao.*;

public class LuckyDraw {
    public static void main(String[] args) throws InterruptedException {
        // Create a list of customers
        ArrayList<CustomerDto> customers = new ArrayList<>();
        listOfCustomers(customers);
        // Create a list to store the winners
        Scanner scanner = new Scanner(System.in);
        String a;
        int i = 0;
        int n = customers.size() - 1;
        boolean run = true;
        ArrayList<CustomerDto> winners = new ArrayList<>();
        do {
            listOfChoices(i);
            System.out.print("Enter your choice: ");
            a = scanner.next();
            System.out.println();
            a = a.toLowerCase(Locale.ROOT);
            Random random = new Random();
            int r = random.nextInt(n) + 1;
            CustomerDto c = customers.get(r);
            if (i < 5) switch (a) {
                case "s" -> {
                    System.out.println("------------------------------------");
                    addWinner(c, winners, customers);
                    System.out.println("------------------------------------");
                    i++;
                    n--;
                }
                case "r" -> {
                    i = 0;
                    resetWinners(customers, winners);
                    n = customers.size() - 1;
                }
                case "e" -> run = false;
                case "h" -> {
                    System.out.println("------------------------------------");
                    listAllCustomers(customers);
                    System.out.println("------------------------------------");
                }

                case "w" -> listAllWinners(winners);
                default -> {
                    notListedChoice();
                    System.out.println();
                }
            }
            else switch (a) {
                case "s" -> reachMaximum();
                case "r" -> {
                    i = 0;
                    resetWinners(customers, winners);
                    n = customers.size() - 1;
                }
                case "e" -> run = false;
                case "h" -> {
                    System.out.println("------------------------------------");
                    listAllCustomers(customers);
                    System.out.println("------------------------------------");
                }case "w" -> {
                    System.out.println("------------------------------------");
                    listAllWinners(winners);
                    System.out.println("------------------------------------");
                }

                default -> {
                    notListedChoice();
                    System.out.println();
                }
            }
        } while (run);
        scanner.close();
        printSentence(winners);
        listAllWinners(winners);
        System.out.println("------------------------------------");
    }
}

