package com.carental;

class Car {
    int carId; //unique identifier 
    String brand; // e.g Toyota
    String model; // e.g Camry
    int year; // manufacturing year
    double dailyRate; // rental cost per day
    boolean isAvailable; // true if avaiable for rent
    int mileage; // total km driven
    Car(int carId, String brand, String model, int year, double dailyRate) {
    this.carId = carId;
    this.brand = brand;
    this.model = model;
    this.year = year;
    this.dailyRate = dailyRate;

    this.isAvailable = true;
    this.mileage = 0;
}
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
    double calculateRentalCost(int days, boolean withInsurance){
        double totalCost = days * dailyRate;
        if (withInsurance){
            totalCost *= 1.15; //add 15% for insurance
        }
        return totalCost;
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
