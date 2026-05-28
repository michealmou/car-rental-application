package com.carental;

class RentalAgency{
    Car[] cars = new Car[100]; // array of cars in the agency
    Customer[] customers = new Customer[100]; // array of customers
    Rental[] rentals = new Rental[100]; // array of active rentals
    int carCount = 0;
    int customerCount = 0;
    int rentalCount = 0;
    double totalRevenue = 0.0; // total revenue from rentals
    void addCar(int carId, String brand, String model, int year, double dailyRate){
        cars[carCount] = new Car(carId, brand, model, year, dailyRate);
        carCount++;
    }
    void registerCustomer(int customerId, String name, String licenseNum){
        customers[customerCount] = new Customer(customerId, name, licenseNum);
        customerCount++;
    }
    void rentCar(int customerId, int carId, int startDay, int endDay, boolean withInsurance){
        // Find customer by customerId (do not use customerId as array index)
        Customer cust = null;
        for (int j = 0; j < customerCount; j++){
            if (customers[j].customerId == customerId){
                cust = customers[j];
                break;
            }
        }
        if (cust == null) {
            System.out.println("Customer not found: " + customerId);
            return;
        }

        // Find the car by carId and create rental if available
        for (int i = 0; i < carCount; i++){
            if (cars[i].carId == carId){
                if (!cars[i].isAvailable){
                    System.out.println("Car is already rented");
                    return;
                }
                Rental rental = new Rental(rentalCount, cars[i], cust, startDay, endDay, withInsurance);
                cars[i].rent();
                cust.addRental(carId);
                rentals[rentalCount] = rental;
                rentalCount++;
                return;
            }
        }
        System.out.println("Car with ID " + carId + " not found");
    }
    void returnCar(int rentalId, int kmDriven){
        for (int i = 0; i<rentalCount; i++){
            if (rentals[i] == null) continue;
            if (rentals[i].rentalId == rentalId){
                rentals[i].getCar().returnCar(kmDriven);
                totalRevenue += rentals[i].getTotalCost();
                System.out.println("Car returned. Revenue: $" + rentals[i].getTotalCost());
                rentals[i] = null; // remove rental from active rentals
                return;
            }
        }
    }
    void printFleetReport(){
        System.out.println("=== Fleet Report ===");
        for (int i = 0; i < carCount; i++){
            cars[i].printCarInfo();
            System.out.println();
        }
    }
    void printFianancialSummary(){
        System.out.println("=== Financial Summary ===");
        System.out.println("Total Revenue: $" + totalRevenue);
        double averageRevenue = 0;
        if (rentalCount > 0) {
            averageRevenue = totalRevenue / rentalCount;
        }
        System.out.println("Average revenue per rental: $" + averageRevenue);
    } 
}
