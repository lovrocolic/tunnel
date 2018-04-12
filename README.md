# Tunnel

## Project organisation

### Interfaces
- Project consists of following interfaces: DrivingModule and Tunnel
- DrivingModule interface has 4 implementations; for first tunnel drive from S to E (DrivingModuleTunnelOne), for first tunnel drive with obstruction (DrivingModuleTunnelOneObstruction); for second tunnel drive from S to E (DrivingModuleTunnelTwo) and for second tunnel drive with obstruction (DrivingModuleTunnelTwoObstruction)
- Tunnel interface has two implementations; for navigation in first tunnel (FirstTunnel) and navigation in second tunnel (SecondTunnel)

### Classes
- Project consists of following classes: Main, DrivingEngine, DrivingModuleTunnelOne, DrivingModuleTunnelTwo, DrivingModuleTunnelOneObstruction, DrivingModuleTunnelTwoObstruction, FirstTunnel and SecondTunnel
- DrivingEngine class has one method:
```
public Position driveFromStartToEnd(int tunnelNumber, DrivingModule drivingModule){
...
}
```
- Method named driveFromStartToEnd uses either FirstTunnel or SecondTunnel instance, based on tunnelNumber. FirstTunnel and SecondTunnel classes have one method:
```
public Position navigate(DrivingModule drivingModule){
...
}
```
- Method named navigate in FirstTunnel implementation works in a way that it assumes (based on image) that in first tunnel you can go just in direction down and right, and that first and last moves are down.
- Method named navigate in SecondTunnel implementation is more generic and can actually work in any tunnel.

## Running project

### Run main class
- in main class by default DrivingModule implementation is DrivingModuleTunnelOne (navigation in tunnel one from S to E) or DrivingModuleTunnelTwo (navigation in tunnel two from S to E) but it could be changed there to other implementations with obstruction.

## Testing
We're using JUnit as a testing framework.

### Running the test suite
```
mvn clean test
```

