package luckydraw;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LuckyDraw {

    public static void main(String[] args) {

        // Create a list of customers
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", "1234567890"));
        customers.add(new Customer(2, "Jane Doe", "0987654321"));
        customers.add(new Customer(3, "Peter Parker", "9876543210"));
        customers.add(new Customer(4, "Mary Jane Watson", "1098765432"));
        customers.add(new Customer(5, "Bruce Wayne", "2109876543"));
        customers.add(new Customer(6, "Clark Kent", "3210987654"));
        customers.add(new Customer(7, "Diana Prince", "4321098765"));
        customers.add(new Customer(8, "Arthur Curry", "5432109876"));
        customers.add(new Customer(9, "Barry Allen", "6543210987"));
        customers.add(new Customer(10, "Victor Stone", "7654321098"));

        // Shuffle the list of customers

        // Create a list to store the winners
        ArrayList<Customer> winners = new ArrayList<>();
        //Create Random number from 1 to 10
        Random random = new Random();
        int randomNum = random.nextInt(10) + 1;
        // Select three random winners
        winners.add(customers.get(randomNum));
        for (Customer winner : winners) {
            if (winner.equals(customers.get(randomNum)))
            {
                System.out.println(winner);
            }
        }
        // Ask the user if they want to continue
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? (y/n)");
        String answer = scanner.nextLine();

        // If the user says yes, continue the lucky draw
        while (answer.equals("y")) {
            // Reset the list of winners
            System.out.println("Do you want to reset the list of winners? (c/n)");
            answer = scanner.nextLine();
            if (answer.equals("c")) {
                winners.clear();
            }
            // Select three new random winners
            winners.add(customers.get(randomNum));
            // Ask the user if they want to continue
            System.out.println("Do you want to continue? (y/n)");
            answer = scanner.nextLine();
        }
        // Print the winners
        System.out.println("The winners of the lucky draw are:");
        for (Customer winner : winners) {
            System.out.println(winner.getNo() + "\t" + winner.getName() + "\t" + winner.getTel());
        }
    }
}

