package com.company;

public class Mechanic {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type + " mechanic";
    }

    private String name;
    private String type;

    public Car repair(Car carToBeRepaired, Mechanic mechanicToRepairCar) {

        if (!carToBeRepaired.getStatus().equals("Good") && !carToBeRepaired.getStatus().equals("good")) {
            if (mechanicToRepairCar.getType().equals("LC mechanic") && carToBeRepaired.classification().equals("Light Car")) {
                carToBeRepaired.setStatus("Good");
                if (carToBeRepaired.getQualityValue() > 0.0) {
                    carToBeRepaired.setQualityValue(carToBeRepaired.getQualityValue() - 0.1);
                }
                System.out.println(
                        "Car " + carToBeRepaired.getRgn()
                                + " was successfully repaired by "
                                + mechanicToRepairCar.getName() + "."
                                + carToBeRepaired.getRgn() + " quality is "
                                + carToBeRepaired.getQualityValue() + ".");
            }
            if (mechanicToRepairCar.getType().equals("MC mechanic") && carToBeRepaired.classification().equals("Medium Car")) {
                carToBeRepaired.setStatus("Good");
                if (carToBeRepaired.getQualityValue() > 0.0) {
                    carToBeRepaired.setQualityValue(carToBeRepaired.getQualityValue() - 0.1);
                }
                System.out.println(
                        "Car " + carToBeRepaired.getRgn()
                                + " was successfully repaired by "
                                + mechanicToRepairCar.getName() + "."
                                + carToBeRepaired.getRgn() + " quality is "
                                + carToBeRepaired.getQualityValue() + ".");
            }
            if (mechanicToRepairCar.getType().equals("HC mechanic") && carToBeRepaired.classification().equals("Heavy Car")) {
                carToBeRepaired.setStatus("Good");
                if (carToBeRepaired.getQualityValue() > 0.0) {
                    carToBeRepaired.setQualityValue(carToBeRepaired.getQualityValue() - 0.1);
                }
                System.out.println(
                        "Car " + carToBeRepaired.getRgn()
                                + " was successfully repaired by "
                                + mechanicToRepairCar.getName() + "."
                                + carToBeRepaired.getRgn() + " quality is "
                                + carToBeRepaired.getQualityValue() + ".");
            }
            if (!mechanicToRepairCar.getType().equals("LC mechanic") && !mechanicToRepairCar.getType().equals("MC mechanic") && !mechanicToRepairCar.getType().equals("HC mechanic")) {
                System.out.println(mechanicToRepairCar.getName()
                        + " could not repair "
                        + carToBeRepaired.getRgn() + ".");
            }


        } else {
            System.out.println("Car " + carToBeRepaired.getRgn() + "status is good and does not need repair");
        }

        return carToBeRepaired;
    }
}
