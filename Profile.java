public class Profile {
    public Profile(Person person)
    {
        System.out.println("{");
        System.out.println("\"name\"           : "+"\""+person.name+"\",");
        System.out.println("\"date_of_birth\"  : "+person.dob+",");
        System.out.println("\"email\"          : "+person.email+",");
        System.out.println("\"phone_number\"   : "+person.phone+",");
        System.out.println("\"account_number\" : "+person.accNo+",");
        System.out.println("\"ifsc\"           : "+person.ifsc+",");
        System.out.println("}");
    }
}
