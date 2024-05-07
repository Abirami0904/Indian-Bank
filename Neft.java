import java.util.Scanner;

public class Neft {
    public Neft(Scanner in)
    {
        Parser parser = new Parser();
        boolean isValidAcc;
        long accNum;
        while(true)
        {
            System.out.print("\"enter_account_number_for_money_to_be_credited\" : ");
            String str = in.next();
            isValidAcc = parser.accNo(str);
            if(isValidAcc)
            {
                accNum = Long.parseLong(str);
                if(parser.clients.containsKey(accNum))
                {
                    transfer(in,parser.clients.get(accNum));
                }
                else {
                    System.out.print("\"no_such_account");
                    break;
                }
            }
        }
    }
    public static void transfer(Scanner in,Person person)
    {
        while(true)
        {
            System.out.println("\"enter_amount_for_transaction\" : ");
            int amt = in.nextInt();
            if(amt > 0)
            {
                person.amount += amt;
                System.out.println("\"successfully_credited_rs."+amt+"\"");
                person.statements.add("\"credited_rs."+amt+"_via_neft");
                break;
            }
            else
            {
                System.out.println("\"amount_is_negative\"");
            }
        }
    }
}
