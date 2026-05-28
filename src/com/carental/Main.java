package com.carental;
public class Main {
    public static void main(String[] args){
        RentalAgency agency = new RentalAgency();

        agency.addCar(1, "Toyota", "Camry", 2022, 50.0);
        agency.addCar(2, "Honda", "Civic", 2021, 45.0);
        agency.addCar(3, "BMW", "X5", 2023, 120.0);
        agency.addCar(4, "Ford", "Focus", 2020, 35.0);
        agency.addCar(5, "Tesla", "Model 3", 2023, 80.0);

        agency.registerCustomer(101, "Alice Johnson", "DL00101");
        agency.registerCustomer(102, "Bob Smith", "DL00102");
        agency.registerCustomer(103, "Charlie Brown", "DL00103");

        agency.rentCar(101, 1, 1, 4, true);
        agency.rentCar(102, 3, 5, 15, false);
        agency.rentCar(103, 2, 10, 17, true);
        agency.rentCar(101, 5, 20, 23, true);

        System.out.println("\n--- Testing unavailable car ---");
        agency.rentCar(102, 1, 1, 5, false);

        System.out.println("\n--- Returning cars ---");
        agency.returnCar(1, 150);
        agency.returnCar(2, 850);

        System.out.println("\n--- Fleet Status ---");
        agency.printFleetReport();

        System.out.println("\n--- Financial Report ---");
        agency.printFianancialSummary();
    }
}