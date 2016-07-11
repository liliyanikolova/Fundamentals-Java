package homeworks._01_Vehicles.Models;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER_FUEL_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    public boolean canDriveDistance(double distance) {
        return super.canDriveDistance(distance, AIR_CONDITIONER_FUEL_CONSUMPTION);
    }
}
