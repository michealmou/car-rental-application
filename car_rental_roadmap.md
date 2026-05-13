# Car Rental Management — Java Project Roadmap
**Assignment 20 | Michael B. M. Musallam | Student ID: 22900177**

---

## Phase 1 — Set up & build `Car` class (~1 hr)

- Create a new Java project (e.g. `CarRentalApp`) with a `main` class and a package structure.
- Define `Car` with fields: `carId`, `brand`, `model`, `year`, `dailyRate`, `isAvailable`, `mileage`.
- Add `rent()` — sets `isAvailable = false`.
- Add `returnCar(int kmDriven)` — sets `isAvailable = true`, adds km to mileage.
- Add `calculateRentalCost(int days, boolean withInsurance)` — base cost = `days × dailyRate`; insurance adds 15%.
- Add `printCarInfo()` — prints all fields in a neat format.

> **Tip:** Test in `main()` immediately — create 1 car, rent it, return it, print info.

---

## Phase 2 — Build `Customer` class (~45 min)

- Define `Customer` with fields: `customerId`, `name`, `licenseNum`, `rentalHistory[]` (int array, max 10).
- Add a private `rentalCount` field to track how many rentals have been added.
- Add `addRental(int carId)` — appends carId to `rentalHistory`, respecting the max-10 limit.
- Add `printCustomerProfile()` — prints customer info and all rental history IDs.

> **Tip:** Use `rentalCount` as the index when inserting into the array, and check `if (rentalCount < 10)` before adding.

---

## Phase 3 — Build `Rental` class (~1 hr)

- Define `Rental` with fields: `rentalId`, `car` (Car), `customer` (Customer), `startDay`, `endDay`, `withInsurance`.
- Add `getDuration()` — returns `endDay - startDay`.
- Add `getTotalCost()` — calls `car.calculateRentalCost(getDuration(), withInsurance)`.
- Add `printRentalAgreement()` — prints car info, customer name, dates, insurance status, and total cost.

---

## Phase 4 — Build `RentalAgency` class (~1.5 hr)

- Define arrays: `Car[] cars`, `Customer[] customers`, `Rental[] rentals`, each with a size counter.
- Add `addCar()` and `registerCustomer()` — append to their respective arrays.
- Add `rentCar(int customerId, int carId, int startDay, int endDay, boolean insurance)`:
  - Check `car.isAvailable` first — if not, print an error and return.
  - Create a new `Rental`, call `car.rent()`, call `customer.addRental(carId)`.
- Add `returnCar(int rentalId, int kmDriven)`:
  - Find the rental by looping through `rentals[]` and matching `rentalId`.
  - Call `rental.car.returnCar(kmDriven)`.
  - Add `rental.getTotalCost()` to a running `totalRevenue` double.
- Add `printFleetReport()` — list all cars with availability status and mileage.
- Add `printFinancialSummary()` — show total revenue and count of completed rentals.

> **Tip (from spec hint):** `returnCar` chain = find Rental by rentalId → get Car → `car.returnCar(kmDriven)` → add `getTotalCost()` to revenue.

```java
// Example: finding a rental by ID (no ArrayList, plain loop)
for (int i = 0; i < rentalCount; i++) {
    if (rentals[i].getRentalId() == rentalId) {
        // do the return logic here
    }
}
```

---

## Phase 5 — Wire up `main()` & test (~30 min)

- Create a `RentalAgency` instance.
- Add 5 cars with different brands, rates, and years.
- Register 3 customers with different names and license numbers.
- Create 4 rentals — mix of with/without insurance, different durations.
- Return 2 cars with mileage — verify they become available again.
- Call `printFleetReport()` and `printFinancialSummary()` — check the output looks right.

> **Tip:** Try to rent an already-rented car — verify it's blocked with an appropriate message.

---

## Class Dependency Order

```
Car  →  Customer  →  Rental  →  RentalAgency  →  main()
```

Build and test each class before moving to the next one.
