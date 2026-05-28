package com.carental;

class Rental {
    int rentalId; // unique identifier
    Car car; // the car being rented
    Customer customer; // the customer renting the car
    int startDay; // rental start day
    int endDay; // rental end day
    boolean withInsurance; // true if insurance is included
    Rental(int rentalId, Car car, Customer customer, int startDay, int endDay, boolean withInsurance){
        this.rentalId = rentalId;
        this.car = car;
        this.customer = customer;
        this.startDay = startDay;
        this.endDay = endDay;
        this.withInsurance = withInsurance;
    }
    Car getCar(){
        return car;
    }
    public int getDuration(){
        return endDay - startDay;
    }
    public double getTotalCost(){
        return car.calculateRentalCost(getDuration(), withInsurance);
    }
    void printRentalAgreement(){
        System.out.println("=== Rental Agreement ===");
        System.out.println("Rental ID: " + rentalId);
        System.out.println("Customer: " + customer.name);
        System.out.println("Car: " + car.brand + " " + car.model);
        System.out.println("Duration: " + getDuration() + " days");
        System.out.println("With Insurance: " + withInsurance);
    }
}
