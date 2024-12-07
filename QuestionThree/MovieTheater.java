package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;


public class MovieTheater {
    private ArrayList<ArrayList<String>> seats;

    public MovieTheater(int numRows, int column) {
        seats = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<String> row = new ArrayList<>();
            for (int j = 0; j < column; j++) {
                row.add("Available");
            }
            seats.add(row);
        }
    }

    public void displaySeatingChart() {
        System.out.println("\nSeating Chart:");
        for (int i = 0; i < seats.size(); i++) {
            System.out.print("Row " + (i + 1) + ": ");
            for (int j = 0; j < seats.get(i).size(); j++) {
                System.out.print(seats.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void reserveSeat(int row, int column) {
        if (seats.get(row - 1).get(column - 1).equals("Available")) {
            seats.get(row - 1).set(column - 1, "Reserved");
            System.out.println("Seat reserved successfully!");
        } else {
            System.out.println("Sorry, this seat has already been reserved.");
        }
    }

    public void cancelSeat(int row, int column) {
        if (seats.get(row - 1).get(column - 1).equals("Reserved")) {
            seats.get(row - 1).set(column - 1, "Available");
            System.out.println("Reservation cancelled successfully!");
        } else {
            System.out.println("Sorry, this seat is not reserved.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Movie Theater!");

        // Initialize a seating chart with 5 rows and 5 seats per row
        MovieTheater theater = new MovieTheater(5, 5);

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. View seating chart");
            System.out.println("2. Reserve a seat");
            System.out.println("3. Cancel a reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 1) {
                theater.displaySeatingChart();
            } else if (option == 2) {
                System.out.print("Enter row number to reserve: ");
                int row = scanner.nextInt();
                System.out.print("Enter seat number to reserve: ");
                int col = scanner.nextInt();
                theater.reserveSeat(row, col);
            } else if (option == 3) {
                System.out.print("Enter row number to cancel: ");
                int row = scanner.nextInt();
                System.out.print("Enter seat number to cancel: ");
                int col = scanner.nextInt();
                theater.cancelSeat(row, col);
            } else if (option == 4) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}

