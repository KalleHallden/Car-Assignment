package com.company;


public class Car {

    public String getRgn() {
        return regNum;
    }

    public void setRgn(String regNum) {
        this.regNum = regNum;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getGasMeter() {
        return gasMeter;
    }

    public void setGasMeter(double gasMeter) {
        this.gasMeter = gasMeter;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public double getQualityValue() {
        return qualityValue;
    }

    public void setQualityValue(double qualityValue) {
        this.qualityValue = qualityValue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String regNum;
    int modelYear;
    double weight;
    double price;
    double gasMeter;
    double mileage;
    double qualityValue;
    String status;

    public Car() {

    }

    /*
    This part was made when Emanuel made the first task and upon completion we wanted to keep this ->
    to show that the program can hold preregistered cars if the customer would like that.
     */

    public Car(String regNum, int modelYear, double weight, double price, double gasMeter, double mileage, double qualityValue, String status) {
        this.regNum = regNum;
        this.modelYear = modelYear;
        this.weight = weight;
        this.price = price;
        this.gasMeter = gasMeter;
        this.mileage = mileage;
        this.qualityValue = qualityValue;
        this.status = status;
    }

    public double calcGasMeter(double gasMeter) {

        double GallonToLiter = gasMeter * 3.78; //gallon that the tank holds converted in to litres

        return GallonToLiter;
    }

    public double calMileage(double mileage) {

        double calMileage = mileage * 1.6; //miles driven converted into km

        return calMileage;

    }

    public String classification() {

        if (weight <= 1600) {

            String classification = "Light Car";

            return classification;
        } else if ((weight > 1600) && (weight < 2300)) {

            String classification = "Medium Car";

            return classification;

        } else {

            String classification = "Heavy Car";

            return classification;

        }
    }

    public Car drive(double testDriveLength, Car carToBeDriven) {

        if (testDriveLength < 0) {
            System.out.println("Error when driving car " + regNum + "." + " Miles cannot be negative");
            return carToBeDriven;

        }
        if (carToBeDriven.getGasMeter() - (0.04 * testDriveLength) >= 0) {
            carToBeDriven.setMileage(carToBeDriven.mileage + testDriveLength);
            carToBeDriven.setGasMeter(carToBeDriven.getGasMeter() - (0.04 * testDriveLength));

            System.out.println(carToBeDriven.getRgn() + " new gas level is " + carToBeDriven.getGasMeter());

            return carToBeDriven;
        } else {

            System.out.println("Error when driving car " + regNum + "." + " Gas tank is empty");
            carToBeDriven.setGasMeter(0);
            return carToBeDriven;
        }

    }

    public Car fillGas(Double refillGas, Car carToBeFilled) {

        if ((refillGas + carToBeFilled.getGasMeter()) > 10) {
            System.out.println("Error when filling car " + carToBeFilled.getRgn() + " with gas. Gas tank is full.");
            carToBeFilled.setGasMeter(10);
        }
        if (refillGas < 0) {
            System.out.println("Error when filling car " + carToBeFilled.getRgn() + " with gas. Amount of gallons cannot be negative.");
        } else if ((refillGas + carToBeFilled.getGasMeter()) < 10) {
            carToBeFilled.setGasMeter(carToBeFilled.getGasMeter() + refillGas);
            System.out.println(carToBeFilled.getRgn() + " new gas level is " + carToBeFilled.getGasMeter());
        }
        return carToBeFilled;
    }

    public void printCar() {

        String newLine = System.getProperty("line.separator");

        System.out.println(regNum + ": " + classification() + newLine
                + "Model Year: " + modelYear + newLine
                + "Weight: " + weight + "kg" + newLine
                + "Price: " + price + "kr" + newLine
                + "Gas Level: " + gasMeter + " Gallons " + calcGasMeter(gasMeter) + " Litres" + newLine
                + "Mileage: " + mileage + " Miles " + calMileage(mileage) + " km" + newLine
                + "Quality Value: " + qualityValue + newLine
                + "Status: " + status);
    }

}
