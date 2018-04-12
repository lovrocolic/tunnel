package hr.altima.tunnel;

import java.util.*;

/**
 * Tunnel implementation for tunnel one
 */
public class FirstTunnel implements Tunnel{
    private Position position;
    private boolean obstruction;
    private List<Direction> route = new ArrayList<>();

    /**
     * Sets position to START by default and obstruction to false
     */
    public FirstTunnel(){
        this.position = Position.START;
        this.obstruction = false;
    }

    /**
     * Takes drivingModule and navigates through tunnel one
     * @return last position
     */
    public Position navigate(DrivingModule drivingModule){
        while(true) {
            if(obstruction){
                navigateBack(drivingModule);
                return position;
            }
            navigateDown(drivingModule);

            if(position == Position.END) {
                route.add(Direction.DOWN);
                return position;
            }else{
                navigateRight(drivingModule);
            }
        }
    }

    /**
     * Takes drivingModule and drives down as long as possible
     * Changes position state
     */
    private void navigateDown(DrivingModule drivingModule){
        position = drivingModule.go(Direction.DOWN);
        if(position == Position.NORMAL_UNCHANGED){
            obstruction = true;
            return;
        }

        while(position == Position.NORMAL){
           route.add(Direction.DOWN);
           position = drivingModule.go(Direction.DOWN);
        }
    }

    /**
     * Takes drivingModule and drives right as long as possible
     * Changes position state
     */
    private void navigateRight(DrivingModule drivingModule){
        position = drivingModule.go(Direction.RIGHT);
        if(position == Position.NORMAL_UNCHANGED){
            obstruction = true;
            return;
        }

        while(position == Position.NORMAL){
            route.add(Direction.RIGHT);
            position = drivingModule.go(Direction.RIGHT);
        }
    }

    /**
     * Takes drivingModule and navigates back through tunnel if obstruction occured.
     * Logic is based on direction sequence from S to obstruction
     * Changes position state
     */
    private void navigateBack(DrivingModule drivingModule){
        Map<Direction, Direction> directionMapping = new HashMap<>();
        directionMapping.put(Direction.DOWN, Direction.UP);
        directionMapping.put(Direction.RIGHT, Direction.LEFT);
        Collections.reverse(route);
        for (Direction direction : route){
            position = drivingModule.go(directionMapping.get(direction));
        }
    }
}
