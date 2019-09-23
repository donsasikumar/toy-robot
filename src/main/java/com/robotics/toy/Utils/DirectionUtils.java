package com.robotics.toy.Utils;

import com.robotics.toy.model.Direction;
import com.robotics.toy.model.Turn;

/**
 * Created by don on 23/09/2019.
 */
public class DirectionUtils
{
    /**
     * From the given direction, turn and determine new direction
     * @param direction
     * @param turn
     * @return Direction enum
     */
    public static Direction directionAfterTurn(Direction direction, Turn turn)
    {
        switch (direction)
        {
        case NORTH:
            if (turn == Turn.LEFT)
                return Direction.WEST;
            else if (turn == Turn.RIGHT)
                return Direction.EAST;
            break;
        case SOUTH:
            if (turn == Turn.LEFT)
                return Direction.WEST;
            else if (turn == Turn.RIGHT)
                return Direction.EAST;
            break;
        case WEST:
            if (turn == Turn.LEFT)
                return Direction.SOUTH;
            else if (turn == Turn.RIGHT)
                return Direction.NORTH;
            break;
        case EAST:
            if (turn == Turn.LEFT)
                return Direction.NORTH;
            else if (turn == Turn.RIGHT)
                return Direction.SOUTH;
            break;
        }
        return direction;
    }

    /**
     *
     * @param x
     * @param direction
     * @param sizeOfArray
     * @return X cordinate
     */
    public static int moveX(int x, Direction direction, int sizeOfArray)
    {
        switch (direction)
        {
        case NORTH:
            return (x - 1)>=0? x-1:0;
        case WEST:
            return x;
        case SOUTH:
            return (x + 1 <= sizeOfArray-1)? x+1:0;
        case EAST:
            return x;
        }
        return x;
    }

    /**
     *
     * @param y
     * @param direction
     * @param sizeOfArray
     * @return Y cordinate
     */
    public static int moveY(int y, Direction direction, int sizeOfArray)
    {
        switch (direction)
        {
        case NORTH:
            return y;
        case WEST:
            return (y - 1)>=0? y-1:0;
        case SOUTH:
            return y;
        case EAST:
            return (y + 1 <= sizeOfArray-1)? y+1:0;
        }
        return y;
    }
}
