package edu.utdallas.cs2336;

import java.util.List;

public class Recursion {

    private static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 
        43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    public static String primeFactorization(int number) {

        // professor completed 
        for ( int prime : PRIMES) {
            if ( number == prime) {
                return Integer.toString(number);
            }
            if ( number % prime == 0) {
                return prime + " * " + primeFactorization(number / prime);
            }
        }
        // Nothing found
        return Integer.toString(number);
    }

    private static void printContents(FileSystemElement element, StringBuilder stringBuilder, String prepend) {

        // if it is a file , append prened for indents , the name , and a newline
        if (element.getType() == FileSystemElement.Type.FILE)
        {
            stringBuilder.append(prepend).append(element.getName()).append("\n") ;
        }
        // if it is a directory 
        // append indents , name , and a newline to the stringbuilder
        // recursivly goes through the directory contents 
        // for loop to use recursion to go through the directory 
        else if (element.getType() == FileSystemElement.Type.DIRECTORY)
        {
            stringBuilder.append(prepend).append(element.getName()).append("\n");

            List<FileSystemElement> contents = element.getContentsList(); // get contents using getContentsList()
        
            // for loop , for each file or directory , call printContents and pass the file or direcotory , the stringBuilder 
            // and prepend with three spaces 
            for (FileSystemElement childContents : contents) 
            {
                printContents(childContents, stringBuilder, prepend + "   ");
            }
        }
    }

    public static String printContents(FileSystemElement element) {
        StringBuilder builder = new StringBuilder();
        printContents(element, builder, "");
        return builder.toString();
    }
}