package GridWorldCodeBlueJ.projects.boxBug;

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BoxBugRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();

        BoxBug alice = new BoxBug(6);
        alice.setColor(Color.ORANGE);

        BoxBug bob = new BoxBug(2);

        CircleBug steve = new CircleBug(3);
        steve.setColor(Color.BLUE);

        SpiralBug jesse = new SpiralBug(1);
        jesse.setColor(Color.MAGENTA);

        ZBug betta = new ZBug(4);
        betta.setColor(Color.GREEN);

        world.add(new Location(7, 8), alice);
        world.add(new Location(5, 5), bob);
        world.add(new Location(3, 3), steve);
        world.add(new Location(4, 5), jesse);
        world.add(new Location(2, 2), betta);
        world.show();
    }
}

