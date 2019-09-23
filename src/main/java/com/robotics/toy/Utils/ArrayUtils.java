package com.robotics.toy.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by don on 23/09/2019.
 */
public class ArrayUtils
{
    /**
     * @param n is the total width
     * @return arraylist with all the indexes of the 2 d array
     */
    public static List<String> createAndPopulateList(int n)
    {
        List<String> list = new ArrayList<>();
        for (int j = n; j >= 0; j--)
            for (int i = 0; i <= n; i++)
                list.add(i + "" + j);
        return list;

    }

    /**
     *
     * @param inputElements
     * @param n
     * @return the 2 dimenstional array
     */
    public static String[][] createAndPopulate2DArray(List<String> inputElements, int n)
    {
        String twoDGrid[][] = new String[n][n];
        int index = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                twoDGrid[i][j] = inputElements.get(index++);
            }

        return twoDGrid;
    }

    /**
     *
     * @param inputElements
     * @param n
     * @return Hashmap with keys as indexes and values as the cordinates
     */

    public static Map<String, String> createAndPopulateLookup(List<String> inputElements, int n){
        Map<String, String> lookup = new HashMap<>();
        int index = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
            {
                lookup.put(inputElements.get(index++), (i + "," + j));
            }
        return lookup;
    }

}
