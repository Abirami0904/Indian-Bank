public class Statement {
    public Statement(Person person)
    {
        for(String str : person.statements)
        {
            System.out.println(str+",");
        }
    }
}
