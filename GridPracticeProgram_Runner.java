
/**
 * GridPracticeProgram_Runner
 *
 */

import java.util.ArrayList;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.ActorWorld;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;

import java.awt.Color;

public class GridPracticeProgram_Runner
{
    public static void main()
    {
        // Create the World
        ActorWorld world = new ActorWorld();

        // Get the grid
        Grid<Actor> grid = world.getGrid();

        // Show NumRows + NumCols
        System.out.println("grid.getNumRows() = " + grid.getNumRows());
        System.out.println("grid.getNumCols() = " + grid.getNumCols());
        /**
         * Output
         * row: 10
         * col: 10
         */

        // Check isValid Locations
        System.out.println("\n");
        System.out.println("grid.isValid(new Location(5,5)) = " + grid.isValid(new Location(5,5)));
        System.out.println("grid.isValid(new Location(10,10)) = " + grid.isValid(new Location(10,10)));
        /**
         * Output
         * (5,5): true
         * (1,10): false
         */

        // Put some Bugs in the world/on the grid.
        Bug b1 = new Bug();
        world.add(b1); //random location
        Bug b2 = new Bug(Color.BLUE);
        world.add(new Location(1,1),b2); //always add (1,1)

        // GET an Actor out of the grid
        Actor a = grid.get(new Location(1,1));
        System.out.println("\n a: " + a);
        /**
         * array is encapulated, therefore it needs an object to access the location
         * all the details of that actor
         */

        // BAD #1: PUT a Bug in via grid.put()
        //      Bug will NOT know where it is, just the grid will know.  :(
        /**
         * The world has control over the actor and the grid
         * Grid only shares information with itself
         * Actor only shares information with itself
         * ==================================================
         * The reason for add method for grid: world updates
         * both the actor and the grid
         * ==================================================
         * Grid shouldn't be messing with putting/adding actors
         * because b3 does not know where it is located
         * only grid knows it, it does not update the bug's knowledge
         *  of its location
         * world updates both the grid and the actor
         *  world is the whole thing, grid lives inside of the world
         * the bug would have a location of null
         */

        System.out.println("\n");
        System.out.println(" BAD #1: PUT a Bug in via grid.put(new Location(5,5),b3) ");
        System.out.println("   Bug will NOT know where it is, just the grid will know.  :(   ");
        Bug b3 = new Bug(Color.GREEN);
        grid.put(new Location(5,5),b3);
        System.out.println(" b3: " + b3);
        /**
         * Output
         * Location: null
         */

        // BAD #2: REMOVE a Bug in via grid.put()
        //       Bug b2 will NOT know that the grid thinks its gone, just the grid will know.  :(
        /**
         * similar to grid.put
         * Grid would know that the actor is no longer there
         * but the actor would not
         */
        System.out.println("\n");
        System.out.println("BAD #2: REMOVE a Bug in via grid.remove(new Location(1,1))  ");
        System.out.println("    Bug b2 will NOT know that the grid thinks its gone, just the grid will know.  :(   ");
        grid.remove(new Location(1,1));
        System.out.println("\n b2: " + b2);
        /**
         * Output
         * Location: (1,1)
         */

        // Put some Rocks in
        Bug b4 = new Bug(Color.ORANGE);
        world.add(new Location(7,7),b4);
        world.add(new Location(7,6), new Rock(Color.BLUE));
        world.add(new Location(7,8), new Rock(Color.BLACK));

        // ---------------- Four other Grid Methods ----------------
        ArrayList<Location> locs;
        ArrayList<Actor> neighbors;
        /**
         * Everything is going clockwise, like a compass
         * ==============================================
         * Using the grid because the grid knows what is on
         *  it and does not need the world class to identified
         */

        locs = grid.getOccupiedLocations();
        System.out.println("\n");
        System.out.println(" locs = grid.getOccupiedLocations() " + locs);
        /**
         *returns all occupied locations
         */

        locs = grid.getValidAdjacentLocations(new Location(7,7));
        System.out.println("\n");
        System.out.println(" locs = grid.getValidAdjacentLocations(new Location(7,7)): " + locs);
        /**
         * returns all valid locations, within the array boundary
         */

        locs = grid.getEmptyAdjacentLocations(new Location(7,7));
        System.out.println("\n");
        System.out.println(" locs = grid.getEmptyAdjacentLocations(new Location(7,7)): " + locs);
        /**
         * returns only locations that are empty
         */

        locs = grid.getOccupiedAdjacentLocations(new Location(7,7));
        System.out.println("\n");
        System.out.println(" locs = grid.getOccupiedAdjacentLocations(new Location(7,7)): " + locs);
        /**
         * returns only the locations that are occupied
         */

        neighbors = grid.getNeighbors(new Location(7,7));
        System.out.println("\n");
        System.out.println(" neighbors = grid.getNeighbors(new Location(7,7)): " + neighbors);
        /**
         * returns all actors and its information
         */

        world.show();

    } // main
}  // GridPracticeProgram_Runner




