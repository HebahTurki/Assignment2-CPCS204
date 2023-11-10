package b9b_2105304_p2;

import java.util.*;
import java.io.*;

/*
 Name : Hebah Turki Alahmari 
 IDs : 2105304
 Section : B9B
 Email: hmohammadalahmari@stu.kau.edu.sa
 Assignment#2
 */

public class B9B_2105304_P2 
{
    public static void diamondPattern(int start, int Number, PrintWriter pinFile) 
    {
        
        if (start == Number) //printing the center line of the diamond
        {
            for (int i = 0; i < Number; i++) 
            {
                pinFile.print("* ");
            }
            pinFile.println();
        }
        else
        {
            int Space = (Number - start) / 2;//number of spaces
            
            for (int i = 0; i < Space; i++) 
            {
                pinFile.print("  ");
            }
            for (int i = 0; i < start; i++)
            { 
                // Printing stars
                pinFile.print("* ");
            }
            for (int i = 0; i < Space; i++)
            {
                pinFile.print("  ");
            }
            pinFile.println();
            
            diamondPattern(start+2, Number, pinFile);// send recursive call
            
            for (int i = 0; i < Space; i++) 
            {
                pinFile.print("  ");
            }
            for (int i = 0; i < start; i++)
            {
                pinFile.print("* ");
            }
            for (int i = 0; i < Space; i++) 
            {
                pinFile.print("  ");
            }
            pinFile.println();
            
        }
        
    }
    
    public static String charPattern(char i)
    {
        if(Character.toUpperCase(i)=='A')//base case
            return "A";
        else
            return charPattern((char)(i-1))+i+charPattern((char)(i-1));// send recursive call
    }
    
    public static int bricksToUnload(int n)
    {
        if (n == 1) //base case
        {
            return 1;
        }
        else if (n == 2) //base case
        {
            return 2;
        }
        else if (n == 3) //base case
        {
            return 4;
        }
        else
        {
            return bricksToUnload(n-1) + bricksToUnload(n-2)+ bricksToUnload(n-3);// send recursive call
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        //Open the input Files & reading the data.
        File command = new File("input.txt");
        
        //File pointer to the output file.
        File output = new File("Output.txt");
        
        //Check if the files exists.
        if(!command.exists())
        {
            System.out.println("The input files does not exists!!");
            System.exit(0);
        }
        
        //Make Scanners for input Files.
        Scanner inputFile = new Scanner(command);
        
        //Creating fileWriter to write in the File.
        PrintWriter pinFile = new PrintWriter(output);
        
        String commands;//reading the inputs
        int commandnum = inputFile.nextInt();
        int counter = 0;
        
        do
        {
            commands = inputFile.next();
            
            switch(commands)
            {
                case "charPattern" :
                    char choice = inputFile.next().charAt(0);//read the char
                    String pattern = charPattern(choice);
                    pinFile.println(pattern);
                    counter++;
                    break;
                
                case "drawDiamond" :
                    int number = inputFile.nextInt();
                    if(number%2==0)//check if it is odd number
                        System.out.println("Even number cant draw Diamond ");
                    else
                    {
                        diamondPattern(1, number, pinFile);
                    }
                    counter++;
                        
                    break;
                    
                case "bricksToUnload" :
                    int bricks = inputFile.nextInt(); //take number of bricks
                    int unload = bricksToUnload(bricks);
                    pinFile.println(unload);
                    counter++;
                    break;
                    
            }
        }while(counter < commandnum) ; 
        //close the file writer
        pinFile.close();
        
    }

}
