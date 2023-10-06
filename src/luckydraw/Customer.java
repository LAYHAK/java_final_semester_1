package luckydraw;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Customer {
    private int no;
    private String name;
    private String tel;
    public Customer(){}
    public Customer(int no, String name, String tel) {
        this.no = no;
        this.name = name;
        this.tel = tel;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    @Override
    public String toString() {
        return
                "no=" + no +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\''
                ;
    }
    protected static void listOfCustomers(ArrayList<Customer> customers) {
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
    }
    private static void addWinner(String a, Customer c, ArrayList<Customer> winners) throws InterruptedException {
        if (a.equalsIgnoreCase("y")) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(c.getTel());
            winners.add(c);
        }
    }
    protected static void printSentence(ArrayList<Customer> winners) {
        if (winners.size() == 0) {
            System.out.println("No winners");
        }else if(winners.size() == 1){
            System.out.println("The winner of the lucky draw is:");
        }else{
            System.out.println("The winners of the lucky draw are:");
        }
    }
    protected static String getAnswer(int i, Scanner scanner, Customer c, ArrayList<Customer> winners) throws InterruptedException {
        String a;
        if (i == 0) {
            System.out.print("Do you want start the Lucky Draw? (y/n): ");
            a = scanner.nextLine();
            addWinner(a, c, winners);
        } else if (i < 5) {
            System.out.print("Do you want continue the Lucky Draw? (y/n): ");
            a = scanner.nextLine();
            addWinner(a, c, winners);
        } else {
            a = "n";
        }
        return a;
    }
}

