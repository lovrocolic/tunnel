package hr.altima.tunnel;

import java.util.Map;

/**
 * Represents Engine for driving through tunnels
 */
public class DrivingEngine {

    /**
     * Map contains implementations for navigation in each tunnel
     */
    private Map<Integer, Tunnel> tunnels;

    public DrivingEngine(Map<Integer, Tunnel> tunnels){
        this.tunnels = tunnels;
    }

    /**
     * Finds suitable implementation for driving based on tunnelNumber parameter.
     * If tunnelNumber is invalid throws exception, otherwise navigates and returns last position.
     * @return end position
     */
    public Position driveFromStartToEnd(int tunnelNumber, DrivingModule drivingModule){
        Tunnel tunnel = tunnels.get(tunnelNumber);

        if(tunnel == null){
            throw new IllegalArgumentException();
        }else{
            Position endPosition = tunnel.navigate(drivingModule);
            return endPosition;
        }
    }
}
