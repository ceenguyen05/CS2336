package edu.utdallas.cs2336;

public class Main {
    public static double divide(int numerator, int denominator) {
        // TODO: divide, keeping the fractional part (if any)
        // DONE , Test Passed 
        return ((double) numerator / (double) denominator) ;
    }

    public static StringBuilder forwardAndReverseBuilder(String[] entries) {
        // TODO: use a loop to add each entry in entries to a StringBuilder
        //  (no need for a delimiter) and then add all the entries
        //  in reverse order
        // DONE , Test Passed
        StringBuilder string = new StringBuilder () ;
        int count = 0 ;
        while (count < entries.length)
        {
            string.append (entries[count]) ;
            count++ ;
        }
        for (int counter = entries.length - 1 ; counter >= 0 ; counter--)
        {
            string.append (entries[counter]) ;
        }

        return string;
    }

    public enum Comparison {
        LESS_THAN,
        EQUAL_TO,
        GREATER_THAN
    }

    public static Comparison checkValues(int value1, int value2) {
        // TODO: use < and > in ifs to return the proper value
        // DONE , Test Passed  
        if (value1 > value2)
        {
            return Comparison.GREATER_THAN ;
        }
        else if (value1 < value2)
        {
            return Comparison.LESS_THAN ;
        }
        else 
        {
            return Comparison.EQUAL_TO ;
        }
    }

    public static Comparison checkValues(String value1, String value2) {
        // TODO: use String's compareTo method to return the right thing
        //  See https://www.w3schools.com/java/ref_string_compareto.asp
        // DONE , Test Passed
        if(value1.compareTo(value2) > 0)
        {
            return Comparison.GREATER_THAN ;
        }
        else if (value1.compareTo(value2) < 0 )
        {
            return Comparison.LESS_THAN ;
        }
        else 
        {
            return Comparison.EQUAL_TO ;
        }
    }

    public static boolean isEqual(double first, double second) {
        // TODO: use the range .0001 to check for equality
        //  (that is, the two are equal if they are within
        //  .0001 of each other
        // DONE , Test Passed 
        double range = .0001 ;
        return Math.abs(first - second) <= range ;
    }

    public static char returnNumberAsCharacter(int number) {
        // TODO: use a switch to turn 1 into 'a', 2 into 'b'...through
        //  10 into 'j', and z for anything else
        // DONE , Test Passed, Fixed Switch
        switch (number)
        {
            case 1 :
            return 'a';
            case 2:
            return 'b';
            case 3:
            return 'c';
            case 4:
            return 'd';
            case 5:
            return 'e';
            case 6:
            return 'f';
            case 7:
            return 'g';
            case 8:
            return 'h';
            case 9:
            return 'i';
            case 10:
            return 'j';
            default :
            return 'z' ;
        }
    }

    private static final String IS_A_TEST = "This is a test";

    public static String getString ()
    {
        return IS_A_TEST ;
    }

    public static String getPrivateString() {
        // TODO: return IS_A_TEST (private, so unavailable)
        // DONE , Test Passed 
        return getString() ;
    }

    public static int amountInUse(int[] arrayToCheck) {
        // TODO: return the number of elements in the array
        //  that are non-0 (and assummed to be in use)
        // DONE , Test Passed
        int non_zero = 0 ;
        for (int count = 0 ; count < arrayToCheck.length ; count++)
        {
            if (arrayToCheck[count]!= 0)
            {
                non_zero++ ;
            }
        }
        return non_zero;
    }

    public static void numLowerUpperCase(String stringToCheck, int[] results) {
        // TODO: put the number of lowercase characters in results[0],
        //  and the number of uppercase characters in results[1]
        // DONE , Test passed 
        int upper = 0 ;
        int lower = 0 ;
        for (int count = 0 ; count < stringToCheck.length() ; count++)
        {
            char camelCheck = stringToCheck.charAt(count) ;
            boolean isUpper = Character.isUpperCase(camelCheck) ;
            if (isUpper == true )
            {
                upper++ ;
            }
            else 
            {
                lower++ ;
            }
        }
        results[0] = lower ;
        results[1] = upper ;
    }
}
