import java.util.*;

public class Directory {

    private Scanner reader;
    private Map<String,Person> persons;
    private Map<String, Person> numbers;

    public Directory() {
        this.reader = new Scanner(System.in);
        this.persons = new HashMap();
        this.numbers = new HashMap();
    }

    public void start(){
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number\n" +
                " 2 search for a number\n" +
                " 3 search for a person by phone number\n" +
                " 4 add an address\n" +
                " 5 search for personal information\n" +
                " 6 delete personal information\n" +
                " 7 filtered listing\n" +
                " x quit");
        String userInput = "";

        while(!userInput.equals("x")){
            System.out.println("");
            System.out.print("command: ");
            userInput = this.reader.nextLine();

            if(userInput.equals("1")){
                addNumber();
            }
            if(userInput.equals("2")){
                searchNumberByPerson();
            }
            if(userInput.equals("3")) {
                searchPersonByNumber();
            }
            if(userInput.equals("4")) {
                addAddress();
            }
           if(userInput.equals("5")) {
                searchPersonByPersonalInfo();
            }
            if (userInput.equals("6")) {
                deletePerson();
            }
            if (userInput.equals("7")) {
                filterList();
            }
            else {
            }
        }
    }

    //Method to add a person and is number to the directory
    public void addNumber(){
        System.out.print("whose number: ");
        String person = this.reader.nextLine();
        System.out.print("number: ");
        String number = this.reader.nextLine();

        //Look if the person alredy exist, if yes then add the number
        //If not it add the person.
        if(this.persons.containsKey(person)) {
            this.persons.get(person).addNumber(number);
            if(!this.numbers.containsKey(number)){
            this.numbers.put(number, this.persons.get(person));
            }
        }
        else {
            Person personAdd = new Person(person);
            personAdd.addNumber(number);
            this.persons.put(person,personAdd );
            this.numbers.put(number, personAdd);
        }
    }

    //Method to search for a number
    public void searchNumberByPerson(){
        System.out.print("whose number: ");
        String person = this.reader.nextLine();

        //Look up the person and print the numbers if there's some
        if(this.persons.containsKey(person)){

            for(String number: this.persons.get(person).phoneNumbers()){
                System.out.println(" " + number);
            }
        }else {
            System.out.println("  not found");
        }
    }

    //Method to search a person by phone number
    public void searchPersonByNumber(){
        System.out.print("number: ");
        String number = this.reader.nextLine();

        //Look up the number and print the name
        if(this.numbers.containsKey(number)){
            System.out.println(" " + this.numbers.get(number).getName());
        }else {
            System.out.println("  not found");
        }
    }

    //Method to add an address to a Person
    public void addAddress(){
        System.out.print("whose address: ");
        String person = this.reader.nextLine();

        //If this person don't exist it will add it to the HashMap
        if(!this.persons.containsKey(person)){
            this.persons.put(person, new Person(person));
        }

        System.out.print("street: ");
        String street = this.reader.nextLine();
        System.out.print("city: ");
        String city = this.reader.nextLine();

        this.persons.get(person).setAddress(street, city);
    }

    //Method to print personal info of a Person
    public void searchPersonByPersonalInfo(){
        System.out.print("whose information: ");
        String person = this.reader.nextLine();

        //If this person don't exist it will add it to the HashMap
        if(!this.persons.containsKey(person)){
            System.out.println("  not found");
        }else {
            System.out.println(this.persons.get(person).getAddress());

            //Look up the person and print the numbers if there's some
            if (!this.persons.get(person).phoneNumbers().isEmpty()) {
                System.out.println("  phone numbers:");

                for (String number : this.persons.get(person).phoneNumbers()) {
                    System.out.println("   " + number);
                }
            } else {
                System.out.println("  phone number not found");
            }
        }
    }

    //Method to delete a person
    public void deletePerson(){
        System.out.print("whose information: ");
        String person = this.reader.nextLine();
        try{
        for(String number: this.persons.get(person).phoneNumbers()){
            if(this.numbers.containsKey(number)){
            this.numbers.remove(number);
            }
        }
        this.persons.remove(person);}
        catch (Exception e){

        }
    }

    //Method to filter the list and print the results
    public void filterList(){
        System.out.print("keyword (if empty, all listed): ");
        String keywordInput = this.reader.nextLine();

        System.out.println("");

        //Check if the keyword appear
        List<String> finalList = new ArrayList();
        for(String person: this.persons.keySet()){
            if(person.contains(keywordInput) || this.persons.get(person).getAddress().contains(keywordInput) || keywordInput.isEmpty()){
                finalList.add(person);
            }
        }

        if(finalList.isEmpty()){
            System.out.println(" keyword not found");
        } else{
            Collections.sort(finalList);
            for(String person: finalList){
                System.out.println("");
                System.out.println(" " + person);
                System.out.println(this.persons.get(person).getAddress());

                if(this.persons.get(person).phoneNumbers().isEmpty()) {
                    System.out.println("  phone number not found");
                }else{
                    System.out.println("  phone numbers:");
                    for(String number: this.persons.get(person).phoneNumbers()){
                            System.out.println("   " + number);
                    }
                }
            }
        }
    }
}
