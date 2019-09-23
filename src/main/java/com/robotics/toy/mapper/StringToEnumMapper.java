package com.robotics.toy.mapper;

import com.robotics.toy.model.Command;
import com.robotics.toy.model.Direction;

/**
 * Created by don on 23/09/2019.
 */
public class StringToEnumMapper
{
    /**
     *
     * @param command
     * @return enum Command
     */
    public static Command mapInputStringCommandToEnum(String command)
    {
        if (command.startsWith("place"))
        {
            return Command.PLACE;
        }
        if (command.startsWith("move"))
        {
            return Command.MOVE;

        }
        if (command.startsWith("left"))
        {
            return Command.LEFT;
        }
        if (command.startsWith("right"))
        {
            return Command.RIGHT;
        }
        if (command.startsWith("report"))
        {
            return Command.REPORT;
        }
        else
        {
            return Command.INVALID;
        }
    }

    /**
     *
     * @param command
     * @return enum Direction
     */
    public static Direction mapPlaceCommandToEnum(String command)
    {
        if (command.startsWith("NORTH"))
        {
            return Direction.NORTH;
        }
        if (command.startsWith("SOUTH"))
        {
            return Direction.SOUTH;

        }
        if (command.startsWith("EAST"))
        {
            return Direction.EAST;
        }
        if (command.startsWith("WEST"))
        {
            return Direction.WEST;

        }
        else
        {
            return Direction.UNKNOWN;
        }
    }
}
