package data_structure.class_problems;

import java.util.Scanner;

public class VowelConsonantCounter {

    static boolean isVowel(char ch) {
        return "aeiou".indexOf(Character.toLowerCase(ch)) != -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int vowels = 0, consonants = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!Character.isLetter(ch)) continue;
            if (isVowel(ch)) vowels++;
            else consonants++;
        }
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
