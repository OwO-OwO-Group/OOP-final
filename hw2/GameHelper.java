/*
 * 10627108 陳文捷 10612150 林詠翔 資訊二甲
 * UTF-8
 */
package hw2;

import java.io.*;
import java.util.*;

public class GameHelper {

    public String getUserInput(String prompt) {
        String inputLine = null;

        System.out.print(prompt + "  ");

        try {
            BufferedReader is =
                new BufferedReader(new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }

        return inputLine.toLowerCase();
    }
}
