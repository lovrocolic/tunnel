package hr.altima.tunnel;
import java.util.List;
import java.util.ArrayList;

/**
 * DrivingModule implementation for tunnel two with obstruction
 */
public class DrivingModuleTunnelTwoObstruction implements DrivingModule {

    private int index;
    private List<Direction> path = new ArrayList <> ();

    /**
     * Sets right sequence of directions for navigation from S to obstruction and returning back to S
     */
    public DrivingModuleTunnelTwoObstruction(){
        this.index = 0;
        path.add(Direction.DOWN);
        path.add(Direction.DOWN);
        path.add(Direction.DOWN);
        path.add(Direction.DOWN);
        path.add(Direction.DOWN);
        path.add(Direction.RIGHT);
        path.add(Direction.RIGHT);
        path.add(Direction.UP);
        path.add(Direction.UP);
        path.add(Direction.UP);
        path.add(Direction.RIGHT);
        path.add(Direction.RIGHT);
        path.add(Direction.DOWN);
        path.add(Direction.DOWN);
        path.add(Direction.UP);
        path.add(Direction.UP);
        path.add(Direction.LEFT);
        path.add(Direction.LEFT);
        path.add(Direction.DOWN);
        path.add(Direction.DOWN);
        path.add(Direction.DOWN);
        path.add(Direction.LEFT);
        path.add(Direction.LEFT);
        path.add(Direction.UP);
        path.add(Direction.UP);
        path.add(Direction.UP);
        path.add(Direction.UP);
        path.add(Direction.UP);
    }

    /**
     * Takes direction and returns position for given direction.
     * Logic is implemented for driving through tunnel two from S to obstruction and returning back to S
     * @return position for given direction at any point of tunnel
     */
    public Position go(Direction direction){
        Position p;
        if(direction == path.get(index)){
            index = index + 1;
            if(index == 28){
                p = Position.START;
            }else{
                p = Position.NORMAL;
            }
        }else{
            p = Position.NORMAL_UNCHANGED;
        }

        return p;
    }
}
