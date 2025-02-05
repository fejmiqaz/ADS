package Hashing;

import java.util.Objects;
import java.util.Scanner;

class Word {
    String word;

    public Word(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(word, word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }

    @Override
    public String toString() {
        return word;
    }
}

public class EnglishSpellingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n  = sc.nextInt();
        sc.nextLine();
        CBHT<String, Word> bucket = new CBHT<String, Word>(n);
        int cnt = 0;
        for(int i = 0; i < n; i++){
            String word = sc.next();
            Word w = new Word(word);
            bucket.insert(word, w);
        }
        sc.nextLine();
        String test  = sc.nextLine();
        String [] pts = test.split(" ");
        boolean flag = true;
        for (String pt : pts) {
            flag = false;
            char c = pt.charAt(pt.length() - 1);
            String checker = "";
            if(c == '?' || c == '!' || c == '.' || c == ','){
                checker = pt.substring(0, pt.length() - 1).toLowerCase();
            }else{
                checker = pt.toLowerCase();
            }
            SLLNode<MapEntry<String, Word>> node = bucket.search(checker);
            if (node != null) {
                if (checker.equals(node.element.value.word)) {
                    flag = true;
                    System.out.println(checker);
                    System.out.println(node.element.value.word);
                }
            }
        }
        if(flag){
            System.out.println("Bravo");
        }else{
            System.out.println("Golf");
        }
    }
}
