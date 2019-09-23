package com.robotics.toy.Utils;

/**
 * Created by don on 23/09/2019.
 */
public class StringUtils
{
    public static void printWelcomeMessage()
    {
        System.out.println("Welcome to Toy Robot!");
    }

    /**
     * Validate the input command. First command needs to a place and from then on it could be any
     * @param count
     * @param command
     * @return true or false
     */
    public static boolean validCommand(int count, String command)
    {
        if(count == 0 && command.startsWith("place") )
        {
            return true;
        }
        else if (count>0 && (command.startsWith("place") || command.startsWith("move") || command.startsWith("left") || command
                .startsWith("right") || command.startsWith("report")))
            return true;
        return false;
    }

    /**
     *
     * @param inputCommand
     * @return X cordinate as String
     */
    public static String extractXFromPlaceCommand(String inputCommand)
    {
        if (inputCommand != null && inputCommand.length() >= 7)
            return inputCommand.substring(6, 7);
        else
            return "";
    }
    /**
     *
     * @param inputCommand
     * @return Y cordinate as String
     */
    public static String extractYFromPlaceCommand(String inputCommand)
    {
        if (inputCommand != null && inputCommand.length() >= 9)
            return inputCommand.substring(8, 9);
        else
            return "";
    }

    /**
     *
     * @param inputCommand
     * @return Direction as string
     */

    public static String extractDirectionFromPlaceCommand(String inputCommand)
    {
        if (inputCommand != null && inputCommand.length() >= 10)
            return inputCommand.substring(10);
        else
            return "";
    }
}
