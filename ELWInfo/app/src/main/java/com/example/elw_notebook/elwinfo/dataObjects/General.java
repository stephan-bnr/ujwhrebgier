package com.example.elw_notebook.elwinfo.dataObjects;

/**
 * Created by ELW-Notebook on 14.03.2018.
 */

public class General {

    /**
     * Calculates recursively the difference between two strings.
     *
     * @param string1
     * @param string2
     * @return
     */
    public static int LevenshteinDistance(String string1, String string2) {
        int cost;
        int string1Length = string1.length();
        int string2Length = string2.length();
        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();

        /* base case: empty strings */
        if (string1Length == 0) return string2Length;
        if (string2Length == 0) return string1Length;

        /* test if last characters of the strings match */
        if (charArray1[string1Length - 1] == charArray2[string2Length - 1])
            cost = 0;
        else
            cost = 1;

        /* return minimum of delete char from s, delete char from t, and delete char from both */
        return Math.min(Math.min((LevenshteinDistance(new String(charArray1), new String(charArray2)) + 1),
                (LevenshteinDistance(new String(charArray1), new String(charArray2)) + 1)),
                (LevenshteinDistance(new String(charArray1), new String(charArray2)) + cost));
    }
}
