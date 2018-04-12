package hr.altima.tunnel;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lovro on 11/04/2018.
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
        DrivingModuleTunnelOne driving_module = new DrivingModuleTunnelOne();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(1, driving_module);
        assertEquals(position, Position.END);
    }

    @Test
    public void testDriveFromStartToEndInTunnelOneWithObstruction(){
        DrivingModuleTunnelOneObstruction driving_module = new DrivingModuleTunnelOneObstruction();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(1, driving_module);
        assertEquals(position, Position.START);
    }

    @Test
    public void testDriveFromStartToEndInTunnelTwo(){
        DrivingModuleTunnelTwo driving_module = new DrivingModuleTunnelTwo();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(2, driving_module);
        assertEquals(position, Position.END);
    }

    @Test
    public void testDriveFromStartToEndInTunnelTwoObstruction(){
        DrivingModuleTunnelTwoObstruction driving_module = new DrivingModuleTunnelTwoObstruction();
        DrivingEngine engine = new DrivingEngine(tunnels);
        Position position = engine.driveFromStartToEnd(2, driving_module);
        assertEquals(position, Position.START);
    }
}