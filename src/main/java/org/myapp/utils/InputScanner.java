package org.myapp.utils;

import java.util.Scanner;


public class InputScanner {
private int readInt()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private String readString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] scanArguments(int argumentsNeeded){
      
      String[] arguments = new String[argumentsNeeded];

       for (int i=0; i<argumentsNeeded; i++){
          arguments[i]=readString();
       }
      return arguments;
    }


}