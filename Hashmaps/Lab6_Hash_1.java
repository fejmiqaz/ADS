package Labs.Hashmaps;
// The following classes are already imported, copying classes here is not allowed, use them directly as when they are available in other local files:

// CBHT, OBHT, MapEntry, SLLNode are already imported
import java.util.Hashtable;
import java.util.Scanner;

// Create the helper classes for key and value here
// Fulfill the requirements from the text for the toString methods
// Additionally, make sure that your key class will implement the required
// hashCode and equals methods
class Person {
    // declare the required fields here
    public String name;
    public Integer age;

    // implement the constructor
    Person(){}
    Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        // implement the toString method as requested in the text
        return  "<"+name + " " + age+">";
    }


//     implement the following two methods to make the table work properly
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }
    @Override
    public int hashCode() {
        return age * name.charAt(0);
    }
}

class Project {
    public Integer hours;
    public Integer salary;

    Project() {}
    Project(Integer hours, Integer salary) {
        this.hours = hours;
        this.salary = salary;
    }

    public int total_salary(){
        return hours * salary;
    }


    @Override
    public String toString() {
        return "<"+salary + ", " + hours+">";
    }

    public int getTotalSalary() {
        return total_salary();
    }
}

public class Lab6_Hash_1 {
    public static void main(String[] args) {
        // Create the table as requested
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<Person, Project> table = new CBHT<Person, Project>(10);

        // Read the input data and fill the table
        for(int i = 0; i < n; i++) {
            String name = sc.next();
            Integer age = sc.nextInt();
            Person person = new Person(name, age);
            Integer hours = sc.nextInt();
            Integer salary = sc.nextInt();
            Project project = new Project(hours, salary);
            SLLNode<MapEntry<Person, Project>> exists = table.search(person);
            if(exists == null ){
                table.insert(person, project);
            }else{
                Project existing = exists.element.value;
                if(project.total_salary() > existing.total_salary()){
                    table.insert(person, project);
                }
            }
        }

        // print your table
        System.out.println(table);
    }
}

