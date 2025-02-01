import java.util.LinkedList;
import java.util.Scanner;
import java.util.NoSuchElementException;

class Person {
    public String name;
    public int m1;
    public int m2;
    public int m3;

    Person(String name, int m1, int m2, int m3) {
        this.name = name;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    @Override
    public String toString() {
        return name + " " + m1 + " " + m2 + " " + m3;
    }
}

public class Queue_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedQueue<Person> queue = new LinkedQueue<Person>();
        int n = sc.nextInt();
        sc.nextLine();
        LinkedQueue<Person> science = new LinkedQueue<Person>();
        LinkedQueue<Person> scienceFiction = new LinkedQueue<Person>();
        LinkedQueue<Person> history = new LinkedQueue<Person>();
        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();
            sc.nextLine();
            Person person = new Person(name, m1, m2, m3);
            if(person.m1 == 1){
                science.enqueue(person);
            }else if(person.m2 == 1){
                scienceFiction.enqueue(person);
            }else if(person.m3 == 1){
                history.enqueue(person);
            }
        }

        Person temp = null;
        while(!science.isEmpty()) {
            temp = science.dequeue();
            if(temp.m2 == 1){
                scienceFiction.enqueue(temp);
            }else if(temp.m3 == 1){
                history.enqueue(temp);
            }else{
                System.out.println(temp.name);
            }
        }
        while(!scienceFiction.isEmpty()) {
            temp = scienceFiction.dequeue();
            if(temp.m3 == 1){
                history.enqueue(temp);
            }else{
                System.out.println(temp.name);
            }
        }
        while(!history.isEmpty()) {
            temp = history.dequeue();
            System.out.println(temp.name);
        }

    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }
}

interface Queue<E> {
    // Elementi na redicata se objekti od proizvolen tip.
    // Metodi za pristap:
    public boolean isEmpty();
    // Vrakja true ako i samo ako redicata e prazena.

    public int size();
    // Ja vrakja dolzinata na redicata.

    public E peek();
    // Go vrakja elementot na vrvot t.e. pocetokot od redicata.

    // Metodi za transformacija:

    public void clear();
    // Ja prazni redicata.

    public void enqueue(E x);
    // Go dodava x na kraj od redicata.

    public E dequeue();
    // Go otstranuva i vrakja pochetniot element na redicata.
}

class LinkedQueue<E> implements Queue<E> {

    // Redicata e pretstavena na sledniot nacin:
    // length go sodrzi brojot na elementi.
    // Elementite se zachuvuvaat vo jazli dod SLL
    // front i rear se linkovi do prviot i posledniot jazel soodvetno.
    SLLNode<E> front, rear;
    int length;

    // Konstruktor ...

    public LinkedQueue () {
        clear();
    }

    public boolean isEmpty () {
        // Vrakja true ako i samo ako redicata e prazena.
        return (length == 0);
    }

    public int size () {
        // Ja vrakja dolzinata na redicata.
        return length;
    }

    public E peek () {
        // Go vrakja elementot na vrvot t.e. pocetokot od redicata.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    public void clear () {
        // Ja prazni redicata.
        front = rear = null;
        length = 0;
    }

    public void enqueue (E x) {
        // Go dodava x na kraj od redicata.
        SLLNode<E> latest = new SLLNode<E>(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public E dequeue () {
        // Go otstranuva i vrakja pochetniot element na redicata.
        if (front != null) {
            E frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}
