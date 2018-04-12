package hr.altima.tunnel;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Main class
 * By default it works with DrivingModuleTunnelOne or DrivingModuleTunnelTwo implementations
 * It prints last position in tunnel
 * User has to select tunnel
 */
public class Main {
    public static void main(String[] args){
        Map<Integer, Tunnel> tunnels = new HashMap<>();
        tunnels.put(1, new FirstTunnel());
        tunnels.put(2, new SecondTunnel());

        Scanner scanner = new Scanner(System.in);
        System.out.print("You should select in which tunnel do you want to move programming robot vehicle module. " +
                         "Please enter 1 or 2: ");

        try{
            int tunnelNumber = scanner.nextInt();
            DrivingEngine drivingEngine = new DrivingEngine(tunnels);
            DrivingModule drivingModule;
            if(tunnelNumber == 1){
                drivingModule = new DrivingModuleTunnelOne();
            }else{
                drivingModule = new DrivingModuleTunnelTwo();
            }
            Position position = drivingEngine.driveFromStartToEnd(tunnelNumber, drivingModule);
            System.out.println("Your last position is: " + position);
        }catch(IllegalArgumentException | java.util.InputMismatchException e){
            printError();
        }

        scanner.close();
    }

    private static void printError(){
        System.out.println("Input is invalid, tunnel number can be 1 or 2.");
    }
}
