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
    }
}