package hr.altima.tunnel;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Testing DrivingEngine
 */
public class DrivingEngineTest {
    private Map<Integer, Tunnel> tunnels = new HashMap<>();

    @Before
    public void setUp(){
        tunnels.put(1, new FirstTunnel());
        tunnels.put(2, new SecondTunnel());
    }

    @Test
    public void testDriveFromStartToEndInTunnelOne(){
        DrivingModuleTunnelOne drivingModule = new DrivingModuleTunnelOne();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(1, drivingModule);
        assertEquals(position, Position.END);
    }

    @Test
    public void testDriveFromStartToEndInTunnelOneWithObstruction(){
        DrivingModuleTunnelOneObstruction drivingModule = new DrivingModuleTunnelOneObstruction();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(1, drivingModule);
        assertEquals(position, Position.START);
    }

    @Test
    public void testDriveFromStartToEndInTunnelTwo(){
        DrivingModuleTunnelTwo drivingModule = new DrivingModuleTunnelTwo();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(2, drivingModule);
        assertEquals(position, Position.END);
    }

    @Test
    public void testDriveFromStartToEndInTunnelTwoObstruction(){
        DrivingModuleTunnelTwoObstruction drivingModule = new DrivingModuleTunnelTwoObstruction();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(2, drivingModule);
        assertEquals(position, Position.START);
    }
}