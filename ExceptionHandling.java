import java.util.Scanner;
import java.util.regex.*;

public class ExceptionHandling {
    public static String inputCheck(String[] str)
    {
        try
        {
            //String s = str[1];
            return str[1];
        } catch(IndexOutOfBoundsException e){
            System.out.println("{\n \"error\",");
            System.out.print("  \"code\": 500,\n");
            System.out.println("   \"name\":\"IndexOutOfBound\",");
            System.out.println("}");
            return "no";
        }
    }
    public static boolean operationChecking(String str)
    {
        if(str.equalsIgnoreCase("login") || str.equalsIgnoreCase("signup"))
        {
            return true;
        }
        else {
            System.out.println("{\n\"error\",\n   \"code\" : 404,\n      \"name\" : \"PageNotFound\",\n}");
            return false;
        }
    }
    public static boolean nameCheck(String str)
    {
        for(int i = 1; i < str.length() - 1; ++i)
        {
            if(!(str.charAt(i) == ' ' || str.charAt(i) == '.' || ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'))))
            {
                System.out.println("{\n\"error\",\n    \"code\" : 400,\n     \"name\" : \"invalidformat\",\n}");
                return false;
            }
        }
        return true;
    }
    public static boolean dobCheck(String str)
    {
        for(int i = 1; i < str.length() - 1; ++i)
        {
            if(!(str.charAt(i) == '-' || (str.charAt(i) >= '0' && str.charAt(i) <= '9')))
            {
                System.out.println("{\n\"error\",\n    \"code\" : 400,\n     \"name\" : \"invalidformat\",\n}");
                return false;
            }
        }
        return true;
    }
    public static boolean emailCheck(String str)
    {
        if(!Pattern.matches("^[\\w\\-\\.]+@([\\w-]+\\.)+[\\w-]{2,}$",str) )
        {
            System.out.println("{\n\"error\",\n    \"code\" : 400,\n     \"name\" : \"invalidformat\",\n}");
            return false;
        }
        return true;
    }
    public static boolean phoneNoCheck(String str)
    {
        if(str.length() > 12 || str.length() < 10)
        {
            System.out.println("{\n\"error\",\n    \"code\" : 400,\n     \"name\" : \"invalidformat\",\n}");
            return false;
        }
        for(int i = 0; i < str.length()-1; ++i)
        {
            if(!(str.charAt(i) == '+' || (str.charAt(i) >= '0' && str.charAt(i) <= '9')))
            {
                System.out.println("{\n\"error\",\n    \"code\" : 400,\n     \"name\" : \"invalidformat\",\n}");
                return false;
            }
        }
        return true;
    }
    public static boolean accNoCheck(String str)
    {
        if(str.length() > 10 ||!(str.charAt(0) == '1' || str.charAt(1) == '2' || str.charAt(2) == '3' ||str.charAt(3) == '4'))
        {
            return false;
        }
        try
        {
            long num = Long.parseLong(str);
            return true;
        } catch(NumberFormatException e){
            System.out.println("{\n\"error\",\n   \"code\" : 501,\n    \"name\" : numberformatexception,\n}");
            return false;
        }
    }
    public static int ValidInitialAmt(int amt, Scanner in)
    {
        while(amt <= 2000)
        {
            System.out.println("{\n\"error\",\n   \"code\" : 503,\n    \"name\" : in_sufficient_balance,\n}");
            amt = in.nextInt();
        }
        return amt;
    }
    public static int validAmt(int amt,Person person)
    {
        if(person.amount - amt > 2000)
        {
            return amt;
        }
        else
        {
            while(person.amount - amt <= 2000)
            {
                Scanner in = new Scanner(System.in);
                System.out.println("\"less_than_minimum_balance\"");
                amt = in.nextInt();
            }
        }
        return amt;
    }
}
