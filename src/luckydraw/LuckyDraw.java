package luckydraw;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static luckydraw.Customer.*;

public class LuckyDraw {
    public static void main(String[] args) throws InterruptedException {

        // Create a list of customers
        ArrayList<Customer> customers = new ArrayList<>();
        listOfCustomers(customers);
        // Create a list to store the winners

        System.out.println("========== Start Lucky Draw Customer ========");
        Scanner scanner = new Scanner(System.in);
        String a;
        int i = 0;
        int n = customers.size() - 1;
        ArrayList<Customer> winners = new ArrayList<>();
        do {
            Random random = new Random();
            int r = random.nextInt(n) + 1;
            Customer c = customers.get(r);
            a = getAnswer(i, scanner, c, winners);
            i++;
            customers.remove(c);
            n--;
            if (a.equalsIgnoreCase("y") && i < 5) {
                System.out.print("Do you want reset the list of winners? (c/n): ");
                a = scanner.nextLine();
                if (a.equalsIgnoreCase("c")) {
                    i = 0;
                    n= customers.size() - 1;
                    customers.addAll(winners);
//                    System.out.println(customers.size());
                    winners.clear();
                }
                a = "y";
            }

        } while (a.equalsIgnoreCase("y"));
        System.out.println("========== End Lucky Draw Customer ========");
        printSentence(winners);
        for (Customer winner : winners) {
            System.out.println(winner.toString());
        }
    }


}

