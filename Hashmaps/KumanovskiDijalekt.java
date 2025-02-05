package Hashing;

// Kumanovski dijalekt

import java.util.Objects;
import java.util.Scanner;

class Kumanovski {
    String dijalekt;
    String gramaticen;

    public Kumanovski(String dijalekt, String gramaticen) {
        this.dijalekt = dijalekt;
        this.gramaticen = gramaticen;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Kumanovski that = (Kumanovski) o;
        return Objects.equals(dijalekt, that.dijalekt) && Objects.equals(gramaticen, that.gramaticen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dijalekt, gramaticen);
    }

    @Override
    public String toString() {
        return gramaticen;
    }
}

public class KumanovskiDijalekt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, Kumanovski> bucket = new CBHT<String, Kumanovski>(n);
        for (int i = 0; i < n; i++) {
            String key = sc.next();
            String value = sc.next();
            Kumanovski k = new Kumanovski(key, value);
            bucket.insert(key, k);
        }
        sc.nextLine();
        String test = sc.nextLine();
        String [] pts = test.split(" ");

        String res = "";

        for (int i = 0; i < pts.length; i++) {
            String word = pts[i];
            String punctuation = "";


            if (word.matches(".*[.,!?]$")) {
                punctuation = word.substring(word.length() - 1);
                word = word.substring(0, word.length() - 1);
            }

            String keyToCheck = word.toLowerCase();
            SLLNode<MapEntry<String, Kumanovski>> node = bucket.search(keyToCheck);
            if(node != null) {
                if (keyToCheck.equals(node.element.key)) {
                    pts[i] = " +" + node.element.value.gramaticen + punctuation + "+ ";
                }
            }
            res += pts[i] + " ";
        }
        System.out.println(res);
    }
}
