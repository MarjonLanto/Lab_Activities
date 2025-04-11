import java.util.Scanner;
class Vehicle {

    private String brand;
    private int speed;
    private String fuelType;

    //Constructor
    public Vehicle(String brand, int speed, String fuelType) {
        this.brand = brand;
        this.speed = speed;
        this.fuelType = fuelType;
    }

    //Getter methods for brand, speed, and fuelType
    public String getBrand() {
        return brand;
    }
    
    public int getSpeed() {
        return speed;
    }

    public String getFuelType() {
        return fuelType;
    }

    //method to display info of vehicle
    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Fuel Type: " + fuelType);
    }

    public class TestVehicle { 

        public static void main(String[] args) { 
            Scanner s = new Scanner(System.in);

            // method to input the details for Car 
            System.out.println("-------------------------");
            System.out.println("Enter The Car Details:");
            System.out.print("Brand: "); 
            String carBrand = s.nextLine(); 
            System.out.print("Speed: "); 
            int carSpeed = s.nextInt(); 
            s.nextLine();  
            System.out.print("Fuel Type: "); 
            String carFuelType = s.nextLine(); 
            System.out.print("Number of Doors: "); 
            int numDoors = s.nextInt(); 
            s.nextLine(); 
            System.out.println("-------------------------");
            System.out.println("");

            //method to input the details for Motorcycle 
            System.out.println("-------------------------");
            System.out.println("Enter Motorcycle Details:"); 
            System.out.print("Brand: "); 
            String motorBrand = s.nextLine(); 
            System.out.print("Speed: "); 
            int motorSpeed = s.nextInt(); 
            s.nextLine();  
            System.out.print("Fuel Type: "); 
            String motorFuel = s.nextLine(); 
            System.out.print("Has Sidecar? (True/False): ");  
            boolean hasSidecar = s.nextBoolean(); 
            System.out.println("-------------------------");
            System.out.println("\n");

            Vehicle car = new Car(carBrand, carSpeed, carFuelType, numDoors); 
            Vehicle motorcycle = new Motorcycle(motorBrand, motorSpeed, motorFuel, hasSidecar); 
    
            //Displays the details of the car and motorcycle
            System.out.println("-------------------------");
            System.out.println("\nCar Details:"); 
            car.displayInfo(); 

            System.out.println(); 

            System.out.println("Motorcycle Details:");
            motorcycle.displayInfo(); 
            s.close(); 
            System.out.println("");
            System.out.println("-------------------------");
            
        }
    }
}

class Car extends Vehicle {
    private int numDoors;

    //Constructor
    public Car (String brand, int speed, String fuelType, int numDoors) {
        super(brand, speed, fuelType);
        this.numDoors = numDoors;
    }

    //getter method for numDoors
    public int getNumDoors() {
        return numDoors;
    }

    //Overriding displayInfo method to include numDoors
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numDoors);
    }
}

class Motorcycle extends Vehicle { 

    private boolean hasSidecar; 

    //Constructor
    public Motorcycle(String brand, int speed, String fuelType, boolean hasSidecar) { 
        super(brand, speed, fuelType); 
        this.hasSidecar = hasSidecar; 
    } 

    //overriding displayInfo method to include hasSidecar
    @Override 
    public void displayInfo() { 
        super.displayInfo(); 
        if (hasSidecar) { 
            System.out.println("This motorcycle has a sidecar."); 
        } else { 
            System.out.println("This motorcycle does not have a sidecar."); 
        }
    } 

} 

