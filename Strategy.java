interface Travel {
    double calculateTravelTime(double distance);
}

class CarTravel implements Travel {
    public double calculateTravelTime(double distance) {
        double speed = 60.0; //km/h
        return distance / speed;
    }
}

class BikeTravel implements Travel {
    public double calculateTravelTime(double distance) {
        double speed = 15.0;  //h
        return distance / speed;
    }
}
class WalkingTravel implements Travel {
    public double calculateTravelTime(double distance) {
        double speed = 5.0;  //h
        return distance / speed;
    }
}
class TravelContext {
    private Travel travel;

    public TravelContext(Travel travel) {
        this.travel = travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public double calculateTime(double distance) {
        return travel.calculateTravelTime(distance);
    }
}
public class Strategy{
    public static void main(String[] args) {
        double distance = 120.0; //km

        TravelContext travelContext = new TravelContext(new CarTravel());
        System.out.println("Travel time by car: " + travelContext.calculateTime(distance) + " hours");

        travelContext.setTravel(new BikeTravel());
        System.out.println("Travel time by bike: " + travelContext.calculateTime(distance) + " hours");

        travelContext.setTravel(new WalkingTravel());
        System.out.println("Travel time by walking: " + travelContext.calculateTime(distance) + " hours");
    }
}
