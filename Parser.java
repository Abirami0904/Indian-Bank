import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Parser {
    public static HashMap<Long,Person> clients = new HashMap<>();
    static ExceptionHandling exception = new ExceptionHandling();
    public static String input(String str)
    {
        String[] s = str.split("/");
        return exception.inputCheck(s);
    }
    public static boolean operationCheck(String operation)
    {
        return exception.operationChecking(operation);
    }
    public static void operation(String operation) {
            if (operation.equalsIgnoreCase("login")) {
                Login login = new Login(clients);
            } else {
                SignUp signup = new SignUp(clients);
            }
    }
    public static boolean name(String name)
    {
        return exception.nameCheck(name);
    }
    public static boolean dob(String dob)
    {
        return exception.dobCheck(dob);
    }
    public static boolean email(String email)
    {
        return exception.emailCheck(email);
    }
    public static boolean phone(String phone)
    {
        return exception.phoneNoCheck(phone);
    }
    public static boolean accNo(String accNo)
    {
        return exception.accNoCheck(accNo);
    }
    public static boolean isNext(String next)
    {
        return next.equalsIgnoreCase("Yes");
    }
    public static int initialAmount(int amt, Scanner in)
    {
        return exception.ValidInitialAmt(amt,in);
    }
    public static int isValidAmt(int amt,Person person)
    {
        return exception.validAmt(amt,person);
    }
}
