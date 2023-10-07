package luckydraw;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import static luckydraw.Customer.*;

public class LuckyDraw {
    public static void main(String[] args) throws InterruptedException {
        // Create a list of customers
        ArrayList<Customer> customers = new ArrayList<>();
        listOfCustomers(customers);
        // Create a list to store the winners
        Scanner scanner = new Scanner(System.in);
        String a;
        int i = 0;
        int n = customers.size() - 1;
        boolean run = true;
        ArrayList<Customer> winners = new ArrayList<>();
        do {
            listOfChoices();
            System.out.print("Enter your choice: ");
            a= scanner.nextLine();
            a=a.toLowerCase(Locale.ROOT);
            Random random = new Random();
            int r = random.nextInt(n) + 1;
            Customer c = customers.get(r);
            if (i<5) switch (a) {
                case "s" -> {
                    addWinner(c, winners, customers);
                    i++;
                    n--;
                }
                case "r" -> {
                    i = 0;
                    n = customers.size() - 1;
                    resetWinners(customers, winners);
                }
                case "e" -> run = false;
                default -> System.out.println("Invalid choice");
            }
            else switch (a) {
                case "s" -> System.out.println("Sorry, you have reached the maximum number of winners");
                case "r" -> {
                    i = 0;
                    n = customers.size() - 1;
                    resetWinners(customers, winners);
                }
                case "e" -> run = false;
                default -> System.out.println("Invalid choice");
            }
        } while (run);
        scanner.close();
        printSentence(winners);
        for (Customer winner : winners) {
            System.out.println(winner.toString());
        }
    }




}

