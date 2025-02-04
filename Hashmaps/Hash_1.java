package Hashing;

import java.util.Objects;
import java.util.Scanner;

class Employee {
    public String name;
    public Integer age;

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && name.equals(employee.name);
    }

    @Override
    public int hashCode() {
        return age * name.charAt(0);
    }

    @Override
    public String toString() {
        return name + " " + age;
    }
}

class Project {
    public static Integer workTime;
    public static Integer hours;

    Project(Integer workTime, Integer hours) {
        this.workTime = workTime;
        this.hours = hours;
    }

    public static int calculateSalary() {
        return workTime * hours;
    }

    @Override
    public String toString() {
        return workTime + " " + hours;
    }
    public int getTotalSalary() {
        return calculateSalary();
    }
}

public class Hash_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CBHT<Employee, Project> hash = new CBHT<Employee,Project>(10);
        Integer n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            Integer age = sc.nextInt();
            Integer hours = sc.nextInt();
            Integer workTime = sc.nextInt();
            Employee employee = new Employee(name, age);
            Project project = new Project(workTime, hours);
            SLLNode<MapEntry<Employee, Project>> exists = hash.search(employee);
            if (exists == null) {
                hash.insert(employee, project);
            }else {
                Project project2 = exists.element.value;
                if(project.getTotalSalary() > project2.getTotalSalary()) {
                    hash.insert(employee, project);
                }
            }
        }
        System.out.println(hash);

    }
}
