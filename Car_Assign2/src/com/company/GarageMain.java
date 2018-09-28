package com.company;

//you may need to change the package to match your project's package.

import java.util.Scanner;

public class GarageMain {

    private static final int REGISTER_CAR = 1;
    private static final int PRINT_CARS = 2;
    private static final int PRINT_CAR = 3;
    private static final int PRINT_CHEAPEST_CAR = 4;
    private static final int DRIVE_CAR = 5;
    private static final int FILL_GAS = 6;
    private static final int REGISTER_MACHANIC = 7;
    private static final int REPAIR_CAR = 8;
    private static final int QUIT = 9;
    private static final int EDIT_CAR_INFORMATION = 10;

    private Car[] cars;
    private Mechanic[] mechanics;
    private int registeredCars;
    private int registeredMechanics;

    private Scanner input;


    public GarageMain() {
        final int MAX_CARS = 5;
        this.cars = new Car[MAX_CARS];
        this.registeredCars = 0;
        final int MAX_MECHANICS = 5;
        this.mechanics = new Mechanic[MAX_MECHANICS];
        this.registeredMechanics = 0;
        input = new Scanner(System.in);
    }


    public Car retrieveCar(String carRgn) {
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null && cars[i].getRgn().equals(carRgn)) {
                return cars[i];
            }
        }

        return null;
    }

    public Mechanic retrieveMechanic(String mechName) {
        for (int i = 0; i < mechanics.length; i++) {
            if (mechanics[i] != null && mechanics[i].getName().equals(mechName)) {
                return mechanics[i];
            }
        }

        return null;
    }


    public Car createCar() {
        System.out.println("================================================");

        Car returnCar = new Car();
        System.out.println(" Type in registration number: ");

        for (int i = 0; i < 8; i++) {
            String text = input.next();
            input.nextLine();


            if (i == 0) {
                returnCar.setRgn(text);
                System.out.println(" Type in model year: ");
            }
            if (i == 1) {
                returnCar.setModelYear(Integer.parseInt(text));
                System.out.println(" Type in model weight: ");
            }
            if (i == 2) {
                returnCar.setWeight(Double.parseDouble(text));
                System.out.println(" Type in model price: ");
            }
            if (i == 3) {
                returnCar.setPrice(Double.parseDouble(text));
                System.out.println(" Type in model gas meter: ");
            }
            if (i == 4) {
                returnCar.setGasMeter(Double.parseDouble(text));
                System.out.println(" Type in model mileage: ");
            }
            if (i == 5) {
                returnCar.setMileage(Double.parseDouble(text));
                System.out.println(" Type in model quality value: ");
            }
            if (i == 6) {
                returnCar.setQualityValue(Double.parseDouble(text));
                System.out.println(" Type in model status: ");
            }
            if (i == 7) {
                returnCar.setStatus(text);
            }
        }

        return returnCar;
    }

    public Mechanic createMechanic() {


        System.out.println("================================================");

        Mechanic returnMech = new Mechanic();
        System.out.println(" Type in Mechanic name: ");

        for (int i = 0; i < 2; i++) {
            String text = input.next();
            input.nextLine();

            if (i == 0) {
                returnMech.setName(text);
                System.out.println(" Type in mechanic type: ");
            }
            if (i == 1) {
                returnMech.setType(text);
            }

        }
        return returnMech;
    }

    public void run() {

        int option;
        do {
            printMenuOptions();
            System.out.print(" Type the option number: ");

            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case REGISTER_CAR:

                    if (registeredCars != 5) {
                        Car newCar = createCar();
                        this.cars[registeredCars] = newCar;
                        this.registeredCars = this.registeredCars + 1;
                    } else {
                        System.out.println("================================================");
                        System.out.println("You have already registered 5 cars.");
                        System.out.println("================================================");
                    }

                    break;

                case PRINT_CARS:
                    printAllCars();
                    break;

                case PRINT_CAR:
                    printOneCar();
                    break;

                case PRINT_CHEAPEST_CAR:
                    printCheapest();
                    break;

                case DRIVE_CAR:
                    drive();
                    break;

                case FILL_GAS:
                    fillGas();
                    break;

                case REGISTER_MACHANIC:
                    Mechanic newMec = createMechanic();
                    this.mechanics[registeredMechanics] = newMec;
                    this.registeredMechanics = this.registeredMechanics + 1;

                    break;

                case REPAIR_CAR:
                    repairCar();
                    break;

                case QUIT:
                    System.out.println("Thank you for visiting our Garage. See you soon!");
                    System.out.println();
                    break;

                case EDIT_CAR_INFORMATION:
                    editCarInformation();
                    break;

                default:
                    System.out.println("Option " + option + " is not valid.");
                    System.out.println();
                    break;
            }
        } while (option != QUIT);
    }


    private void printMenuOptions() {
        System.out.println(" === Welcome to DIT042 Garage === ");
        System.out.println(" Choose an option below: ");
        System.out.println(" ");
        System.out.println(" 1. Register a car. ");
        System.out.println(" 2. Print all cars. ");
        System.out.println(" 3. Print a car's information. ");
        System.out.println(" 4. Print the cheapest car's information. ");
        System.out.println(" 5. Test-drive a car ");
        System.out.println(" 6. Fill a car's gas tank ");
        System.out.println(" 7. Hire a mechanic ");
        System.out.println(" 8. Repair a car ");
        System.out.println(" 9. Quit this program. ");
        System.out.println(" 10. Edit car information. ");
        System.out.println();
    }

    public void printAllCars() {


        System.out.println("================================================");
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                cars[i].printCar();
                System.out.println("================================================");
            }
        }

    }

    public void printOneCar() {
        String carRgn = readCarRgn();
        System.out.println("================================================");
        Car foundCar = retrieveCar(carRgn);

        if (foundCar != null) {
            foundCar.printCar();
        } else {
            System.out.println("Error: " + carRgn + " is not registered.");
        }
        System.out.println("================================================");


    }

    public void printCheapest() {
        Double price = 0.0;
        Car foundCar = new Car();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] != null) {
                if (price == 0.0) {
                    price = cars[i].getPrice();
                }
                if (cars[i].getPrice() < price) {
                    price = cars[i].getPrice();
                    foundCar = cars[i];
                }
            }
        }
        System.out.println("================================================");
        if (foundCar != null) {
            foundCar.printCar();
        } else {
            System.out.println("Error: you seem to have no cars registered.");
        }

        System.out.println("================================================");


    }

    public String readCarRgn() {
        System.out.print("Type the registration number of the car that you want to use: ");
        String carRgn = input.nextLine();
        return carRgn;
    }

    public void drive() {
        String carRgn = readCarRgn();
        Car foundCar = retrieveCar(carRgn);
        System.out.println("================================================");
        System.out.println("How far will you drive the car?");

        if (foundCar != null) {
            String text = input.next();
            input.nextLine();
            foundCar.drive(Double.parseDouble(text), foundCar);
        } else {
            System.out.println("The distance you entered was not valid");
        }
        System.out.println("================================================");

    }

    public void fillGas() {

        String carRgn = readCarRgn();
        Car foundCar = retrieveCar(carRgn);

        System.out.println("================================================");
        System.out.println("How much would you like to fill up the car with?");

        if (foundCar != null) {
            String text = input.next();
            input.nextLine();
            foundCar.fillGas(Double.parseDouble(text), foundCar);
        } else {
            System.out.println("The amount you entered was not valid");
        }

        System.out.println("================================================");


    }

    public void repairCar() {
        String carRgn = readCarRgn();
        Car foundCar = retrieveCar(carRgn);
        Mechanic foundMech;

        System.out.println("================================================");
        System.out.println("What mechanic would you want to use?");

        if (foundCar != null) {
            String text = input.next();
            input.nextLine();

            foundMech = retrieveMechanic(text);
            foundMech.repair(foundCar, foundMech);

        } else {
            System.out.println("The mechanic you entered does not exist");
        }

        System.out.println("================================================");

    }

    public void editCarInformation() {

        String carRgn = readCarRgn();
        Car foundCar = retrieveCar(carRgn);
        int option = 3;

        if (foundCar != null) {
            do {

                System.out.println("================================================");
                System.out.println("1. Change " + carRgn + "'s registration number");
                System.out.println("2. Change " + carRgn + "'s price");
                System.out.println("3. Go back to main menu ");
                System.out.println("================================================");
                System.out.println();
                System.out.print(" Type the option number: ");
                System.out.println();

                option = input.nextInt();
                input.nextLine();

                switch (option) {

                    case 1:
                        System.out.println("Write the new registration number for the car '" + carRgn + "' ");
                        String newCarRgn = input.nextLine();
                        foundCar.setRgn(newCarRgn);
                        break;


                    case 2:
                        System.out.println("Write what price you would like change " + carRgn + " to: ");
                        double newPrice = input.nextInt();
                        foundCar.setPrice(newPrice);
                        break;

                    case 3:
                        System.out.println("================================================");
                        break;
                }

            } while (option != 3);

        } else {

            System.out.println("Error: " + carRgn + " is not registered.");
        }
    }

    public static void main(String[] args) {
        GarageMain program = new GarageMain();
        program.run();
    }
}
