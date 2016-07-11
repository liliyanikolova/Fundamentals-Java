package homeworks._01_Vehicles.Models;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER_FUEL_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    public boolean canDriveDistance(double distance) {
        return super.canDriveDistance(distance, AIR_CONDITIONER_FUEL_CONSUMPTION);
    }

    @Override
    public void refuelLiters(double liters) {
        super.refuelLiters(liters * 0.95);
    }
}
