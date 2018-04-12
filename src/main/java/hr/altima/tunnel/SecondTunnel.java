package hr.altima.tunnel;

import java.util.*;

/**
 * Tunnel implementation for tunnel two
 */
public class SecondTunnel implements Tunnel{
    private Position position;
    private List<Direction> route = new ArrayList<>();

    /**
     * Sets position to START by default
     */
    public SecondTunnel(){
        this.position = Position.START;
    }

    /**
     * Takes drivingModule and navigates through tunnel two
     * @return last position
     */
    public Position navigate(DrivingModule drivingModule){
        firstMovement(drivingModule);

        while(true) {
            int route_count = route.size();

            if((position != Position.END) && (route.get(route.size() - 1) != Direction.RIGHT)){
                navigateLeft(drivingModule);
            }

            if((position != Position.END) && (route.get(route.size() - 1) != Direction.UP)){
                navigateDown(drivingModule);
            }

            if((position != Position.END) && (route.get(route.size() - 1) != Direction.LEFT)){
                navigateRight(drivingModule);
            }

            if((position != Position.END) && (route.get(route.size() - 1) != Direction.DOWN)){
                navigateUp(drivingModule);
            }

            if(position == Position.END){
                return position;
            }

            if(route_count == route.size()){
                navigateBack(drivingModule);
                return position;
            }
        }
    }

    /**
     * Takes drivingModule and drives down as long as possible
     * Changes position state
     */
    private void navigateDown(DrivingModule drivingModule){
        position = drivingModule.go(Direction.DOWN);

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

        while(position == Position.NORMAL){
            route.add(Direction.RIGHT);
            position = drivingModule.go(Direction.RIGHT);
        }
    }

    /**
     * Takes drivingModule and drives left as long as possible
     * Changes position state
     */
    private void navigateLeft(DrivingModule drivingModule){
        position = drivingModule.go(Direction.LEFT);

        while(position == Position.NORMAL){
            route.add(Direction.LEFT);
            position = drivingModule.go(Direction.LEFT);
        }
    }

    /**
     * Takes drivingModule and drives up as long as possible
     * Changes position state
     */
    private void navigateUp(DrivingModule drivingModule){
        position = drivingModule.go(Direction.UP);

        while(position == Position.NORMAL){
            route.add(Direction.UP);
            position = drivingModule.go(Direction.UP);
        }
    }

    /**
     * Takes drivingModule and makes first movement
     * Writes to route list right direction
     */
    private void firstMovement(DrivingModule drivingModule){
        Position p;

        p = drivingModule.go(Direction.LEFT);
        if(p == Position.NORMAL){
            route.add(Direction.LEFT);
            return;
        }
        p = drivingModule.go(Direction.RIGHT);
        if(p == Position.NORMAL){
            route.add(Direction.RIGHT);
            return;
        }
        p = drivingModule.go(Direction.UP);
        if(p == Position.NORMAL){
            route.add(Direction.UP);
            return;
        }
        p = drivingModule.go(Direction.DOWN);
        if(p == Position.NORMAL){
            route.add(Direction.DOWN);
        }
    }

    /**
     * Takes drivingModule and drives back if obstruction occured
     * Right direction sequence is calculated from S to obstruction route
     * Changes position state
     */
    private void navigateBack(DrivingModule drivingModule){
        Map<Direction, Direction> directionMapping = new HashMap<>();
        directionMapping.put(Direction.DOWN, Direction.UP);
        directionMapping.put(Direction.RIGHT, Direction.LEFT);
        directionMapping.put(Direction.LEFT, Direction.RIGHT);
        directionMapping.put(Direction.UP, Direction.DOWN);
        Collections.reverse(route);
        for (Direction direction : route){
            position = drivingModule.go(directionMapping.get(direction));
        }
    }
}
