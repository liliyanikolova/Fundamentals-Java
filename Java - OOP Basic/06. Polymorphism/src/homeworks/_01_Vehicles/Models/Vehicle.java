package homeworks._01_Vehicles.Models;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionInLitersPerKm;
    private double travelledDistance;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity,
                      double fuelConsumptionInLitersPerKm,
                      double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm ;
        this.tankCapacity = tankCapacity;
        this.travelledDistance = 0;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (!this.getClass().getSimpleName().equals("Truck")) {
            if (fuelQuantity >= this.getTankCapacity()) {
                throw new IllegalArgumentException("Cannot fit fuel in tank");
            }

            if (fuelQuantity < 0) {
                throw new IllegalArgumentException("Fuel must be a positive number");
            }
        }

        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionInLitersPerKm() {
        return fuelConsumptionInLitersPerKm;
    }

    protected void setFuelConsumptionInLitersPerKm(double fuelConsumptionInLitersPerKm) {
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
    }

    public double getTravelledDistance() {
        return travelledDistance;
    }

    protected void setTravelledDistance(double travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    protected void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public boolean canDriveDistance(double distance, double additionalACCots) {
        double neededFuelToDrive = (this.fuelConsumptionInLitersPerKm + additionalACCots) * distance;
        if (neededFuelToDrive > this.fuelQuantity) {
            return false;
        }

        this.setFuelQuantity(this.getFuelQuantity() - neededFuelToDrive);
        this.travelledDistance += distance;
        return true;
    }

    public void refuelLiters(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }
}

