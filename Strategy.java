// Step 1: Define the Strategy Interface
interface TravelStrategy {
    double calculateTravelTime(double distance);
}

// Step 2: Implement Concrete Strategies

// Car Travel Strategy
class CarTravelStrategy implements TravelStrategy {
    @Override
    public double calculateTravelTime(double distance) {
        double speed = 60.0; // average speed in km/h
        return distance / speed;
    }
}

// Bike Travel Strategy
class BikeTravelStrategy implements TravelStrategy {
    @Override
    public double calculateTravelTime(double distance) {
        double speed = 15.0; // average speed in km/h
        return distance / speed;
    }
}

// Walking Travel Strategy
class WalkingTravelStrategy implements TravelStrategy {
    @Override
    public double calculateTravelTime(double distance) {
        double speed = 5.0; // average speed in km/h
        return distance / speed;
    }
}

// Step 3: Context Class (TravelContext)
class TravelContext {
    private TravelStrategy travelStrategy;

    public TravelContext(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void setTravelStrategy(TravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public double calculateTime(double distance) {
        return travelStrategy.calculateTravelTime(distance);
    }
}

// Step 4: Testing the Strategy Pattern
public class Strategy {
    public static void main(String[] args) {
        double distance = 120.0; // distance in kilometers

        // Using Car Travel Strategy
        TravelContext travelContext = new TravelContext(new CarTravelStrategy());
        System.out.println("Travel time by car: " + travelContext.calculateTime(distance) + " hours");

        // Switching to Bike Travel Strategy
        travelContext.setTravelStrategy(new BikeTravelStrategy());
        System.out.println("Travel time by bike: " + travelContext.calculateTime(distance) + " hours");

        // Switching to Walking Travel Strategy
        travelContext.setTravelStrategy(new WalkingTravelStrategy());
        System.out.println("Travel time by walking: " + travelContext.calculateTime(distance) + " hours");
    }
}
