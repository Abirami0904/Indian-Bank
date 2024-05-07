import java.util.Scanner;

public class Transaction {
    Scanner in = new Scanner(System.in);
    public Transaction(Person person)
    {
        System.out.print("\"enter_your_choice_of_transaction\"\n\"1.neft\"\n\"2.quick_transfer\"\n");
        int n = in.nextInt();
        if(n == 1)
        {
            Neft neft = new Neft(in);
        }
        else if(n == 2)
        {
            QuickTranfer q = new QuickTranfer(in,person);
        }
    }
}
