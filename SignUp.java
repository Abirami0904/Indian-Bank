import java.util.HashMap;
import java.util.Scanner;

public class SignUp {
    static Scanner in = new Scanner(System.in);
    Parser parser = new Parser();
    static long accNum = 1234567890;
    public SignUp(HashMap<Long,Person> clients)
    {
        while(true)
        {
            Person person = new Person();
            System.out.print("\"name\" : ");
            //in.next();
            String name = in.next();
            if(parser.name(name))
            {
                person.name = name;
                System.out.print("\"date of birth\" : ");
                String dob = in.next();
                if(parser.dob(dob))
                {
                    person.dob = dob;
                    System.out.print("\"email\" : ");
                    String email = in.next();
                    if(parser.email(email))
                    {
                        person.email = email;
                        System.out.print("\"phone\" : ");
                        String phone = in.next();
                        if(parser.phone(phone))
                        {
                            person.phone = phone;
                            System.out.print("\"password\" : ");
                            //in.next();
                            String password = in.next();
                            person.password = password;
                            System.out.println("\"account_number\" : " +accNum);
                            System.out.println("\"ifsc\" : \"IDB0102\"");
                            person.accNo = accNum;
                            person.ifsc = "IDB0102";
                            clients.put(accNum,person);
                            ++accNum;
                            System.out.print("\"initial amount\" : ");
                            int amt = parser.initialAmount(in.nextInt(),in);
                            person.amount = amt;
                            person.statements.add("\"credited_rs."+amt+"_initially\"");
                            break;
                        }
                    }

                }
            }
        }
    }
}
