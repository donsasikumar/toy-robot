package com.robotics.toy;

import com.robotics.toy.Utils.ArrayUtils;
import com.robotics.toy.Utils.DirectionUtils;
import com.robotics.toy.Utils.StringUtils;
import com.robotics.toy.mapper.StringToEnumMapper;
import com.robotics.toy.model.Command;
import com.robotics.toy.model.Direction;
import com.robotics.toy.model.Turn;

import java.util.*;
import java.util.logging.Logger;

public class Toy_Robot
{

    final static Logger LOGGER = Logger.getLogger("Toy_Robot.class");
    static final Scanner sc = new Scanner(System.in);
    static int x, y = 0;
    static Direction direction = Direction.NORTH;
    static int sizeOfArray = 5;
    static String[][] twoDGrid;
    static boolean firstValidCommand;
    static int count = 0;
    static Map<String, String> lookup;

    public static void main(String[] args)
    {
        twoDGrid = ArrayUtils.createAndPopulate2DArray(ArrayUtils.createAndPopulateList(sizeOfArray - 1), sizeOfArray);
        lookup = ArrayUtils.createAndPopulateLookup(ArrayUtils.createAndPopulateList(sizeOfArray - 1), sizeOfArray);
        startPlay();
    }

    /**
     * Uses Scanner to aacept standard input and goes into an infinite loop to accept commands
     * It first validates the input command and then delegates the processing to process method.
     */

    static void startPlay()
    {
        StringUtils.printWelcomeMessage();
        while (true)
        {
            System.out.print("Command :");
            String command = sc.nextLine();
            firstValidCommand = StringUtils.validCommand(count, command);
            if (firstValidCommand)
            {
                process(command);
                count++;
                continue;
            }

            else if (command.equals("exit") || command.equals(""))
            {
                break;
            }
            else
            {
                System.out.println("UNKNOWN COMMAND.");
            }
        }
    }

    /**
     * The command is then mapped to an internal Command Enum
     * and then based on the type of command it invokes the corresponding function
     * @param command String input
     */

    static void process(String command)
    {
        Command enumCommand = StringToEnumMapper.mapInputStringCommandToEnum(command);
        switch (enumCommand)
        {
        case PLACE:
            place(command);
            firstValidCommand = true;
            break;
        case MOVE:
            move();
            break;
        case REPORT:
            System.out.println("Output =" + x + "," + y + "," + direction);
            break;
        case LEFT:
            direction = DirectionUtils.directionAfterTurn(direction, Turn.LEFT);
            break;
        case RIGHT:
            direction = DirectionUtils.directionAfterTurn(direction, Turn.RIGHT);
            break;
        case INVALID:
            System.out.println("UNKNOWN!!");
        }
    }

    /**
     * Extract the x and y cordinates or i&j index of two dimentional array from the place command
     * Extract the direction and map it to the internal model Direction.
     * Sets the x and y cordinate along with the direction.
     * @param command
     */
    static void place(String command)
    {
        int i = 0;
        try
        {
            i = Integer.parseInt(StringUtils.extractXFromPlaceCommand(command));
        }
        catch (NumberFormatException exception)
        {
            x = 0;
            y = 0;
            return;
        }
        x = (i <= sizeOfArray - 1) ? i : 0;

        int j = 0;
        try
        {
            j = Integer.parseInt(StringUtils.extractYFromPlaceCommand(command));
        }
        catch (NumberFormatException exception)
        {
            x = 0;
            y = 0;
            return;
        }
        y = (j <= sizeOfArray - 1) ? j : 0;
        direction = StringToEnumMapper.mapPlaceCommandToEnum(StringUtils.extractDirectionFromPlaceCommand(command));
    }

    /**
     * The move changes the value of x and y cordinates as follows
     * N -> X-1
     * W -> Y-1
     * E -> Y+1
     * S -> x+1
     */

    static void move()
    {
        if (x >= 0 && x <= sizeOfArray - 1 && y >= 0 && y <= sizeOfArray - 1)
        {
            String lookupResult = lookup.get(x + "" + y);
            int i = Integer.parseInt(lookupResult.substring(0, 1));
            i = (i >= 0 && i <= sizeOfArray) ? DirectionUtils.moveX(i, direction, sizeOfArray) : 0;
            int j = Integer.parseInt(lookupResult.substring(2));
            j = (j >= 0 && j <= sizeOfArray) ? DirectionUtils.moveY(j, direction, sizeOfArray) : 0;
            int k = Integer.parseInt(twoDGrid[i][j].substring(0, 1));
            x = (k >= 0 && k <= sizeOfArray) ? k : 0;
            int l = Integer.parseInt(twoDGrid[i][j].substring(1));
            y = (l >= 0 && l <= sizeOfArray) ? l : 0;
        }
        else
        {
            x = 0;
            y = 0;
        }
    }

}










