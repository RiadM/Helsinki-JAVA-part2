import java.util.ArrayList;
import java.util.List;

public class Person{

    private List<String> phoneNumber;
    private String name;
    private String street;
    private String city;

   public Person(String name) {
       this.name       = name;
       this.phoneNumber= new ArrayList();
       this.street     = "";
       this.city       = "";
    }



    public String getName(){
        return this.name;
    }

    public void setAddress(String street, String city){
        this.street     =   street;
        this.city       =   city;
    }

    public String getAddress(){
        if(this.street.isEmpty()){
            return "  address unknown";
        }else{
            return "  address: " + this.street + " " + this.city ;
        }
    }

    public void addNumber(String number){
        this.phoneNumber.add(number);
    }

    public List<String> phoneNumbers(){
        return this.phoneNumber;
    }

}
