package com.carental;

class Customer {
    int customerId; //unique identifier
    String name; // customer name
    String licenseNum; // driver's license number
    int[] rentalHistory; // array of carIds rented in the past max 10 rentals
    private int rentalCount; // tracks rentals added

    Customer(int customerId, String name, String licenseNum){
        rentalHistory = new int[10];
        rentalCount = 0;
        this.customerId = customerId;
        this.name = name;
        this.licenseNum = licenseNum;
    }
    void addRental(int carId){
        if (rentalCount<10){
            rentalHistory[rentalCount] = carId;
            rentalCount++;
            System.out.println("Rental added successfully");
        }
        else{
            System.out.println("Rental history is full, cannot add more rentals");
        }
    }
    void printCustomerInfo(){
        System.out.println("=== Customer Info ===");
        System.out.println("ID: " + customerId+ " Name: " + name + " License: " + licenseNum);
        System.out.print("Rental History: ");
        for (int i=0; i<rentalCount; i++){
            System.out.print(rentalHistory[i] + " ");
        }
        System.out.println(); // Print a new line after the rental history
        System.out.println("Rental Count: " + rentalCount);
    }
}
