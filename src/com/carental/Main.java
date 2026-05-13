package com.carental;
class  Car {
    int carId; //unique identifier 
    String brand; // e.g Toyota
    String model; // e.g Camry
    int year; // manufacturing year
    double dailyRate; // rental cost per day
    boolean isAvailable; // true if avaiable for rent
    int mileage; // total km driven

    void rent(){
        if(isAvailable){
            isAvailable = false;
            System.out.println("Car rented successfully");
        }
        else{
            System.out.println("Car is not available for rent");
        }
    }
    void returnCar(int kmDriven){
        mileage += kmDriven;
        isAvailable = true;
        System.out.println("Car returned successfully");
    }
    void CalculateRentalCost(int days, boolean withInsurance){
        double totalCost = days * dailyRate;
        if (withInsurance){
            totalCost *= 1.15; //add 15% for insurance
        }
        System.out.println("Total rental cost: " + totalCost);
    }
    void printCarInfo(){
        System.out.println("Car ID: " + carId);
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Daily Rate: " + dailyRate);
        System.out.println("Available: " + isAvailable);
        System.out.println("Mileage: " + mileage);
    }
}
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
public class Main {
    public static void main(String[] args){
        Car car1 = new Car();
        car1.carId = 1;
        car1.brand = "Toyota";
        car1.model = "Camry";
        car1.year = 2020;
        car1.dailyRate = 50.0;
        car1.isAvailable = true;
        car1.mileage = 15000;
        car1.printCarInfo();
        car1.rent();
        car1.CalculateRentalCost(5, true);
        car1.returnCar(300);
        car1.printCarInfo();
        Customer customer1 = new Customer(1, "John Doe", "DL123456");
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId);
        customer1.addRental(car1.carId); // This will show that rental history is full
        customer1.addRental(car1.carId); // This will show that rental history is full
        customer1.printCustomerInfo();
        Customer customer2 = new Customer(2, "Jane Smith", "DL654321");
        customer2.addRental(car1.carId);
        customer2.printCustomerInfo();
        Customer customer3 = new Customer(3, "Alice Johnson", "DL789012");
        customer3.addRental(car1.carId);
        customer3.printCustomerInfo();
    }
}