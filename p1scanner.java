/*
 * Class: CS 4308 Section #
 * Term: Summer 2023
 * Name: Alex Nguyen
 * Instructor: Sharon Perry
 * Project: Project 1: Scanner
 */
import java.util.*;
import java.io.*;
public class p1scanner
{
    public static void main(String args[])
    {
        String test = "Test3.jl";
        String output = "";
        try
        {
            //Creating something to read the test files in
            File file = new File(test);
            String line;
            Scanner scan = new Scanner(file);

            //creating individual lexemes to work with separated by white space
            while(scan.hasNextLine())
            {
                line = scan.nextLine();
                String[] lexemes = line.split(" ");
                for(int i = 0; i < lexemes.length; i++)
                {
                    output += Scanner(lexemes[i]) + "\n";
                }
            }
            scan.close();
        }catch(Exception e)
        {
            System.out.println (e);
        }
        System.out.println ("Lexeme            Symbol");
        System.out.println("----------------------------");
        System.out.println(output);
    }

    public static String Scanner(String lexeme)
    {
        String token;
        int i = 0;
        //ensuring the input isn't empty
        if (lexeme.isEmpty())
        {
            return "";
        }

        //first checking for a character then assigning the appropriate symbol
        if (Character.isLetter(lexeme.charAt(i)))
        {
            if (lexeme.equals("if") || lexeme.equals("function") || lexeme.equals("then") || lexeme.equals("else") || lexeme.equals("end") || lexeme.equals("while"))
            {
                token = lexeme + "            " + lexeme.toUpperCase();
            }else
            {
                //This is if it's a variable like x
                token = lexeme + "            " + "Identifier";
            }
            //if statement for each possibility
        }else if(Character.isDigit(lexeme.charAt(i)))
        {
            token = lexeme + "            " + "Integer";
        }else if (lexeme.equals("~="))
        {
            token = lexeme + "            " + "NE_Operator";
        }else if (lexeme.equals("<="))
        {
            token = lexeme + "            " + "le_Operator";
        }else if (lexeme.equals("<"))
        {
            token = lexeme + "            " + "lt_Operator";
        }else if (lexeme.equals(">="))
        {
            token = lexeme + "            " + "ge_Operator";
        }else if (lexeme.equals(">"))
        {
            token = lexeme + "            " + "gt_Operator";
        }else if (lexeme.equals("=="))
        {
            token = lexeme + "            " + "eq_Operator";
        }else if (lexeme.equals("="))
        {
            token = lexeme + "            " + "Assignment_Operator";
        }else if (lexeme.equals("("))
        {
            token = lexeme + "            " + "Open_Parenthesis";
        }else if(lexeme.equals(")"))
        {
            token = lexeme + "            " + "Close_Parenthesis";
        }else if (lexeme.equals("+="))
        {
            token = lexeme + "            " + "Add_Assignment_Operator";
        } else if (lexeme.equals("-"))
        {
            token = lexeme + "            " + "sub_Operator";
        }else if (lexeme.equals("*"))
        {
            token = lexeme + "            " + "Mul_Operator";
        }else if (lexeme.equals("/"))
        {
            token = lexeme + "            " + "div_Operator";
        } else {
            token = lexeme + "            " + "Symbol Unknown";
        }
        return token;
    }
}
