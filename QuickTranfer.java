import java.util.Scanner;

public class QuickTranfer {
    public QuickTranfer(Scanner in,Person sender)
    {
        while(true)
        {
            System.out.print("\"enter_receiver's_account_number\" : ");
            String str = in.next();
            boolean isValid = Parser.accNo(str);
            if(isValid)
            {
                long receiverAcc = Long.parseLong(str);
                Person receiver = Parser.clients.get(receiverAcc);
                System.out.print("\"enter_amount_for_transaction\" : ");
                int amt = Parser.isValidAmt(in.nextInt(),sender);
                sender.amount -= amt;
                receiver.amount += amt;
                System.out.println("\"sucessfully_credited\" rs."+amt+"\"_to_\""+receiver.name);
                sender.statements.add("\"debited_rs."+amt+"_transacted_to_"+receiver+"\"");
                receiver.statements.add("\"credited_rs."+amt+"_by_"+sender+"\"");
                break;
            }
        }
    }
}
