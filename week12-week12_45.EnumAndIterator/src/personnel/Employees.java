package personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {

    private List<Person> employees;

    public Employees() {
        this.employees = new ArrayList();
    }

    public void add(Person person){
        this.employees.add(person);
    }

    public void add(List<Person> persons){
        for(Person person: persons){
            this.employees.add(person);
        }
    }

    public void print(){
        Iterator<Person> employees = this.employees.iterator();
        while(employees.hasNext()){
            System.out.println(employees.next());
        }
    }

    public void print(Education education){
        Iterator<Person> employees = this.employees.iterator();
        while(employees.hasNext()){
            Person employee = employees.next();
            if(employee.getEducation() == education){
                System.out.println(employee);
            }
        }
    }

    public void fire(Education education){
        Iterator<Person> employees = this.employees.iterator();
        while(employees.hasNext()){
            Person employee = employees.next();
            if(employee.getEducation() == education){
                employees.remove();
            }
        }
    }
}
