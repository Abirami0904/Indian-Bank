import java.util.*;
public class MainClass {
    static Parser parser = new Parser();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String operation;
        boolean isValid , isNext;
        while(true)
        {
            System.out.println("\"welcome to indianbank\"");
            String str = in.next();
            operation = parser.input(str);
            if(!operation.equals("no"))
            {
                isValid = parser.operationCheck(operation);
                if(isValid)
                {
                    parser.operation(operation);
                    System.out.println("\"do you want to continue\" : ");
                    String next = in.next();
                    isNext = parser.isNext(next);
                    if(!isNext)
                    {
                        break;
                    }
                }
            }

        }
        //parser.operation(operation);
    }
}
