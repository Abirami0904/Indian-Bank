import java.util.HashMap;
import java.util.Scanner;

public class Login {
    Parser parser = new Parser();
    static Scanner in = new Scanner(System.in);
    public Login(HashMap<Long,Person> clients)
    {
        while(true)
        {
            System.out.print("\"account_number\" : ");
            String str = in.next();
            if(parser.accNo(str))
            {
                long accNo = Long.parseLong(str);
                if(clients.containsKey(accNo))
                {
                    Person person = clients.get(accNo);
                    System.out.print("\"email\" : ");
                    String email = in.next();
                    System.out.print("\"password\" : ");
                    String password = in.next();
                    if(person.password.equals(password) && person.email.equals(email))
                    {
                        options(person);
                        break;
                    }
                    else {
                        System.out.println("{\n\"error\"\n   \"code\" : 400\n     \"name\" : \"incorrect password or email\"");
                    }
                }
            }
        }
    }
    public static void options(Person person)
    {
        System.out.print("\"enter operation you want to perform\"\n\"1.profile\"\n\"2.transaction\"\n\"3.statement\"");
        int n = in.nextInt();
        if(n == 1)
        {
            Profile p = new Profile(person);
        }
        else if(n == 2)
        {
            Transaction t = new Transaction(person);
        }
        else if(n == 3)
        {
            Statement s = new Statement(person);
        }
    }

}
