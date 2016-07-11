package homeworks._01_Vehicles.Models;

public class Bus extends Vehicle{
    private static final double AIR_CONDITIONER_FUEL_CONSUMPTION = 1.4;


    public Bus(double fuelQuantity, double fuelConsumptionInLitersPerKm, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    public boolean canDriveDistance(double distance) {
        return super.canDriveDistance(distance, AIR_CONDITIONER_FUEL_CONSUMPTION);
    }

    public boolean canDriveDistanceEmpty(double distance) {
        return super.canDriveDistance(distance, 0);
    }
}
